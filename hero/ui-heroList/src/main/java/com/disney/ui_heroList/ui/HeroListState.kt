package com.disney.ui_heroList.ui

import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero

data class HeroListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val heroes: List<Hero> = listOf(),
    val filteredHeroes: List<Hero> = listOf(),
    var heroName : String = ""
)
