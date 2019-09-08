package com.example.android.kotlin_fundamental.fragment.screens.score

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = finalScore

    init {
        Timber.i("Final score is $finalScore")
    }
}