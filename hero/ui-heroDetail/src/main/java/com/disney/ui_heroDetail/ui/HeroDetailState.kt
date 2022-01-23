package com.disney.ui_heroDetail.ui

import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero

data class HeroDetailState(
    val progressBarState : ProgressBarState,
    val hero : Hero
)
