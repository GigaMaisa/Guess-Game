package com.example.guess_game_maisuradze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userInputEditText = findViewById<EditText>(R.id.userinputNumber)
        val playButton = findViewById<Button>(R.id.guessNumberBtn)
        val ImageView = findViewById<ImageView>(R.id.imageView)
        val showAttempts = findViewById<TextView>(R.id.showAttempts)
        val tryAgainButton = findViewById<Button>(R.id.tryAgainBtn)
        val scoreNumber = findViewById<TextView>(R.id.scoreNumber)
        val playername = findViewById<EditText>(R.id.playernameEditText) as EditText

        val player = Game()
        player.generateNumber()

        showAttempts.text = player.currentTry.toString()
        scoreNumber.text = player.scoreNumber.toString()
        playername.text = player.playerName1

        playButton.setOnClickListener {
            Log.d("USERCLICK", "BUTTON CLICKED")
            Log.d("GUESS NUMBER",player.numberToGuess.toString())
            Log.i("USER_INPUT",userInputEditText.text.toString())
            val toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)



            val toast_win = Toast.makeText(this,"${playername.text} ,Congrats",Toast.LENGTH_SHORT)
            toast_win.setGravity(Gravity.CENTER, 0, 0)


            val toast_lose = Toast.makeText(this,"${playername.text} ,Unfortunate",Toast.LENGTH_SHORT)
            toast_lose.setGravity(Gravity.CENTER, 0, 0)


            if( player.currentTry > 0){
                val userNumber = userInputEditText.text.toString().toInt()

                if (player.guessNumber(userNumber)){
                    ImageView.setImageResource(R.drawable.green)
                    toast_win.show()
                    player.scoreNumber += 25
                    scoreNumber.text = player.scoreNumber.toString()
                    player.restartGame()
                    showAttempts.text = player.currentTry.toString()
                }
                else {
                    ImageView.setImageResource(R.drawable.red)
                    toast_lose.show()
                    player.scoreNumber -= 5
                    scoreNumber.text = player.scoreNumber.toString()
                    player.currentTry -= 1
                    showAttempts.text = player.currentTry.toString()
                }
                userInputEditText.text = null

            }
            else {
                toast.setText("You have lost.There are no more attempts")
            }


        }
        tryAgainButton.setOnClickListener {
            ImageView.setImageResource(R.drawable.manuchar)
            player.restartGame()
            player.scoreNumber -= 10
            scoreNumber.text = player.scoreNumber.toString()
            showAttempts.text = player.currentTry.toString()
            userInputEditText.text = null
            playername.text = null

        }
    }
}