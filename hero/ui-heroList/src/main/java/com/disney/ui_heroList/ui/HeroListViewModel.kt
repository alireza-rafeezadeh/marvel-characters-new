//package com.disney.ui_heroList.ui
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import com.disney.hero_interactors.GetHeros
//import com.disney.ui_heroList.di.Fuck
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//
//@HiltViewModel
//class HeroListViewModel @Inject constructor(
////    val getHeros : Fuck
//) : ViewModel() {
//
//
////    val heros: MutableState<List<Hero>> = mutableStateOf(listOf())
//
//
//    init {
//        getHeroes()
//    }
//
//
//    fun getHeroes() {
//
//        Log.i("get_heros_tg", "getHeroes! ")
//        /*val logger = Logger("GetHerosTest")
//        getHeros.execute().onEach { dataState ->
//            when(dataState){
//                is Response -> {
//                    when(dataState.uiComponent){
//                        is UIComponent.Dialog -> {
//                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
//                        }
//                        is UIComponent.None -> {
//                            logger.log((dataState.uiComponent as UIComponent.None).message)
//                        }
//                    }
//                }
//                is Data -> {
//                    heros.value = dataState.data?: listOf()
//                }
//                is Loading -> {
////                    heros.value = heros.value.copy // todo: uncomment
//                }
//            }
//        }.launchIn(viewModelScope)*/
//
//
//    }
//
//
//
//}