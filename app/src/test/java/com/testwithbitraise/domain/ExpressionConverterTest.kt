package com.testwithbitraise.domain

import com.google.common.truth.Truth.*
import com.testwithbitraise.domain.ExpressionResult.*
import org.junit.Test

class ExpressionConverterTest {

    private lateinit var converter: ExpressionConverter

    @Test
    fun `invalid first number`() {
        //1 Given
        converter = ExpressionConverter(" ", "+", "4.5")

        //2 Do something with what's given
        val actual = converter.convert()

        //3 Assert expected == actual
        val expected = InvalidFirstNumber

        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `invalid operation`() {
        converter = ExpressionConverter("3", "", "4.5")
        val actual = converter.convert()
        val expected = InvalidOperation
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `invalid second number`() {
        converter = ExpressionConverter("3", "+", "")
        val actual = converter.convert()
        val expected = InvalidSecondNumber
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `add successful`() {
        converter = ExpressionConverter("3", "+", "4.5")
        val actual = converter.convert()
        val expected = SuccessfulResult("7.5")
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `positive subtract successful`() {
        converter = ExpressionConverter("6", "-", "4.5")
        val actual = converter.convert()
        val expected = SuccessfulResult("1.5")
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `negative subtract successful`() {
        converter = ExpressionConverter("3", "-", "4.5")
        val actual = converter.convert()
        val expected = SuccessfulResult("-1.5")
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `multiplication successful`() {
        converter = ExpressionConverter("3", "x", "4.5")
        val actual = converter.convert()
        val expected = SuccessfulResult("13.5")
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `division successful`() {
        converter = ExpressionConverter("15", "/", "2.5")
        val actual = converter.convert()
        val expected = SuccessfulResult("6.0")
        assertThat(expected).isEqualTo(actual)
    }
}