import model.ApartmentStatus

fun main(args: Array<String>) {

    val adapter = DI.createApartmentAdapter()

    //1 фича - получить количество свободных\проданных\забронированных квартир
    println(adapter.getApartmentsInfo(ApartmentStatus.Sold))
    println(adapter.getApartmentsInfo(ApartmentStatus.Free))
    println(adapter.getApartmentsInfo(ApartmentStatus.Book))
}