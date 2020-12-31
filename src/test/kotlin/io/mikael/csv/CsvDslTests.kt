package io.mikael.csv

import io.mikael.csv.DataReader.Dsl.csvReader
import org.junit.jupiter.api.Test

class CsvDslTests {

    @Test
    fun simpleDslTest() {

        val reader = csvReader {
            val numeral = "[0-9]".toRegex()

            columns {

                1 with {
                    named { "id" }
                    typed<Int>()
                    validate { value -> numeral.matches(value) }
                    convert { value -> value.toInt() }
                    /* panic<Int>("over 9000") { it > 9000 } */
                }

                2 convert { it.toFloat() }

                "value" with {

                }

            }

            rows {
                validate { it.isConsistent }
                panic { row -> false }
            }

        }

    }

}
