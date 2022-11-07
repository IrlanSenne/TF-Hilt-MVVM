package com.original.tipsfootball.data

import com.original.tipsfootball.model.TipsEntity

interface FireBaseRepository {
    suspend fun doNetworkCall(): MutableList<TipsEntity>
}