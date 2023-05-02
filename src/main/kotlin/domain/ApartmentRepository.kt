package domain

import model.Apartment
import model.Customer
import model.Employee
import model.Order

/*
* Интерфейс, который позволяет нам собрать данные в один источник для дальнейшего использования
* верхними модулями (слоями, например, слой бизнес логики)
* */
interface ApartmentRepository {
    fun getApartment(): List<Apartment>
    fun getCustomers(): List<Customer>
    fun getEmployees(): List<Employee>
    fun getOrders(): List<Order>
}