package com.disney.marvelcharacters.di.heroDetail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.disney.core.*
import com.disney.hero_domain.Hero
import com.disney.hero_interactors.GetSingleHeroById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class HeroDetailViewModel @Inject constructor(private val getSingleHeroById : GetSingleHeroById) : ViewModel() {

    val singleHero: MutableState<Hero?> = mutableStateOf(null)



    fun getSingleHero(id : Int) {
        Log.i("get_heros_tg", "getHeroes! ")
        val logger = Logger("GetHerosTest")
        getSingleHeroById.execute(id).onEach { dataState ->
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
                    dataState.data?.let { hero ->
                        singleHero.value = hero
                    }
                }
                is Loading -> {
//                    heros.value = heros.value.copy // todo: uncomment
                }
            }
        }.launchIn(viewModelScope)


    }
}