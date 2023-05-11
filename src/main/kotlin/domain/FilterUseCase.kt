package domain

import model.Apartment

class FilterUseCase(repository: ApartmentRepository) {
    private val apartments = repository.getApartment()
    private fun filter(filter: Filter): List<Apartment> = when(filter) {
        is Filter.FilterBySize -> apartments.filter { it.apartmentSize in filter.sizeMin..filter.sizeMax }
        is Filter.FilterByPrice -> apartments.filter { it.price in filter.priceMin..filter.priceMax }
    }

    fun getIdOfFilteredApartments(filter: Filter): List<Long> = filter(filter).map { it.id }
}