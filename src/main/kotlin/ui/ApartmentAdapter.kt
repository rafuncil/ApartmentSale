package ui

import domain.ApartmentUseCase
import model.ApartmentStatus

class ApartmentAdapter(
    private val apartmentUseCase: ApartmentUseCase,
) {
    fun getApartmentsInfo(status: ApartmentStatus) = when (status) {
        ApartmentStatus.Free -> "Количество свободных квартир составляет ${
            apartmentUseCase.getCountOfApartmentByStatus(
                status
            )
        }"

        ApartmentStatus.Sold -> "Количество проданных квартир составляет ${
            apartmentUseCase.getCountOfApartmentByStatus(
                status
            )
        }"

        ApartmentStatus.Book -> "Количество забронированных квартир составляет ${
            apartmentUseCase.getCountOfApartmentByStatus(
                status
            )
        }"
    }
}