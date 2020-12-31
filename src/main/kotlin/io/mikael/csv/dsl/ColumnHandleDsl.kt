package io.mikael.csv.dsl

@DataDslMarker
open class ColumnHandleDsl<T: Any> {

    var columnValidator: ((String) -> Boolean)? = null

    var columnConverter: ((String) -> Any)? = null

    var columnNamer: (() -> String)? = null

    var columnTypeClass: Class<*> = Any::class.java

    infix fun named(name: String) = named { name }

    inline fun <reified T> typed(klass: Class<T>) {
        columnTypeClass = klass
    }

    inline fun <reified T> typed() = typed(T::class.java)

    infix fun named(call: () -> String) {
        columnNamer = call
    }

    /**
     * Validate the raw string cell value before conversion.
     */
    fun validate(call: (String) -> Boolean) {
        columnValidator = call
    }

    fun <T: Any>convert(call: (String) -> T) {
        columnConverter = call
    }

}
