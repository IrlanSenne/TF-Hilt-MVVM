package com.senne.footballltips.data

import com.google.firebase.firestore.FirebaseFirestore
import com.senne.footballltips.model.PredictionsEntity
import com.senne.footballltips.common.Constants
import com.senne.footballltips.model.FixtureEntity
import com.senne.footballltips.model.TipsEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import java.io.Serializable
import javax.inject.Inject

class TipsRepositoryImpl @Inject constructor(
    private val firebaseDB: FirebaseFirestore,
    private val tipsApi: TipsApi,
) : TipsRepository {

    override suspend fun getTipsFirebaseCall(): MutableList<TipsEntity> = coroutineScope {
        var mutableData = mutableListOf<TipsEntity>()
        firebaseDB.collection(Constants.tipFootball)
            .get()
            .addOnSuccessListener { result ->
                mutableData = result.toObjects(TipsEntity::class.java)
            }

        delay(3000)
        mutableData
    }

    override suspend fun insertTipsFirebase(gameInformations: MutableList<HashMap<String, Serializable>>) {

        gameInformations.forEachIndexed { index, user ->
            firebaseDB.collection(Constants.tipFootball)
                .document("$index")
                .set(user)
        }
    }

    override suspend fun getGamesApi(date: String): FixtureEntity? {
        return tipsApi.listFixture(date)
    }

    override suspend fun getTipApi(fixture: String): PredictionsEntity? {
        return tipsApi.getPredictions(fixture)
    }

    override suspend fun deleteOldTipsFirebase() {
        var collection = firebaseDB.collection(Constants.tipFootball).get()

        collection.addOnSuccessListener { result ->
            result.forEach { test ->
                firebaseDB.collection(Constants.tipFootball).document(test.id).delete()
            }
        }
    }
}