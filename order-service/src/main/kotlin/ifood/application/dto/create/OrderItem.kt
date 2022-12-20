package ifood.application.dto.create

import java.math.BigDecimal
import java.util.UUID

class OrderItem(val productId: UUID, val quantity: Int, val price: BigDecimal, val subTotal: BigDecimal)