package com.disney.ui_heroDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.disney.hero_domain.Hero

@Composable
fun HeroDetail(id: Int, singleHero: MutableState<Hero?>) {

    Column {
        Text(text = "Test Text $id")
        Text(text = "${singleHero.value?.name}")
    }

    singleHero.value?.name
    //todo: pass state here and show
}