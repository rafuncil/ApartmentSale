package data.source

import java.io.File
import java.io.IOException

class FileLoader {

    fun readFromTextFile(path: String): List<String> =
        try {
            File(path)
                .useLines { it.toList() }
                .filter { it.isNotBlank() }
        } catch (e: IOException) {
            emptyList()
        }

}