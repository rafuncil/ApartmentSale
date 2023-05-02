package domain

fun String.toIntOrDefault(defaultValue: Int = 0): Int =
    try {
        this.toInt()
    } catch (e: NumberFormatException) {
        defaultValue
    }

fun String.toLongOrDefault(defaultValue: Long = 0): Long =
    try {
        this.toLong()
    } catch (e: NumberFormatException) {
        defaultValue
    }