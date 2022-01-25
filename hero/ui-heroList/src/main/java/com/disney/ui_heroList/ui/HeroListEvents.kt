package com.disney.ui_heroList.ui

sealed class HeroListEvents {
    object GetHeroes : HeroListEvents()

    object FilterHeroes : HeroListEvents()

    data class UpdateHeroName(val heroName: String) : HeroListEvents()
}