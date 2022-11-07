package com.original.tipsfootball.usecase

import com.original.tipsfootball.data.TipsRepository
import com.original.tipsfootball.model.TipsEntity
import javax.inject.Inject

class GetTipsUseCaseImpl @Inject constructor(
     private val tipsRepository: TipsRepository
): GetTipsUseCase {
    override suspend fun invoke(): MutableList<TipsEntity> {
        return tipsRepository.getTipsFirebaseCall()
    }
}