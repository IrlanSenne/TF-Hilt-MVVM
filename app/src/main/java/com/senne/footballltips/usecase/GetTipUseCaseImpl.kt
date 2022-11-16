package com.senne.footballltips.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.original.tipsfootball.model.PredictionsEntity
import com.senne.footballltips.data.TipsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTipUseCaseImpl @Inject constructor(
    private val tipsRepository: TipsRepository
) : GetTipUseCase {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun invoke(fixture: String): Flow<PredictionsEntity?> = flow {

        val predictions = tipsRepository.getTipApi(fixture)

        try {
            if (predictions != null) {
                emit(predictions)
            }
        } catch (e: Throwable) {
            emit(null)
        }
    }
}