package ifood.valueobject

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(private val amount: BigDecimal) {
    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }

    fun isGreaterThanZero(): Boolean = amount > BigDecimal.ZERO
    fun isGreaterThan(money: Money) = money.amount > amount

    fun add(money: Money): Money = Money(setScale(this.amount.add(money.amount)))
    fun subtract(money: Money): Money = Money(setScale(this.amount.subtract(money.amount)))
    fun multiply(quantity: Int): Money = Money(setScale(this.amount.multiply(BigDecimal(quantity))))


    private fun setScale(input: BigDecimal): BigDecimal {
        return input.setScale(2, RoundingMode.HALF_EVEN)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Money) return false

        return amount.compareTo(other.amount) == 0
    }

}