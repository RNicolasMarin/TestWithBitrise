package com.testwithbitraise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testwithbitraise.databinding.ActivityMainBinding
import com.testwithbitraise.domain.ExpressionConverter
import com.testwithbitraise.domain.ExpressionResult

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            calculateBt.setOnClickListener {
                val firstNumber     = firstNumberEt.text.toString()
                val symbol          = symbolEt.text.toString()
                val secondNumber    = secondNumberEt.text.toString()

                val converter = ExpressionConverter(firstNumber, symbol, secondNumber)

                when (val result = converter.convert()) {
                    ExpressionResult.InvalidFirstNumber -> {
                        loadErrors(getString(R.string.invalid_number), "", "")
                    }
                    ExpressionResult.InvalidOperation -> {
                        loadErrors( "", getString(R.string.invalid_symbol), "")
                    }
                    ExpressionResult.InvalidSecondNumber -> {
                        loadErrors( "", "", getString(R.string.invalid_number))
                    }
                    is ExpressionResult.SuccessfulResult -> {
                        loadErrors("", "", "")
                        firstNumberEt.setText("")
                        symbolEt.setText("")
                        secondNumberEt.setText("")
                        resultTv.text = result.value
                    }
                }
            }
        }
    }

    private fun loadErrors(
        firstNumberError: String,
        symbolError: String,
        secondNumberError: String
    ) = with(binding) {
        firstNumberIl.error = firstNumberError
        symbolIl.error = symbolError
        secondNumberIl.error = secondNumberError
    }
}