package com.disney.hero_interactors

import com.disney.core.*
import com.disney.hero_datasource.network.HeroService
import com.disney.hero_domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetSingleHeroById(private val service: HeroService) {


    fun execute(id: Int): Flow<DataState<Hero>> = flow {
        try {
            emit(Loading(progressBarState = ProgressBarState.Loading))


            val heros: Hero? = try { // catch network exceptions
                service.getSingleHeroById(id)
            } catch (e: Exception) {
                e.printStackTrace() // log to crashlytics?
                emit(
                    Response<Hero>(
                        uiComponent = UIComponent.Dialog(
                            title = "Network Data Error",
                            description = e.message ?: "Unknown error"
                        )
                    )
                )
                null
            }

            emit(Data(heros))


        } catch (e: Exception) {
            e.printStackTrace()
            emit(
                Response<Hero>(
                    uiComponent = UIComponent.Dialog(
                        title = "Error",
                        description = e.message ?: "unknown error!"
                    )
                )
            )
        }
    }
}