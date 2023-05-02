package domain

import model.Apartment
import model.ApartmentStatus

class ApartmentUseCaseImpl(private val repository: ApartmentRepository) : ApartmentUseCase {
    override fun getApartmentById(id: Long): Apartment? = repository.getApartment().find { it.id == id }

    override fun getApartmentByStatus(status: ApartmentStatus): List<Apartment> =
        repository.getApartment().filter { it.status == status }

    override fun getCountOfApartmentByStatus(status: ApartmentStatus): Int = getApartmentByStatus(status).size
}