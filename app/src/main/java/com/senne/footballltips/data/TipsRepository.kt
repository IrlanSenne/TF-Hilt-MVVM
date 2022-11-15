package com.senne.footballltips.data

import com.senne.footballltips.model.FixtureEntity
import com.senne.footballltips.model.TipsEntity
import java.io.Serializable

interface TipsRepository {
    suspend fun getTipsFirebaseCall(): MutableList<TipsEntity>
    suspend fun insertTipsFirebase(gameInformations:  MutableList<HashMap<String, Serializable>>)
    suspend fun getTipsApi(date: String): FixtureEntity?
    suspend fun deleteOldTipsFirebase()
}