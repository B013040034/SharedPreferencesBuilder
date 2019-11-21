package com.kingwaytek.sharepreferencebuilder.model

import com.google.gson.annotations.SerializedName

class IotData (
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("save")
    var save: Boolean? = null,
    @SerializedName("time")
    var time: String? = null,
    @SerializedName("value")
    var value: List<String>? = null
)
