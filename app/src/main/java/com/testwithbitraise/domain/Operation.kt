package com.testwithbitraise.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLICATION('x'),
    DIVISION('/')
}

fun getOperation(symbol: String) : Operation? {
    if (symbol.isBlank()) return null
    return Operation.values().find { it.symbol == symbol[0] }
}