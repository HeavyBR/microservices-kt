package ifood.domain

import ifood.domain.entity.Order
import ifood.domain.entity.Restaurant
import ifood.domain.event.OrderCancelledEvent
import ifood.domain.event.OrderCreatedEvent
import ifood.domain.event.OrderPaidEvent

interface OrderDomainService {
    fun startOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent
    fun payOrder(order: Order): OrderPaidEvent
    fun approveOrder(order: Order)
    fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent
    fun cancelOrder(order: Order, failureMessages: List<String>)
}