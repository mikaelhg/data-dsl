package io.mikael.csv

import io.mikael.csv.dsl.DataDslMarker
import io.mikael.csv.dsl.DataReaderDsl
import org.apache.commons.csv.CSVFormat
import java.io.InputStream
import java.io.InputStreamReader

class DataReader(builder: DataReaderDsl) {

    companion object Dsl {

        @DataDslMarker
        fun csvReader(init: DataReaderDsl.() -> Unit): DataReader {
            return DataReader(DataReaderDsl().apply(init))
        }

    }

    val csvFormat: CSVFormat

    init {
        csvFormat = CSVFormat.EXCEL
    }

    fun parse(inputStream: InputStream) = csvFormat.parse(InputStreamReader(inputStream))

}