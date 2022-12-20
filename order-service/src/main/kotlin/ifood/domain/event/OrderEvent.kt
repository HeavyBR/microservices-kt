package ifood.domain.event

import ifood.commons.event.DomainEvent
import ifood.domain.entity.Order
import java.time.ZonedDateTime

open class OrderEvent(val order: Order, val createdAt: ZonedDateTime) : DomainEvent<Order>