package com.example.calculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstNumber: EditText = findViewById(R.id.etFirstNumber)
        val etSecondNumber: EditText = findViewById(R.id.etSecondNumber)
        val spinnerOperation: Spinner = findViewById(R.id.spinnerOperation)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toDoubleOrNull()
            val secondNumber = etSecondNumber.text.toString().toDoubleOrNull()
            val operation = spinnerOperation.selectedItem.toString()

            if (firstNumber == null || secondNumber == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = when (operation) {
                "Addition" -> firstNumber + secondNumber
                "Subtraction" -> firstNumber - secondNumber
                "Multiplication" -> firstNumber * secondNumber
                "Division" -> {
                    if (secondNumber == 0.0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    } else {
                        firstNumber / secondNumber
                    }
                }
                else -> 0.0
            }

            tvResult.text = "Result: $result"
        }
    }
}
