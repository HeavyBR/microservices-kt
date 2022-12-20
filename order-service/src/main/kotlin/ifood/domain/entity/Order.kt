package ifood.domain.entity

import ifood.commons.entity.AggregateRoot
import ifood.commons.exception.DomainException
import ifood.domain.exception.OrderDomainException
import ifood.domain.valueobject.OrderItemId
import ifood.domain.valueobject.StreetAddress
import ifood.domain.valueobject.TrackingId
import ifood.valueobject.*
import java.util.*

class Order(
    private val customerId: CustomerId,
    private val restaurantId: RestaurantId,
    private val streetAddress: StreetAddress,
    private val price: Money,
    private val items: List<OrderItem>,
) : AggregateRoot<OrderId>(OrderId(UUID.randomUUID())) {

    private var trackingId: TrackingId = TrackingId(UUID.randomUUID())
    private var orderStatus: OrderStatus = OrderStatus.PENDING
    private var failureMessages: List<String> = emptyList()

    init {

        if (!price.isGreaterThanZero()) throw OrderDomainException("The price must be greater than zero")

        items.forEachIndexed { index, el ->
            if (!el.isPriceValid()) throw OrderDomainException("Order item price: ${el.price} is not valid for product ${el.product.id}")
            el.id = OrderItemId(index.toLong())
            el.orderId = this.id
        }


        val totalSubPrice = items.map { it.subTotal }.fold(Money.ZERO) { acc, subTotal -> acc.add(subTotal) }

        if (totalSubPrice != price) throw OrderDomainException("Total price: $price is not equal to Order items total: $totalSubPrice")
    }


    fun pay() {
        when (orderStatus) {
            OrderStatus.PENDING -> orderStatus = OrderStatus.PAID
            else -> throw OrderDomainException("Order is not in correct state for pay operation")
        }
    }

    fun approve() {
        if (orderStatus != OrderStatus.PAID) {
            throw OrderDomainException("Order is not in correct state for approve operation")
        }

        orderStatus = OrderStatus.APPROVED
    }

    fun initCancel(failureMessages: List<String> ) {
        when (orderStatus) {
            OrderStatus.PAID -> throw OrderDomainException("Order it not in correct state for initCancel operation")
            else -> {
                orderStatus = OrderStatus.CANCELLING
                this.failureMessages.plus(failureMessages.filterNot { it.isEmpty() })
            }
        }
    }


    fun cancel() {
        when(orderStatus) {
            OrderStatus.CANCELLING, OrderStatus.PENDING -> orderStatus = OrderStatus.CANCELLED
            else ->  throw OrderDomainException("Order it not in correct state for cancel operation")
        }
    }

}