package com.example.numbers4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import kotlin.toString as toString1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun estimation  (view: View) {
        val button = findViewById<Button>(R.id.button) // Добавить оценку
        val btn = findViewById<Button>(R.id.srButton2) // Вычислить средний балл
        val text = findViewById<TextView>(R.id.textView3) // Текст со средним баллом
        val ok = findViewById<Button>(R.id.okButton3)

        var count = 0
        var sr = 0

        button.setOnClickListener {
            var estimation = findViewById<EditText>(R.id.editTextNumber2).text.toString()
            var kol = findViewById<EditText>(R.id.kolEditTextNumber).text.toString()
            if (!estimation.equals("") && !kol.equals("")) {
                if (estimation.toInt() <= 5 && estimation.toInt() != 0) {
                    sr = sr + estimation.toInt()
                    count++
                }
                else {
                    val toast = Toast.makeText(this, "Вы ввели ошибочную оценку", Toast.LENGTH_LONG).show()
                }

                val res = when {
                    count == kol.toInt() -> {
                        button.isClickable = false
                        val toast = Toast.makeText(this, "Вы ввели все оценки, которые запланировали", Toast.LENGTH_LONG).show()
                    }
                    else -> button.isClickable = true
                }
            }
            else {
                val toast = Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_LONG).show()

            }
        }

        btn.setOnClickListener {
            var kol = findViewById<EditText>(R.id.kolEditTextNumber).text.toString().toInt()
            var res = sr.toFloat() / kol.toFloat()
            text.text = "Среднее арефметическое оценок ученика составляет $res"
        }

        ok.setOnClickListener {
            var kol = findViewById<EditText>(R.id.kolEditTextNumber).text.toString()
            if (!kol.equals("")) {
                var kol = findViewById<EditText>(R.id.kolEditTextNumber).text.toString().toInt()
                button.isClickable = true
                text.text = ""
                count = 0
                sr = 0
            }
            else {
                val toast = Toast.makeText(this, "Пожалуйста, заполните поле", Toast.LENGTH_LONG).show()
            }
        }
    }
}

