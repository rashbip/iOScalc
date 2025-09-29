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
        fun addDigToExp(button: AppCompatButton, digit: Char) {
            button.setOnClickListener {
                expression += digit
                textBottom.text = expression.drop(1)
            }

        }
        addDigToExp(button1, '1')
        addDigToExp(button2, '2')
        addDigToExp(button3, '3')
        addDigToExp(button4, '4')
        addDigToExp(button5, '5')
        addDigToExp(button6, '6')
        addDigToExp(button7, '7')
        addDigToExp(button8, '8')
        addDigToExp(button9, '9')
        addDigToExp(button0, '0')

        //operators
        fun setOpListener(button: AppCompatButton, op: Char) {
            button.setOnClickListener {
                if (expression.last() != op && "+-*/.".contains(expression.last()).not()) {
                    expression += op
                    textBottom.text = expression.drop(1)
                }
            }
        }
        setOpListener(buttonPlus, '+')
        setOpListener(buttonMinus, '-')
        setOpListener(buttonMult, '*')
        setOpListener(buttonDiv, '/')
        setOpListener(buttonDot, '.')

//calculation
        buttonEqual.setOnClickListener {
            if (expression.contains('/')) {
                Log.d("contains", "onCreate: /") //works
                if (expression.last() !in "+/-*") {
                    val afterDiv =
                        expression.substring(expression.indexOf('/') + 1, expression.lastIndex + 1)
                    if (afterDiv.toInt() == 0) {
                        textBottom.text = "Can't devide by zero."
                        textBottom.textSize = 45f
                        expression = "0"
                    } else {
                        textTop.text = expression
                        textBottom.text = expression.keval().toString()
                    }
                }
            } else {
                if (expression.last() !in "+/-*") {
                    textTop.text = expression
                    textBottom.text = expression.keval().toString()
                }
            }

        }
    }


}