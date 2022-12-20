package ifood.application.ports.inputs.service

import ifood.application.dto.create.CreateOrderCommand
import ifood.application.dto.create.CreateOrderResponse
import ifood.application.dto.track.TrackOrderQuery
import ifood.application.dto.track.TrackOrderResponse
import javax.validation.Valid

interface OrderApplicationService {
    fun createOrder(@Valid createOrderCommand: CreateOrderCommand): CreateOrderResponse
    fun trackOrder(trackOrderQuery: TrackOrderQuery): TrackOrderResponse

}