package model

data class Employee(
    val id: Long, //уникальный номер работника/продавца
    val name: String, //имя работника/продавца
) {
    companion object {
        const val FIELDS_COUNT = 2
    }
}