package com.kingwaytek.sharepreferencebuilder.util

import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.lang.reflect.Proxy

object SharedPreferencesEditor {

    var c = Class.forName("PrefBuilder")
    var fields: Array<Field?> = c.declaredFields
    //fields.

    /*private fun <T> getEditor(service: Class<T>, college: Int): T {
        val `object` = Proxy.newProxyInstance(service.classLoader, arrayOf<Class<*>>(service)
        ) { proxy, method, args ->
            val headers = method.getAnnotation(Headers::class.java!!)
            val deviceId = method.getAnnotation(DeviceId::class.java!!)
            val sensorId = method.getAnnotation(SensorId::class.java!!)
            if (method.returnType == Observable::class.java) {
                return@Proxy.newProxyInstance ApiClient . getClient ().getIotObservableData(
                    headers.value()[college],
                    deviceId.value()[college],
                    sensorId!!.value()[college]
                )
            } else if (sensorId == null) {
                return@Proxy.newProxyInstance ApiClient . getClient ().getIotDataList(
                    headers.value()[college],
                    deviceId.value()[college]
                )
            } else {
                return@Proxy.newProxyInstance ApiClient . getClient ().getIotData(
                    headers.value()[college],
                    deviceId.value()[college],
                    sensorId!!.value()[college]
                )
            }
        }
        return `object` as T
    }*/


}