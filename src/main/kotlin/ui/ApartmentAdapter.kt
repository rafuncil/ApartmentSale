package ui

import domain.ApartmentUseCase
import domain.ApartmentsByBedroomCountUseCase
import model.ApartmentStatus

class ApartmentAdapter(
    private val apartmentUseCase: ApartmentUseCase,
    private val apartmentsByBedroomCount: ApartmentsByBedroomCountUseCase
) {
    fun getApartmentsInfo(status: ApartmentStatus): String {
        val result = apartmentUseCase.getCountOfApartmentByStatus(status)
        return when (status) {
            ApartmentStatus.Free -> "Количество свободных квартир составляет $result"

            ApartmentStatus.Sold -> "Количество проданных квартир составляет $result"

            ApartmentStatus.Book -> "Количество забронированных квартир составляет $result"
        }
    }

    fun getListOfApartmentsIdByBedrooms(bedrooms: Int): String =
        "Список id $bedrooms-комнатных квартир " +
                "${apartmentsByBedroomCount.getListOfApartmentsIdByBedrooms(bedrooms)}"
}