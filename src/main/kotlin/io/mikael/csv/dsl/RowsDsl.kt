package io.mikael.csv.dsl

import org.apache.commons.csv.CSVRecord

@DataDslMarker
class RowsDsl {

    var validator: ((CSVRecord) -> Boolean)? = null

    fun validate(call: (CSVRecord) -> Boolean) {
        validator = call
    }

    fun panic(call: (CSVRecord) -> Boolean) {
        validator = call
    }

}
