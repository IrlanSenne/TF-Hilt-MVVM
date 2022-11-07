package com.original.tipsfootball.data

import com.original.tipsfootball.model.TipsEntity

interface TipsRepository {
    suspend fun getTipsFirebaseCall(): MutableList<TipsEntity>
    suspend fun insertTipsFirebase()
}