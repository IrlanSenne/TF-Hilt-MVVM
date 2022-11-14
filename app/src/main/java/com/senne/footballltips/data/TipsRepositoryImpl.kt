package com.senne.footballltips.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
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
            .addOnFailureListener {
                Log.d("testFireBase", "Error - $it")
            }

        delay(3000)
        mutableData
    }

    override suspend fun insertTipsFirebase(gameInformations:  List<HashMap<String, Serializable>>) {

        gameInformations.forEachIndexed { index, user ->
            firebaseDB.collection(Constants.tipFootball).document("${Constants.game}$index")
                .set(user)
                .addOnSuccessListener { documentReference ->

                }
        }
    }

    override suspend fun getTipsApi(date: String): FixtureEntity?  {
        return tipsApi.listFixture(date)
    }
}