package com.kingwaytek.sharepreferencebuilder.util

import android.content.Context
import com.google.gson.Gson
import java.lang.reflect.Type
import kotlin.reflect.KClass


open class Pref {
    open class Int(var context: Context, var className: kotlin.String, var name: kotlin.String, var defaultValue: kotlin.Int){
        var value: kotlin.Int
            get() = getPrefValue(context, className, name, Int, defaultValue) as kotlin.Int
            set(value) = setPrefValue(context, className, name, Int, value)
    }
    open class Boolean(var context: Context, var className: kotlin.String, var name: kotlin.String, var defaultValue: kotlin.Boolean){
        var value: kotlin.Boolean
            get() = getPrefValue(context, className, name, Boolean, defaultValue) as kotlin.Boolean
            set(value) = setPrefValue(context, className, name, Boolean, value)
    }
    open class String(var context: Context, var className: kotlin.String, var name: kotlin.String, var defaultValue: kotlin.String){
        var value: kotlin.String
            get() = getPrefValue(context, className, name, String, defaultValue) as kotlin.String
            set(value) = setPrefValue(context, className, name, String, value)
    }

    open class Float(var context: Context, var className: kotlin.String, var name: kotlin.String, var defaultValue: kotlin.Float){
        var value: kotlin.Float
            get() = getPrefValue(context, className, name, String, defaultValue) as kotlin.Float
            set(value) = setPrefValue(context, className, name, String, value)
    }

    open class Long(var context: Context, var className: kotlin.String, var name: kotlin.String, var defaultValue: kotlin.Long){
        var value: kotlin.Long
            get() = getPrefValue(context, className, name, String, defaultValue) as kotlin.Long
            set(value) = setPrefValue(context, className, name, String, value)
    }

    open class Object<T: Any>(var context: Context, var className: kotlin.String, var name: kotlin.String, var type: Type, var typeClass: KClass<T>){
        var value: T
            get() {
                return Gson().fromJson(getPrefValue(context, className, name, String, "") as kotlin.String, type)
            }
            set(value) {
                setPrefValue(context, className, name, String, Gson().toJson(value))
            }
    }

    companion object{
        private fun setPrefValue(context: Context, className: kotlin.String, name: kotlin.String, type: Any, value: Any) {
            val editor = context.getSharedPreferences(className, 0).edit()
            when(type) {
                Int ->  editor.putInt(name, value as kotlin.Int)
                Boolean -> editor.putBoolean(name, value as kotlin.Boolean)
                String -> editor.putString(name, value as kotlin.String?)
                Float -> editor.putFloat(name, value as kotlin.Float)
                Long -> editor.putLong(name, value as kotlin.Long)
            }
            editor.apply()
        }

        private fun getPrefValue(context: Context, className: kotlin.String, name: kotlin.String, type: Any, default: Any): Any? {
            val preference = context.getSharedPreferences(className, 0)
            return when(type) {
                Int ->  preference.getInt(name, default as kotlin.Int)
                Boolean -> preference.getBoolean(name, default as kotlin.Boolean)
                String -> preference.getString(name, default.toString())!!
                Float -> preference.getFloat(name, default as kotlin.Float)
                Long -> preference.getLong(name, default as kotlin.Long)
                else -> null
            }
        }
    }



}