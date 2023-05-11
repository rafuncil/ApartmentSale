import data.repository.ApartmentRepositoryImpl
import data.source.ApartmentDataSource
import data.source.ApartmentDataSourceImpl
import data.source.CsvParser
import data.source.FileLoader
import domain.ApartmentRepository
import domain.ApartmentUseCase
import domain.ApartmentUseCaseImpl
import domain.ApartmentsByBedroomCountUseCase
import ui.ApartmentAdapter

object DI {
    //зависимости для слоя data
    fun createFileLoader(): FileLoader = FileLoader()
    fun createCsvParsr(): CsvParser = CsvParser()
    fun createDataSource(): ApartmentDataSource = ApartmentDataSourceImpl(createCsvParsr(), createFileLoader())
    fun createRepository(): ApartmentRepository = ApartmentRepositoryImpl(createDataSource())

    //зависимости для слоя domain
    fun createApartmentUseCase(): ApartmentUseCase = ApartmentUseCaseImpl(createRepository())
    fun createApartmentsByBedrromCount(): ApartmentsByBedroomCountUseCase =
        ApartmentsByBedroomCountUseCase(createRepository())

    //зависимости для слоя UI
    fun createApartmentAdapter() = ApartmentAdapter(
        apartmentUseCase = createApartmentUseCase(),
        apartmentsByBedroomCount = createApartmentsByBedrromCount()
    )

}