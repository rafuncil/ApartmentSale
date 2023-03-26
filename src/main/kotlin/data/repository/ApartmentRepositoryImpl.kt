package data.repository

import data.source.ApartmentDataSource
import domain.ApartmentRepository
import model.Apartment
import model.Customer
import model.Employee
import model.Order


class ApartmentRepositoryImpl(private val dataSource: ApartmentDataSource) : ApartmentRepository {
    override fun getApartment(): List<Apartment> = dataSource.getApartment()

    override fun getCustomers(): List<Customer> = dataSource.getCustomers()

    override fun getEmployees(): List<Employee> = dataSource.getEmployees()

    override fun getOrders(): List<Order> = dataSource.getOrders()
}