package com.swapnull.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoll.setOnClickListener { rollDice() }
        btnCountUp.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        tvRollCount.text = randomInt.toString()
    }

    private fun countUp() {

        if(tvRollCount.text.toString() == "Hello World!") {
            tvRollCount.text = "1"
        }else {
            var currentCount = tvRollCount.text.toString().toInt()

            if(currentCount < 6) {
                currentCount++
                tvRollCount.text = currentCount.toString()
            }
        }

    }

}