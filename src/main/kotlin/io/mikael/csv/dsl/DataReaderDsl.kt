package io.mikael.csv.dsl

@DataDslMarker
class DataReaderDsl {

    val columns = ColumnsDsl()

    val rows = RowsDsl()

    @DataDslMarker
    fun columns(init: ColumnsDsl.() -> Unit) = columns.init()

    /**
     * Foo bar baz xyzzy.
     */
    @DataDslMarker
    fun rows(init: RowsDsl.() -> Unit) = rows.init()

}
