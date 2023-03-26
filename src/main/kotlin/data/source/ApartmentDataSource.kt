package data.source

import model.Apartment
import model.Customer
import model.Employee
import model.Order

/*
* Интерфейс, который позволяет нам получать данные из любых источников
* */
interface ApartmentDataSource {
    fun getApartment(): List<Apartment>
    fun getCustomers(): List<Customer>
    fun getEmployees(): List<Employee>
    fun getOrders(): List<Order>
}