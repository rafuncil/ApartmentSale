package data.source

import domain.toIntOrDefault
import domain.toLongOrDefault
import model.*

fun List<List<String>>.mapToApartments(): List<Apartment> = this.map {
    Apartment(
        id = it[0].trim().toLongOrDefault(),
        address = it[1].trim(),
        bedrooms = it[2].trim().toIntOrDefault(),
        apartmentSize = it[3].toIntOrDefault(),
        price = it[4].toIntOrDefault(),
        status = ApartmentStatus.fromString(it[5])
    )
}

fun List<List<String>>.mapToCustomer(): List<Customer> = this.map {
    Customer(
        id = it[0].trim().toLongOrDefault(),
        name = it[1].trim(),
        phone = it[2].trim(),
    )
}

fun List<List<String>>.mapToEmployee(): List<Employee> = this.map {
    Employee(
        id = it[0].trim().toLongOrDefault(),
        name = it[1].trim()
    )
}

fun List<String>.mapToOrder(apartments: LongArray): Order =
    Order(
        id = this[0].trim().toLongOrDefault(),
        customerId = this[1].trim().toLongOrDefault(),
        employeeId = this[2].trim().toLongOrDefault(),
        apartments = apartments
    )