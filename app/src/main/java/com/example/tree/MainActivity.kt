package com.example.tree
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var operator: String = ""
    private var dur: Int = 0
    private var qat: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dur = 0
        qat = 0
        playGame()
    }
    fun ButClick (button: View) {
            if((button as Button).text == getRightAns().toString()) {
                dur++
            } else {
                qat++
            }

        if (dur + qat == 10) {
            var inter = Intent(this, Kaltor::class.java)
            inter.putExtra("right", "$dur")
            inter.putExtra("wrong", "$qat")
            finish()
            startActivity(inter)
        } else {  playGame() }
        }

    private fun playGame() {
        operator = generateRandomOperator()
        if (operator == "/"){
        firstNumber = generateRandomNumber(10, 100)
        secondNumber = generateRandomNumber(10, 100)
        do {
            firstNumber = Random.nextInt(10, 100)
            secondNumber = Random.nextInt(10,100)
        }while (firstNumber % secondNumber != 0) }
        else {
            firstNumber = Random.nextInt(10, 100)
            secondNumber = Random.nextInt(10,100)
        }

        txtView1.text = firstNumber.toString()
        txtView3.text = secondNumber.toString()
        txtView2.text = operator
        setRightAnswer()

    }

    private fun generateRandomNumber(start: Int, end: Int): Int = Random.nextInt(start, end)

    private fun generateRandomOperator(): String {
        return when (generateRandomNumber(0, 4)) {
            0 -> "+"
            1 -> "-"
            2 -> "/"
            3 -> "*"
            else -> "+"
        }
    }


    private fun genWrongNumber() {
        val answer  = getRightAns()
        val variantA = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(3, 100)
            1 -> answer + generateRandomNumber(3, 100)
            else -> answer + 5
        }
        val variantB = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(3, 100)
            1 -> answer + generateRandomNumber(3, 100)
            else -> answer + 5
        }
        val variantC = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(3, 100)
            1 -> answer + generateRandomNumber(3, 100)
            else -> answer + 5
        }
        val variantD = when (generateRandomNumber(0, 2)) {
            0 -> answer - generateRandomNumber(3, 100)
            1 -> answer + generateRandomNumber(3, 100)
            else -> answer + 5
        }

        Button1.text = variantA.toString()
        Button2.text = variantB.toString()
        Button3.text = variantC.toString()
        Button4.text = variantD.toString()
    }
  private  fun getRightAns(): Int {
        return when(operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "/" -> firstNumber / secondNumber
            "*" -> firstNumber * secondNumber
            else -> firstNumber + secondNumber
        }
    }

    fun setRightAnswer() {
        val ans = getRightAns()
        when (generateRandomNumber(0, 4)){
            0 -> Button1.text = ans.toString()
            1 -> Button2.text = ans.toString()
            2 -> Button3.text = ans.toString()
            3 -> Button4.text = ans.toString()
            else -> Button2.text = ans.toString()
        }
    }

}



