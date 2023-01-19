package com.example.android.unscramble.ui

import kotlinx.coroutines.flow.MutableStateFlow


// no need to copy
data class GameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 0,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)