package com.disney.hero_interactors

import com.disney.core.*
import com.disney.hero_datasource.network.HeroService
import com.disney.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.Exception


class GetHeros(
    private val service: HeroService
    // todo: add cache
) {
    fun execute(): Flow<DataState<List<Hero>>> = flow {
        try {
            emit(Loading(progressBar = ProgressBarState.Loading))

            val heros = try {
                emit(service.getHeroStats())
            } catch (e: Exception) {
//                e.printStackTrace()
//                emit(
//                    Response<List<Hero>>(
//                        uiComponent = UiComponent.Dialog(
//                            title = "Error",
//                            description = e.message ?: "unknown error!"
//                        )
//                    )
//                )
//                listOf<List<Hero>>()
            }

            emit(Data(heros))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                Response<List<Hero>>(
                    uiComponent = UiComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "unknown error!"
                    )
                )
            )
        }
    }
}