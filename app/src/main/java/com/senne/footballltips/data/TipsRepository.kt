package com.senne.footballltips.data

import com.senne.footballltips.model.FixtureEntity
import com.senne.footballltips.model.TipsEntity

interface TipsRepository {
    suspend fun getTipsFirebaseCall(): MutableList<TipsEntity>
    suspend fun insertTipsFirebase()
    suspend fun getTipsApi(date: String): FixtureEntity?
}