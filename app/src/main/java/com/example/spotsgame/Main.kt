package com.example.spotsgame

import android.annotation.SuppressLint
import kotlin.random.Random

fun main() {
    println("Welcome to the Spot Game")
    val playingChips = Array(16){ it + 1 }
    playingChips.shuffle()
    do {
        displayPlayingField(playingChips)
        print("Enter number You want to move or \"q\" for quit : ")
        val step = readln()
        val numberForMove: Int? = step.toIntOrNull()
        if(numberForMove != null) {
            if(isInputValid(playingChips, numberForMove.toInt())) {
                val indexFromMove = playingChips.indexOf(numberForMove)
                val indexToMove = playingChips.indexOf(16)
                playingChips[indexFromMove] = playingChips[indexToMove].also { playingChips[indexToMove] = playingChips[indexFromMove]}
            }
        }
    } while (numberForMove != null)
    println(
        """Thank You for playing!
           |GoodLuck!""".trimMargin())
}

@SuppressLint("DefaultLocale")
fun displayPlayingField(playingChips: Array<Int>) {
    println("----------------------")
    for (i in 0 until 4) {
        print("|   ")
        for(j in 0 until 4) {
            if (playingChips[i * 4 + j] == 16) {
                print("  \t")
            }
            else print(String.format("%2d\t",playingChips[i * 4 + j]))
            }
        println(" |")
    }
    println("----------------------")
}

fun isInputValid(playingChips: Array<Int>, number: Int): Boolean {
    return isInputInRange(number) && isStepPossible(playingChips, number)
}

fun isInputInRange(number: Int): Boolean {
    if(number in 1..15) {
        return true
    } else {
        println("Warning!!!  Number has to be from 1 to 15 (all inclusive). Please enter correct value.")
        return false
    }

}

fun isStepPossible(inputArray: Array<Int>, numberForMove: Int): Boolean {
    val indexToMove = inputArray.indexOf(numberForMove)
    val result =  when(indexToMove) {
        0 -> inputArray[1] == 16 || inputArray[4] == 16
        1,2 -> inputArray[indexToMove - 1] == 16|| inputArray[indexToMove + 1] == 16 || inputArray[indexToMove + 4] == 16
        3 -> inputArray[2] == 16 || inputArray[7] == 16
        12 -> inputArray[8] == 16 || inputArray[13] == 16
        4,8 -> inputArray[indexToMove - 4] == 16 || inputArray[indexToMove + 1] == 16 || inputArray[indexToMove + 4] == 16
        7,11 -> inputArray[indexToMove - 1] == 16 || inputArray[indexToMove - 4] == 16 || inputArray[indexToMove + 4] == 16
        15 -> inputArray[11] == 16 || inputArray[14] ==16
        13,14 -> inputArray[indexToMove - 1] == 16 || inputArray[indexToMove - 4] == 16 || inputArray[indexToMove + 1] == 16
        else -> inputArray[indexToMove - 1] == 16 || inputArray[indexToMove - 4] == 16 || inputArray[indexToMove + 1] == 16 || inputArray[indexToMove + 4] == 16
    }
    if(!result) {
        println("Warning!!! It's impossible to perform a step. Please enter correct value.")
    }
    return result
}
