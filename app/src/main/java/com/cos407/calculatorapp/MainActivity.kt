package com.cos407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText1 = findViewById<EditText>(R.id.editTextNumber)
        val editText2 = findViewById<EditText>(R.id.editTextNumber2)

        val add = findViewById<Button>(R.id.button)
        val minus = findViewById<Button>(R.id.button2)
        val multiply = findViewById<Button>(R.id.button3)
        val divide = findViewById<Button>(R.id.button4)

        add.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val number1: Int = userInput1.toIntOrNull() ?: 0

            val userInput2 = editText2.text.toString()
            val number2 = userInput2.toIntOrNull() ?: 0

            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("extra_message", (number1 + number2).toString())

            startActivity(intent)

        }

        minus.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val number1: Int = userInput1.toIntOrNull() ?: 0

            val userInput2 = editText2.text.toString()
            val number2 = userInput2.toIntOrNull() ?: 0

            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("extra_message", (number1 - number2).toString())

            startActivity(intent)

        }

        multiply.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val number1: Int = userInput1.toIntOrNull() ?: 0

            val userInput2 = editText2.text.toString()
            val number2 = userInput2.toIntOrNull() ?: 0

            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("extra_message", (number1 * number2).toString())

            startActivity(intent)

        }

        divide.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val number1: Int = userInput1.toIntOrNull() ?: 0

            val userInput2 = editText2.text.toString()
            val number2 = userInput2.toIntOrNull() ?: 0


            if (number2 == 0) {
                Toast.makeText(this, "cannot divide by 0", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("extra_message", (number1 / number2).toString())

                startActivity(intent)
            }

        }
    }
}