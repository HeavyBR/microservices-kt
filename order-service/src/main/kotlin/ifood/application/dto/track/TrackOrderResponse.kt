package ifood.application.dto.track


import ifood.valueobject.OrderStatus
import java.util.UUID

class TrackOrderResponse(
    val trackingId: UUID,
    val orderStatus: OrderStatus,
    val failureMessages: List<String>
)