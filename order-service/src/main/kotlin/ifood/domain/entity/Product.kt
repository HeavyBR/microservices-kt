package ifood.domain.entity

import ifood.commons.entity.BaseEntity
import ifood.valueobject.Money
import ifood.valueobject.ProductId

class Product( id: ProductId, val name: String, val price: Money) : BaseEntity<ProductId>(id)