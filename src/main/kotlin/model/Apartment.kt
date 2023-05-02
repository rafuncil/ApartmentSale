package model

data class Apartment(
    val id: Long, //уникальный номер квартиры
    val address: String, //адрес объекта: Название ЖК, этаж
    val bedrooms: Int, //количество спальных комнат
    val apartmentSize: Int, //общая площаль квартиры
    val price: Int, //цена при покупке
    val status: ApartmentStatus //актуальный статус квартиры (продана, свободна, бронь)
) {
    companion object {
        const val FIELDS_COUNT = 6
    }
}