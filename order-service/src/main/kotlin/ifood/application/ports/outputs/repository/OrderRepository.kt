package ifood.application.ports.outputs.repository

import ifood.domain.entity.Order
import ifood.domain.valueobject.TrackingId

interface OrderRepository {
    fun save(order: Order): Order
    fun findByTrackingId(trackingId: TrackingId): Order
}