package com.testwithbitraise.domain

sealed interface ExpressionResult {

    object InvalidFirstNumber : ExpressionResult

    object InvalidSecondNumber : ExpressionResult

    object InvalidOperation : ExpressionResult

    data class SuccessfulResult(
        val value: String
    ) : ExpressionResult
}