package com.testwithbitraise.domain

import com.testwithbitraise.domain.ExpressionResult.*
import com.testwithbitraise.domain.Operation.*

class ExpressionConverter(
    private val firstNumber: String,
    private val operation: String,
    private val secondNumber: String
) {

    fun convert() : ExpressionResult {
        val cFirstNumber = getConvertedNumber(firstNumber) ?: return InvalidFirstNumber
        val cOperation = getOperation(operation) ?: return InvalidOperation
        val cSecondNumber = getConvertedNumber(secondNumber) ?: return InvalidSecondNumber
        
        val result = when (cOperation) {
            ADD -> cFirstNumber + cSecondNumber
            SUBTRACT -> cFirstNumber - cSecondNumber
            MULTIPLICATION -> cFirstNumber * cSecondNumber
            DIVISION -> cFirstNumber / cSecondNumber
        }

        return SuccessfulResult(result.toString())
    }

    private fun getConvertedNumber(number: String): Double? {
        return number.toDoubleOrNull()
    }
}