package com.kingwaytek.sharepreferencesbuilder

import android.content.Context
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaType

open class PrefBuilder(var aClass: Any, var context: Context) {
    fun build() {
        inject(aClass, context)
    }

    private fun inject(o: Any, ctx: Context) {
        val aClass = o.javaClass
        val declaredFields = aClass.declaredFields
        for (field in declaredFields) {
            if (field.isAnnotationPresent(PrefName::class.java) && field.getAnnotation(
                    PrefName::class.java) != null) {
                val className = aClass.name
                val prefName = field.getAnnotation(PrefName::class.java).value
                try {
                    field.isAccessible = true
                    when(field.type) {
                        Pref.Int::class.java -> {
                            val annotInt = field.getAnnotation(PrefDefaultInt::class.java)
                            field.set(o,
                                Pref.Int(
                                    ctx,
                                    className,
                                    prefName,
                                    annotInt?.value ?: 0
                                )
                            )
                        }
                        Pref.String::class.java-> {
                            val annotString = field.getAnnotation(PrefDefaultString::class.java)
                            field.set(o,
                                Pref.String(
                                    ctx,
                                    className,
                                    prefName,
                                    annotString?.value ?: ""
                                )
                            )
                        }
                        Pref.Boolean::class.java-> {
                            val annotBoolean = field.getAnnotation(PrefDefaultBoolean::class.java)
                            field.set(o,
                                Pref.Boolean(
                                    ctx,
                                    className,
                                    prefName,
                                    annotBoolean?.value ?: false
                                )
                            )
                        }
                        Pref.Float::class.java-> {
                            val annotFloat = field.getAnnotation(PrefDefaultFloat::class.java)
                            field.set(o,
                                Pref.Float(
                                    ctx,
                                    className,
                                    prefName,
                                    annotFloat?.value ?: 0f
                                )
                            )
                        }
                        Pref.Long::class.java-> {
                            val annotLong = field.getAnnotation(PrefDefaultLong::class.java)
                            field.set(o,
                                Pref.Long(
                                    ctx,
                                    className,
                                    prefName,
                                    annotLong?.value ?: 0
                                )
                            )
                        }
                        Pref.Object::class.java-> {
                            val typeParamsOfData = o::class.members.find {
                                it.name == field.name
                            }
                            typeParamsOfData?.returnType?.arguments?.singleOrNull()?.let {
                                field.set(o,
                                    Pref.Object(
                                        ctx,
                                        className,
                                        prefName,
                                        it.type!!.javaType,
                                        typeParamsOfData?.returnType.classifier as KClass<*>
                                    )
                                )
                            }
                        }
                    }
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            }
        }
    }
}
