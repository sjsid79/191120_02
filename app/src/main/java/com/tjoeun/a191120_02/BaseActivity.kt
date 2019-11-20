package com.tjoeun.a191120_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    var mComtext = this

    abstract  fun setupEvents()
    abstract  fun setValues()



}
