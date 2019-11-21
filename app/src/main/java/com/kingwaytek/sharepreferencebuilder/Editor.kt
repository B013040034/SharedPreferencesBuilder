package com.kingwaytek.sharepreferencebuilder

import android.annotation.SuppressLint
import com.kingwaytek.sharepreferencebuilder.model.IotData
import com.kingwaytek.sharepreferencesbuilder.Pref
import com.kingwaytek.sharepreferencesbuilder.PrefDefaultInt
import com.kingwaytek.sharepreferencesbuilder.PrefDefaultString
import com.kingwaytek.sharepreferencesbuilder.PrefName

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

    @PrefName("LASTNAME")
    @PrefDefaultString("--")
    lateinit var lastName: Pref.String

    @PrefName("IS_SET_UP")
    lateinit var isSetUp: Pref.Boolean

    @PrefName("OBJECT")
    lateinit var iotData: Pref.Object<IotData>
}