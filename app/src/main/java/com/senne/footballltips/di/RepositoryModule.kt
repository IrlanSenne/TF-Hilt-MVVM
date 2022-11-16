package com.senne.footballltips.di

import com.google.firebase.firestore.FirebaseFirestore
import com.senne.footballltips.data.TipsApi
import com.senne.footballltips.data.TipsRepository
import com.senne.footballltips.data.TipsRepositoryImpl
import com.senne.footballltips.usecase.GetGamesListUseCase
import com.senne.footballltips.usecase.GetGamesListUseCaseImpl
import com.senne.footballltips.usecase.GetTipUseCase
import com.senne.footballltips.usecase.GetTipUseCaseImpl
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
    fun provideGetTipsUseCaseRepository(tipsRepository: TipsRepository): GetGamesListUseCase {
        return GetGamesListUseCaseImpl(tipsRepository)
    }

    @Provides
    @Singleton
    fun provideGetTipUseCaseRepository(tipsRepository: TipsRepository): GetTipUseCase {
        return GetTipUseCaseImpl(tipsRepository)
    }
}