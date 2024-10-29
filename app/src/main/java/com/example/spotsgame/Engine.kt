package com.example.spotsgame

class Engine(): FifteenEngine {
    override fun transitionState(oldState: List<Int>, cell: Int): List<Int> {
        val indexFromMove = com.example.spotsgame.oldState.indexOf(cell)
        val indexToMove = com.example.spotsgame.oldState.indexOf(16)
        val newState = oldState.toMutableList()
        newState[indexFromMove] = newState[indexToMove].also { newState[indexToMove] = newState[indexFromMove]}
        return newState.toList()
    }

    override fun isWin(playingChips: List<Int> ): Boolean {
        val final = List(16){ it + 1 }
        return playingChips == final
    }

    override fun getInitialState(): List<Int> {
        val playingChips = List(16){ it + 1 }.toMutableList()
        return playingChips.shuffled()
    }

    override fun isInputValid(playingChips: List<Int>, number: Int): Boolean {
        return isInputInRange(number) && isStepPossible(playingChips, number)
    }

    fun isInputInRange(number: Int): Boolean  = number in 1..15

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

        return result
    }
}