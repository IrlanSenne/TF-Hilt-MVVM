package com.original.tipsfootball.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.original.tipsfootball.model.TipsEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class FireBaseRepositoryImpl(
   private val database: FirebaseFirestore
): FireBaseRepository {
    var mutableData  = mutableListOf<TipsEntity>()
    override suspend fun doNetworkCall(): MutableList<TipsEntity> = coroutineScope {

        database.collection("test")
            .get()
            .addOnSuccessListener { result ->
                mutableData = result.toObjects(TipsEntity::class.java)
            }
            .addOnFailureListener {
                Log.d("testFireBase", "Error - $it")
            }

/*        val user = hashMapOf(
            "home_name" to "brazil2",
            "home_photo" to "https:sjdkajksad.jpg",
            "visitant_name" to "japan2",
            "visitant_photo" to "https:sjdkajksad.jpg",
            "tip" to hashMapOf(
                "advice" to "home win test2",
                "combo_advice" to "home win or draw and -2.5"
            )
        )

        var listGames = listOf(user, user, user)


        listGames.forEachIndexed { index, user ->
            db.collection("test").document("user$index").set(user)
                .addOnSuccessListener { documentReference ->

                }
        }*/
        delay(3000)
        mutableData
    }
}