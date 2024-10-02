package com.example.spotsgame

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
            if(isInputValid(numberForMove.toInt())) {
                makeMove(playingChips, numberForMove.toInt())
            }
        }

    } while (numberForMove != null)
    println(
        """Thank You for playing!
           |GoodLuck!""".trimMargin())
}

fun displayPlayingField(playingChips: Array<Int>) {
    println("----------------------")
    for (i in 0 until 4) {
        print("|   ")
        for(j in 0 until 4) {
            print(if (playingChips[i * 4 + j] == 16) "  \t"
                  else "${playingChips[i * 4 + j]}\t" )
            }
        println(" |")
    }
    println("----------------------")
}

fun isInputValid(number: Int): Boolean {
    return isInputInRange(number) && isStepPossible(number)
}

fun isInputInRange(number: Int): Boolean {
    if(number in 1..15) {
        return true
    } else {
        println("Number has to be from 1 to 15 (all inclusive)")
        return false
    }

}

fun makeMove(inputArray: Array<Int>, numberForMove: Int): Array<Int> {

}