# Kotlin DSL for reading CSV files

```
val reader = csvReader {

    fileFormat {
        delimiter = ","
        quote = "\""
        recordSeparator = "\r\n"
    }

    columns {
        val numeral = "[0-9]".toRegex()

        /** Fully spelled out. */
        1 with {
            named { "id" }
            typed<Int>()
            validate { value -> numeral.matches(value) }
            convert { value -> value.toInt() }
        }

        /** Shortcut. */
        2 convert { it.toFloat() }

        /** Column name from CSV header. */
        "value" with {

        }

    }

}
```
