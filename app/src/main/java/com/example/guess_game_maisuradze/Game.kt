package com.example.guess_game_maisuradze

import android.widget.Toast

class Game {
    val MAX_TRY:Int = 3
    val MAX_SCORE:Int = 100
    var limit = 10;
    var numberToGuess: Int = 0
    var currentTry:Int = MAX_TRY
    var scoreNumber:Int = MAX_SCORE
    var playerName1 = null


    fun generateNumber() {
        numberToGuess = (1..limit).random();
    }

    fun guessNumber(userNumber: Int):Boolean{
        return userNumber == numberToGuess;

    }

    fun restartGame() {
        currentTry = MAX_TRY
        generateNumber()
    }


}