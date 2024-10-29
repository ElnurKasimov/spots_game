package com.example.spotsgame

class Engine(): FifteenEngine {
    override fun transitionState(oldState: List<Int>, cell: Int): List<Int> {
        TODO("Not yet implemented")
    }

    override fun isWin(playingChips: List<Int> ): Boolean {
        val final = List(16){ it + 1 }
        return playingChips == final
    }

    override fun getInitialState(): List<Int> {
        val playingChips = List(16){ it + 1 }.toMutableList()
        return playingChips.shuffled()
    }
}