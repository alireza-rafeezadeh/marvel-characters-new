package com.disney.marvelcharacters.di.heroList

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.disney.core.*
import com.disney.hero_interactors.GetHeros
import com.disney.ui_heroList.ui.HeroListEvents
import com.disney.ui_heroList.ui.HeroListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HeroListViewModel @Inject constructor(
    val getHeros : GetHeros
) : ViewModel() {


    val state: MutableState<HeroListState> = mutableStateOf(HeroListState())


    init {
        getHeroes()
    }


    fun onTriggerEvent(event : HeroListEvents){
        when(event) {

            HeroListEvents.GetHeroes -> {

            }

            is HeroListEvents.UpdateHeroName -> {
                updateHeroName(event.heroName)
            }

            HeroListEvents.FilterHeroes -> {
                filterHeroes()
            }
        }
    }

    fun getHeroes() {

        Log.i("get_heros_tg", "getHeroes! ")
        val logger = Logger("GetHerosTest")
        getHeros.execute().onEach { dataState ->
            when(dataState){
                is Response -> {
                    when(dataState.uiComponent){
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is Data -> {
                    state.value = state.value.copy(heroes = dataState.data?: listOf())
                    filterHeroes()
                }
                is Loading -> {
                    state.value = state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)

    }


    private fun updateHeroName(heroName: String) {
        state.value = state.value.copy(heroName = heroName)
        // TODO: check from mitch's code if it is correct:
        filterHeroes()
    }

    private fun filterHeroes() {
        state.value.heroes.filter {
            it.name.lowercase().contains(state.value.heroName.lowercase() ?: "")
        }.toMutableList().also {
            state.value = state.value.copy(filteredHeroes = it)
        }
        val filtered = state.value.filteredHeroes

        Log.i("filter_ed_l", "$filtered")
    }

}