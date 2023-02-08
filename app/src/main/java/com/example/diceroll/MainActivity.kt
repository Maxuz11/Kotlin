package com.example.diceroll

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            //to combine must be like this
            // val toast = Toast.makeText(this, "Dice Rolled!!", Toast.LENGTH_SHORT).show()
        }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 6
        when(diceRoll){
            luckyNumber -> println("higher")
            1 -> println("try again!!")
        }
        // Update the screen with the dice roll and convert de int to string
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}
/**las clases van aparte del mainActivity**/

class Dice(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}
