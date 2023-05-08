package domain

import model.Apartment

class ApartmentsByBedroomCountUseCase(private val repository: ApartmentRepository) {
    private fun getListOfApartmentByBedrooms(bedrooms: Int): List<Apartment> =
        repository.getApartment().filter { it.bedrooms == bedrooms }

    fun getListOfApartmentsIdByBedrooms(bedrooms: Int): List<Long> =
        getListOfApartmentByBedrooms(bedrooms).map { it.id }
}