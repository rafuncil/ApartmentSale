package model

data class Customer(
    val id: Long, //уникальный номер покупателя
    val name: String, //имя покупателя
    val phone: String //номер телефона покупателя
)
