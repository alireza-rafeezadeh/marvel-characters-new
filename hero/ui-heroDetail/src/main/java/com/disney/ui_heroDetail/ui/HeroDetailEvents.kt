package com.disney.ui_heroDetail.ui

sealed class HeroDetailEvents {

    data class GetSingleHero(val id : Int) : HeroDetailEvents()

}