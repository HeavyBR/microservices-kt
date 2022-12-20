package ifood.domain.entity

import ifood.commons.entity.AggregateRoot
import ifood.valueobject.CustomerId

class Customer(id: CustomerId): AggregateRoot<CustomerId>(id)