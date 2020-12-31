# Kotlin DSL for reading CSV files

```

val reader = csvReader {

    fileFormat {
        delimiter = ","
        quote = "\""
        recordSeparator = "\r\n"
    }

    columns {
    }

}


```
