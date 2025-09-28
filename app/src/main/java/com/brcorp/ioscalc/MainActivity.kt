package com.brcorp.ioscalc

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.notkamui.keval.keval

class MainActivity : AppCompatActivity() {
    private lateinit var textTop: TextView
    private lateinit var textBottom: TextView

    private lateinit var buttonAC: AppCompatButton
    private lateinit var buttonMemory: AppCompatButton
    private lateinit var buttonPercent: AppCompatButton
    private lateinit var buttonDiv: AppCompatButton
    private lateinit var button7: AppCompatButton
    private lateinit var button8: AppCompatButton
    private lateinit var button9: AppCompatButton
    private lateinit var buttonMult: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button5: AppCompatButton
    private lateinit var button6: AppCompatButton
    private lateinit var buttonMinus: AppCompatButton
    private lateinit var button1: AppCompatButton
    private lateinit var button2: AppCompatButton
    private lateinit var button3: AppCompatButton
    private lateinit var buttonPlus: AppCompatButton
    private lateinit var button0: AppCompatButton
    private lateinit var buttonDot: AppCompatButton
    private lateinit var buttonEqual: AppCompatButton

    var expression: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textTop = findViewById(R.id.topText)
        textBottom = findViewById(R.id.bottomText)

        buttonAC = findViewById(R.id.buttonAC)
        buttonMemory = findViewById(R.id.buttonMemory)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonDiv = findViewById(R.id.buttonDiv)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonMult = findViewById(R.id.buttonMult)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        buttonMinus = findViewById(R.id.buttonMinus)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        buttonPlus = findViewById(R.id.buttonPlus)
        button0 = findViewById(R.id.button0)
        buttonDot = findViewById(R.id.buttonDot)
        buttonEqual = findViewById(R.id.buttonEqual)


        //AC button
        buttonAC.setOnClickListener {
            textTop.text = ""
            textBottom.text = "0"
            expression = "0"
        }

        //digits
        button0.setOnClickListener {
            expression += "0"
            textBottom.text = expression
        }
        button1.setOnClickListener {
            expression += "1"
            textBottom.text = expression
        }
        button2.setOnClickListener {
            expression += "2"
            textBottom.text = expression
        }
        button3.setOnClickListener {
            expression += "3"
            textBottom.text = expression
        }
        button4.setOnClickListener {
            expression += "4"
            textBottom.text = expression
        }
        button5.setOnClickListener {
            expression += "5"
            textBottom.text = expression
        }
        button6.setOnClickListener {
            expression += "6"
            textBottom.text = expression
        }
        button7.setOnClickListener {
            expression += "7"
            textBottom.text = expression
        }
        button8.setOnClickListener {
            expression += "8"
            textBottom.text = expression
        }
        button9.setOnClickListener {
            expression += "9"
            textBottom.text = expression
        }
        buttonDot.setOnClickListener {
            expression += "."
            textBottom.text = expression
        }


        //operators
        buttonPlus.setOnClickListener {
            expression += "+"
            textBottom.text = expression
        }
        buttonMinus.setOnClickListener {
            expression += "-"
            textBottom.text = expression
        }
        buttonMult.setOnClickListener {
            expression += "*"
            textBottom.text = expression
        }
        buttonDiv.setOnClickListener {
            expression += "/"
            textBottom.text = expression
        }

        //calculation
        buttonEqual.setOnClickListener {
            textTop.text = expression
            textBottom.text = expression.keval().toString()
        }
    }

}
