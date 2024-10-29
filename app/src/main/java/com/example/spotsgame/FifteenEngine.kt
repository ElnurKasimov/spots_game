package com.example.spotsgame

interface FifteenEngine {
    fun transitionState(oldState: List<Int>, cell: Int): List<Int>
    fun isWin(state: List<Int>): Boolean
    fun getInitialState(): List<Int>
    fun isInputValid(playingChips: List<Int>, number: Int): Boolean
}