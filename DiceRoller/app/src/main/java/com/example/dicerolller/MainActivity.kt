package com.example.dicerolller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dicerolller.ui.theme.DiceRolllerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        // Roll a random dice to show user at start
        rollDice()

        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    /**
     * Roll the dice and update screen with result
     */
    private fun rollDice() {
        // Create dice with 6 sides
        val dice1 = Dice(6)
        val dice1Roll = dice1.roll()
        var diceImage1: ImageView = findViewById(R.id.imageView6)

        val drawableResource1 = when (dice1Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = dice1Roll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}