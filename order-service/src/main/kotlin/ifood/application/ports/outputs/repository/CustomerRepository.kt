package ifood.application.ports.outputs.repository

import ifood.domain.entity.Customer
import java.util.*

interface CustomerRepository {
    fun findCustomer(customerId: UUID): Customer
}