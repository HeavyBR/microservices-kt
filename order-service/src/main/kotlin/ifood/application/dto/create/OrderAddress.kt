package ifood.application.dto.create

import javax.validation.constraints.Max
import javax.validation.constraints.NotNull

class OrderAddress(
    @field:Max(value = 50) val street: String,
    @field:Max(value = 8) val postalCode: String,
    @field:Max(value = 50) val city: String
)