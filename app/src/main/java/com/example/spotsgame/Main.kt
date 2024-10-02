package com.example.spotsgame

import kotlin.random.Random

fun main() {
    println("Welcome to the Spot Game")
    val playingChips = Array(16){ it + 1 }
    playingChips.shuffle()
    do {
        displayPlayingField(playingChips)
        print("Enter number You want to move or \"Q\" for quit : ")
        val step = readln()
        val numberForMove: Int?  = step.toIntOrNull()
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