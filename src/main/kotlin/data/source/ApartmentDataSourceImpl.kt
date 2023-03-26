package data.source

import domain.toLongOrDefault
import model.Apartment
import model.Customer
import model.Employee
import model.Order

class ApartmentDataSourceImpl(private val parser: CsvParser, private val loader: FileLoader) : ApartmentDataSource {
    override fun getApartment(): List<Apartment> {
        val apartmentLines = loader.readFromTextFile(Constants.APARTMENTS_FILE_PATH)
        val parsedApartments = parser.parse(apartmentLines, Constants.DELIMITER_SEMICOLON)

        return parsedApartments
            .filter { it.size == Apartment.FIELDS_COUNT }
            .mapToApartments()
    }

    override fun getCustomers(): List<Customer> {
        val customerLines = loader.readFromTextFile(Constants.CUSTOMERS_FILE_PATH)
        val parsedCustomers = parser.parse(customerLines, Constants.DELIMITER_SEMICOLON)

        return parsedCustomers
            .filter { it.size == Customer.FIELDS_COUNT }
            .mapToCustomer()
    }

    override fun getEmployees(): List<Employee> {
        val employeeLines = loader.readFromTextFile(Constants.EMPLOYEES_FILE_PATH)
        val parsedEmployees = parser.parse(employeeLines, Constants.DELIMITER_SEMICOLON)

        return parsedEmployees
            .filter { it.size == Employee.FIELDS_COUNT }
            .mapToEmployee()
    }

    override fun getOrders(): List<Order> {
        val ordersLines = loader.readFromTextFile(Constants.ORDERS_FILE_PATH)
        val parsedOrders = parser.parse(ordersLines, Constants.DELIMITER_SEMICOLON)

        return parsedOrders
            .filter { it.size == Order.FIELDS_COUNT }
            .map {
                it.mapToOrder(parser.parse(it[3], Constants.DELIMITER_COMMA).map { it.toLongOrDefault() }
                    .toLongArray())
            }
    }
}