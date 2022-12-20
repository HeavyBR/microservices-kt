package ifood.domain.entity

import ifood.commons.entity.BaseEntity
import ifood.domain.valueobject.OrderItemId
import ifood.valueobject.Money
import ifood.valueobject.OrderId
import java.util.UUID

class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Money,
    val subTotal: Money,
) : BaseEntity<OrderItemId>() {
    var orderId: OrderId? = null


    fun isPriceValid() =  price.isGreaterThanZero() && price == product.price && price.multiply(quantity) == subTotal


}