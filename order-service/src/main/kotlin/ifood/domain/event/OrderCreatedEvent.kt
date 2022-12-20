package ifood.domain.event

import ifood.domain.entity.Order
import java.time.ZonedDateTime


class OrderCreatedEvent(order: Order, createdAt: ZonedDateTime) : OrderEvent(order, createdAt)