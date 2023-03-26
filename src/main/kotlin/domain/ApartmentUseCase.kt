package domain

import model.Apartment
import model.ApartmentStatus

interface ApartmentUseCase {
    //Возвращает квартиру по его id
    fun getApartmentById(id: Long): Apartment?

    //Возвращает квартиру указаного статуса (свободные, забронированные, проданные)
    fun getApartmentByStatus(status: ApartmentStatus): List<Apartment>

    //Возвращает количество квартир с указанным статусом
    fun getCountOfApartmentByStatus(status: ApartmentStatus): Int
}
