package model

enum class ApartmentStatus {
    Sold, //продана
    Book, //забронирована
    Free; //свободна

    companion object {
        fun fromString(status: String): ApartmentStatus = values().find { it.name == status } ?: Free
    }
}