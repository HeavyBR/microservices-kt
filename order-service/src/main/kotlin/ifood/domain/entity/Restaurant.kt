package ifood.domain.entity

import ifood.commons.entity.AggregateRoot
import ifood.valueobject.RestaurantId

class Restaurant(
    id: RestaurantId,
    val products: List<Product>,
    val active: Boolean
) : AggregateRoot<RestaurantId>(id)