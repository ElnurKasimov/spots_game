package com.example.spotsgame

import android.annotation.SuppressLint

    // Model : ENGINE (Service)
    val engine = Engine()
    // Model : STATE
    var oldState = engine.getInitialState()

    // Controller
fun main() {
    println("Welcome to the Spot Game")
    while(!engine.isWin(oldState)) {
        displayPlayingField(oldState)
        val numberForMove = readCell()
        if(numberForMove == null) {
            println("Thank You for playing!")
            break
        } else {
            oldState = engine.transitionState(oldState, numberForMove)
        }
    }
    if(engine.isWin(oldState)) {
        println("Congratulations, you've won!!")
    }
    println("GoodLuck!")
}

fun readCell(
    println: (String) -> Unit = ::println,
    readln: () -> String = ::readln
): Int? {
    while(true) {
        println("Enter number You want to move or any letter for quit : ")
        val step = readln()
        val numberForMove: Int?  = step.toIntOrNull()
        if(numberForMove == null) {
            return numberForMove
        } else if (!engine.isInputInRange(numberForMove.toInt())) {
            println("Warning!!!  Number has to be from 1 to 15 (all inclusive). Please enter correct value.")
        } else if (engine.isStepPossible(oldState, numberForMove)) {
            return numberForMove
        } else {
            println("Warning!!! It's impossible to perform a step. Please enter correct value.")
        }
    }
}



    // VIEW
@SuppressLint("DefaultLocale")
fun displayPlayingField(playingChips: List<Int>) {
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





