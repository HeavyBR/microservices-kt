package ifood.application.ports.inputs.message.listener.restaurantapproval

import ifood.application.dto.message.RestaurantApprovalResponse

interface RestaurantApprovalMessageListener {
    fun orderApproved(restaurantApprovalResponse: RestaurantApprovalResponse)
    fun orderRejected(restaurantApprovalResponse: RestaurantApprovalResponse)
}