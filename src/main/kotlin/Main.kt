import domain.Filter
import model.ApartmentStatus

fun main(args: Array<String>) {

    val adapter = DI.createApartmentAdapter()

    //1 фича - получить количество свободных\проданных\забронированных квартир
    println(adapter.getApartmentsInfo(ApartmentStatus.Sold))
    println(adapter.getApartmentsInfo(ApartmentStatus.Free))
    println(adapter.getApartmentsInfo(ApartmentStatus.Book))

    //2 фича - получить список квартир по id с указанным количеством спальных комнат
    println(adapter.getListOfApartmentsIdByBedrooms(1))
    println(adapter.getListOfApartmentsIdByBedrooms(2))
    println(adapter.getListOfApartmentsIdByBedrooms(3))

    //3 фича - получить список квартир по id в указанном диапазоне площадей
    println(
        adapter.getIdOfFilteredApartments(
            filter = Filter.FilterBySize(
                sizeMin = 30,
                sizeMax = 50
            )
        )
    )

    //4 фича - получить список квартир по id в указанном диапазоне цен
    println(
        adapter.getIdOfFilteredApartments(
            filter = Filter.FilterByPrice(
                priceMin = 1_500_000,
                priceMax = 2_000_000
            )
        )
    )
}