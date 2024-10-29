package com.example.spotsgame

import android.annotation.SuppressLint

    // Model : ENGINE (Service)
    val engine = Engine()
    // Model : STATE
    val playingChips = engine.getInitialState()

    // Controller
fun main() {
    println("Welcome to the Spot Game")
    while(!engine.isWin(playingChips) {
        displayPlayingField(playingChips)
        val numberForMove = readCell()

    } while (numberForMove != null)
    println(
        """Thank You for playing!
           |GoodLuck!""".trimMargin())
}

fun readCell(
    println: (String) -> Unit = ::println,
    readln: () -> String = ::readln
) {
    while(true) {
        println("Enter number You want to move or any letter for quit : ")
        val step = readln()
        val numberForMove: Int?  = step.toIntOrNull()
        if(numberForMove != null) {
            if(isInputValid(playingChips, numberForMove.toInt())) {


                val indexFromMove = playingChips.indexOf(numberForMove)
                val indexToMove = playingChips.indexOf(16)
                playingChips[indexFromMove] = playingChips[indexToMove].also { playingChips[indexToMove] = playingChips[indexFromMove]}
            }

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

//fun isGameComplete(playingChips: List<Int> ): Boolean {
//    val final = List(16){ it + 1 }
//    return playingChips == final
//}

fun isInputValid(playingChips: List<Int>, number: Int): Boolean {
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

fun isStepPossible(inputList: List<Int>, numberForMove: Int): Boolean {
    val indexToMove = inputList.indexOf(numberForMove)
    val result =  when(indexToMove) {
        0 -> inputList[1] == 16 || inputList[4] == 16
        1,2 -> inputList[indexToMove - 1] == 16|| inputList[indexToMove + 1] == 16 || inputList[indexToMove + 4] == 16
        3 -> inputList[2] == 16 || inputList[7] == 16
        12 -> inputList[8] == 16 || inputList[13] == 16
        4,8 -> inputList[indexToMove - 4] == 16 || inputList[indexToMove + 1] == 16 || inputList[indexToMove + 4] == 16
        7,11 -> inputList[indexToMove - 1] == 16 || inputList[indexToMove - 4] == 16 || inputList[indexToMove + 4] == 16
        15 -> inputList[11] == 16 || inputList[14] ==16
        13,14 -> inputList[indexToMove - 1] == 16 || inputList[indexToMove - 4] == 16 || inputList[indexToMove + 1] == 16
        else -> inputList[indexToMove - 1] == 16 || inputList[indexToMove - 4] == 16 || inputList[indexToMove + 1] == 16 || inputList[indexToMove + 4] == 16
    }
    if(!result) {
        println("Warning!!! It's impossible to perform a step. Please enter correct value.")
    }
    return result
}

