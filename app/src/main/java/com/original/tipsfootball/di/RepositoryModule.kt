package com.original.tipsfootball.di

import com.google.firebase.firestore.FirebaseFirestore
import com.original.tipsfootball.data.FireBaseRepository
import com.original.tipsfootball.data.FireBaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNoteRepository(database: FirebaseFirestore): FireBaseRepository {
        return FireBaseRepositoryImpl(database)
    }
}