package ifood.application.dto.create

import ifood.valueobject.OrderStatus
import java.util.UUID

class CreateOrderResponse(val orderTrackingId: UUID, val orderStatus: OrderStatus, val message: String)