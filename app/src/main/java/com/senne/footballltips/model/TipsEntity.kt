package com.senne.footballltips.model

data class TipsEntity(
    val away_name:String = "",
    val home_name:String = "",
    val tip: Tip? = null,
    val away_photo:String = "",
    val home_photo:String = "",
    val date: String = ""
)

data class Tip(
    val advice:String = "",
    val combo_advice:String = "",
)
