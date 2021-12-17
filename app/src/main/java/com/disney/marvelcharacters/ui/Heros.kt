package com.disney.marvelcharacters.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero

@Composable
fun HeroList(heroes: MutableState<List<Hero>>, progressBarState: MutableState<ProgressBarState>) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            //                        items(heros.value){ hero ->
            //                            Text(hero. ) // Todo: show name here
            //                        }

            items(heroes.value) {
                Text(text = it.urls.toString(), color = Color.Red)
                Spacer(modifier = Modifier.height(32.dp))
            }


        }
        // ToDo: the progressbar doesn't disappear after some time
//        if (progressBarState.value is ProgressBarState.Loading) {
//            CircularProgressIndicator(
//                modifier = Modifier.align(Alignment.Center)
//            )
//        }
    }
}