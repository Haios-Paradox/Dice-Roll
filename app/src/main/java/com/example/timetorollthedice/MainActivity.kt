package com.example.timetorollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView
    private lateinit var diceNumber : TextView
    private lateinit var countNumber : TextView

    private var dice1 = 0
    private var dice2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceNumber = findViewById(R.id.dice_number)
        countNumber = findViewById(R.id.count_number)
        val rollButton1 : Button = findViewById(R.id.roll_button1)
        val rollButton2 : Button = findViewById(R.id.roll_button2)
        val countButton : Button = findViewById(R.id.count_button)
        val resetButton : Button = findViewById(R.id.reset_button)

        rollButton1.setOnClickListener{(rollDice(1))}
        rollButton2.setOnClickListener{(rollDice(2))}
        countButton.setOnClickListener{(countUp())}
        resetButton.setOnClickListener{(reset())}
    }

    private fun rollDice(i: Int) {
        val dice = (1..6).random()

        val imageSource = when(dice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        when(i){
            1 -> {
                diceImage1.setImageResource(imageSource)
                dice1=dice
            }
            2 -> {
                diceImage2.setImageResource(imageSource)
                dice2=dice
            }
        }
        diceNumber.text = (dice1 + dice2).toString()
    }

    private fun countUp(){
        var count = countNumber.text.toString().toInt()
        if(count<6)count++
        countNumber.text = count.toString()
    }

    private fun reset(){

        diceNumber.text = getString(R.string.message_label)
        countNumber.text = "1"
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)

    }
}