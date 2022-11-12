package com.senne.footballltips.di

import com.google.firebase.firestore.FirebaseFirestore
import com.senne.footballltips.data.TipsApi
import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.data.TipsRepositoryImpl
import com.senne.footballltips.usecase.GetTipsUseCase
import com.senne.footballltips.usecase.GetTipsUseCaseImpl
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
    fun provideNoteRepository(database: FirebaseFirestore, tipsApi: TipsApi): TipsRepository {
        return TipsRepositoryImpl(database, tipsApi)
    }

    @Provides
    @Singleton
    fun provideGetTipsUseCaseRepository(tipsRepository: TipsRepository): GetTipsUseCase {
        return GetTipsUseCaseImpl(tipsRepository)
    }
}