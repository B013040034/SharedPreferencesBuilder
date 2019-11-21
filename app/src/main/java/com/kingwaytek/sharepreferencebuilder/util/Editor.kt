package com.kingwaytek.sharepreferencebuilder.util

import android.annotation.SuppressLint
import com.kingwaytek.sharepreferencebuilder.model.IotData

@SuppressLint("StaticFieldLeak")
object Editor {
    @PrefName("SIT")
    @PrefDefaultInt(-1)
    lateinit var sits: Pref.Int

    @PrefName("BOOK")
    @PrefDefaultInt(0)
    lateinit var books: Pref.Int

    @PrefName("FIRST_NAME")
    lateinit var firstName: Pref.String

    var changeText: String
        get() = lastName.value
        set(value) {
            lastName.value = value + "123"
        }

    @PrefName("LASTNAME")
    @PrefDefaultString("--")
    lateinit var lastName: Pref.String

    @PrefName("IS_SET_UP")
    lateinit var isSetUp: Pref.Boolean

    @PrefName("OBJECT")
    lateinit var iotData: Pref.Object<IotData>

    @PrefName("TEST")
    var test: Int = 56
}