package ifood.domain

import ifood.domain.entity.Order
import ifood.domain.entity.OrderItem
import ifood.domain.entity.Product
import ifood.domain.entity.Restaurant
import ifood.domain.valueobject.StreetAddress
import ifood.valueobject.CustomerId
import ifood.valueobject.Money
import ifood.valueobject.ProductId
import ifood.valueobject.RestaurantId
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal
import java.util.*

class OrderDomainServiceImplTest {

    @Test
    fun startOrder() {
        val service = OrderDomainServiceImpl()
        val event = service.startOrder(
            Order(
                CustomerId(UUID.randomUUID()),
                RestaurantId(UUID.randomUUID()),
                StreetAddress(UUID.randomUUID(), "Rua Itacolomi, 40", "13274-768", "Valinhos"),
                Money(BigDecimal(10.0)),
                listOf<OrderItem>(
                    OrderItem(
                        Product(ProductId(UUID.randomUUID()), "teste", Money(BigDecimal(10.0))),
                        1,
                        Money(BigDecimal(10.0)),
                        Money(BigDecimal(10.0)),
                    )
                )
            ),
            Restaurant(
                RestaurantId(UUID.randomUUID()),
                emptyList(),
                true
            )
        )
    }



}