package com.sadeghjfr22.covid19.base

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onResume() {
        App.currentActivity =this
        super.onResume()
    }

}
