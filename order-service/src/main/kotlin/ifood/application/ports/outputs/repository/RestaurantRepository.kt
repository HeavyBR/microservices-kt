package ifood.application.ports.outputs.repository

import ifood.domain.entity.Restaurant

interface RestaurantRepository {
    fun findRestaurantInformation(restaurant: Restaurant)
}