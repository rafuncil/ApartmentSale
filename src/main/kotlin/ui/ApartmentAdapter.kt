package ui

import domain.ApartmentUseCase
import domain.ApartmentsByBedroomCountUseCase
import domain.Filter
import domain.FilterUseCase
import model.ApartmentStatus

class ApartmentAdapter(
    private val apartmentUseCase: ApartmentUseCase,
    private val apartmentsByBedroomCount: ApartmentsByBedroomCountUseCase,
    private val filterUseCase: FilterUseCase,
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

    fun getIdOfFilteredApartments(filter: Filter): String = when (filter) {
        is Filter.FilterBySize -> "Список id квартир в диапозоне " +
                "от ${filter.sizeMin} до ${filter.sizeMax} кв.м.: " +
                "${filterUseCase.getIdOfFilteredApartments(filter)}"

        is Filter.FilterByPrice -> "Список id квартир в диапозоне" +
                "от ${filter.priceMin} до ${filter.priceMax} руб.:" +
                " ${filterUseCase.getIdOfFilteredApartments(filter)}"
    }

}