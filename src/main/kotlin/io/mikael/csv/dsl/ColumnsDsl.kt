package io.mikael.csv.dsl

@DataDslMarker
class ColumnsDsl {

    val handlers = mutableListOf<ColumnHandleDsl<*>>()

    inline infix fun <reified T: Any>Int.convert(call: (String) -> T) {
    }

    @DataDslMarker
    fun <T: Any> Int.with(klass: Class<T>, call: ColumnHandleDsl<T>.() -> Unit) {
        handlers.add(ColumnHandleDsl<T>().apply(call))
    }

    @DataDslMarker
    infix fun Int.with(call: ColumnHandleDsl<*>.() -> Unit) {
        handlers.add(ColumnHandleDsl<Any>().apply(call))
    }

    @DataDslMarker
    infix fun String.with(call: ColumnHandleDsl<*>.() -> Unit) {
        handlers.add(ColumnHandleDsl<Any>().apply(call))
    }

}
