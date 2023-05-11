package domain

import model.Apartment

sealed class Filter {
    class FilterBySize(val sizeMin: Int, val sizeMax: Int) : Filter()
    class FilterByPrice(val priceMin: Int, val priceMax: Int) : Filter()
}
