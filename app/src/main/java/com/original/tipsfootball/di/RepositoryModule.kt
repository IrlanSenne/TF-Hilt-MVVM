package com.original.tipsfootball.di

import com.google.firebase.firestore.FirebaseFirestore
import com.original.tipsfootball.data.TipsRepository
import com.original.tipsfootball.data.TipsRepositoryImpl
import com.original.tipsfootball.usecase.GetTipsUseCase
import com.original.tipsfootball.usecase.GetTipsUseCaseImpl
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
    fun provideNoteRepository(database: FirebaseFirestore): TipsRepository {
        return TipsRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideGetTipsUseCaseRepository(tipsRepository: TipsRepository): GetTipsUseCase {
        return GetTipsUseCaseImpl(tipsRepository)
    }
}