package ifood.domain

import ifood.domain.entity.Order
import ifood.domain.entity.Restaurant
import ifood.domain.event.OrderCancelledEvent
import ifood.domain.event.OrderCreatedEvent
import ifood.domain.event.OrderPaidEvent
import ifood.domain.exception.OrderDomainException
import org.slf4j.Logger
import org.slf4j.simple.SimpleLogger
import org.slf4j.simple.SimpleLoggerFactory
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

class OrderDomainServiceImpl : OrderDomainService {

    private val log: Logger = SimpleLoggerFactory().getLogger(OrderDomainServiceImpl::class.simpleName)
    override fun startOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent {
        validateRestaurant(restaurant)
        setOrderProductInformation(order, restaurant)
        log.info("Order with id: ${order.id} is initialized")
        return OrderCreatedEvent(order, nowUTC())
    }

    override fun payOrder(order: Order): OrderPaidEvent {
        order.pay()
        log.info("Order with id: ${order.id} is paid")

        return OrderPaidEvent(order, nowUTC())
    }

    override fun approveOrder(order: Order) {
        order.approve()
        log.info("Order with id ${order.id} is approved")
    }

    override fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent {
        order.initCancel(failureMessages)
        log.info("Order payment is cancelling for order id: $order.id")
        return OrderCancelledEvent(order, nowUTC())
    }

    override fun cancelOrder(order: Order, failureMessages: List<String>) {
        order.cancel()
        log.info("Order with id: ${order.id} is cancelled")
    }

    private fun validateRestaurant(restaurant: Restaurant) {
        if(!restaurant.active) throw OrderDomainException("Restaurant with id ${restaurant.id} is currently inactive")
    }

    private fun setOrderProductInformation(order: Order, restaurant: Restaurant) {

    }

    private fun nowUTC() =  ZonedDateTime.now(ZoneId.of("UTC"))
}