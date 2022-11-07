package com.original.tipsfootball.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.original.tipsfootball.common.Constants
import com.original.tipsfootball.model.TipsEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import javax.inject.Inject

class TipsRepositoryImpl @Inject constructor(
   private val firebaseDB: FirebaseFirestore
) : TipsRepository {

    override suspend fun getTipsFirebaseCall(): MutableList<TipsEntity> = coroutineScope {
        var mutableData = mutableListOf<TipsEntity>()
        firebaseDB.collection("test")
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

    override suspend fun insertTipsFirebase() {
                val gameInformations = hashMapOf(
            "home_name" to "Benfica",
            "home_photo" to "https:sjdkajksad.jpg",
            "visitant_name" to "Varzim",
            "visitant_photo" to "https:sjdkajksad.jpg",
            "tip" to hashMapOf(
                "advice" to "varzim or draw",
                "combo_advice" to "varzim or draw adn + 4.5"
            )
        )

        var listGames = listOf(gameInformations, gameInformations, gameInformations)


        listGames.forEachIndexed { index, user ->
            firebaseDB.collection(Constants.tipFootball).document("${Constants.game}$index").set(user)
                .addOnSuccessListener { documentReference ->

                }
        }
    }
}