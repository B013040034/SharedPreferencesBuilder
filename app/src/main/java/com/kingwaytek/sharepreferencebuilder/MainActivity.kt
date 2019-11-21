package com.kingwaytek.sharepreferencebuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kingwaytek.sharepreferencebuilder.model.IotData
import com.kingwaytek.sharepreferencebuilder.util.Editor
import com.kingwaytek.sharepreferencebuilder.util.PrefBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init in Application
        PrefBuilder(Editor, this).build()
        PrefBuilder(Editor, this).build()
        PrefBuilder(Editor, this).build()
/*
        /** Int */
        //get
        Editor.books.value
        //set
        Editor.books.value = 87

        /** String */
        //get
        var name = Editor.firstName.value
        //set
        Editor.firstName.value = "CHAO HUNG"

        /** Boolean */
        //get
        var isSetup = Editor.isSetUp.value
        Editor.isSetUp.value = true*/





        //int
        Log.d("int", Editor.books.value.toString())
        Editor.books.value = 87
        Log.d("int", Editor.books.value.toString())

        //string
        Log.d("String", Editor.firstName.value)
        Editor.firstName.value = "123"
        Log.d("String", Editor.firstName.value)

        // bool
        Log.d("Boolean", Editor.isSetUp.value.toString())
        Editor.isSetUp.value = true
        Log.d("Boolean", Editor.isSetUp.value.toString())

        Editor.iotData.value = IotData("456", true, "dd", null)
        var iotData = Editor.iotData.value
        Log.d("Boolean", Editor.iotData.value.id)

    }
}
