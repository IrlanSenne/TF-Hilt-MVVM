package com.senne.footballltips.model

data class TipsEntity(
    val visitant_name:String = "",
    val home_name:String = "",
    val tip: Tip? = null,
    val visitant_photo:String = "",
    val home_photo:String = ""
)

data class Tip(
    val advice:String = "",
    val combo_advice:String = "",
)
