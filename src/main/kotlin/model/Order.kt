package model

data class Order(
    val id: Long, //уникальный номер заявки
    val customerId: Long, //уникальный номер покупателя
    val employeeId: Long, //уникальный номер работника/продавца
    val apartments: LongArray //список уникальных номеров проданных квартир

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false
        if (customerId != other.customerId) return false
        if (employeeId != other.employeeId) return false
        if (!apartments.contentEquals(other.apartments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + customerId.hashCode()
        result = 31 * result + employeeId.hashCode()
        result = 31 * result + apartments.contentHashCode()
        return result
    }
}
