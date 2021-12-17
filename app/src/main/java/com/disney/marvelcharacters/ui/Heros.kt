package com.disney.marvelcharacters.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero
import com.disney.marvelcharacters.R

@Composable
fun HeroList(heroes: MutableState<List<Hero>>, progressBarState: MutableState<ProgressBarState>, imageLoader : ImageLoader) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        LazyColumn {
            //                        items(heros.value){ hero ->
            //                            Text(hero. ) // Todo: show name here
            //                        }



            items(heroes.value) {

                val painter = rememberImagePainter(
                    it.thumbnail,
                    imageLoader = imageLoader,
                    builder = {
//                        placeholder(if(isSystemInDarkTheme()) R.drawable else R.drawable.white_background)
                        placeholder(R.drawable.ic_launcher_background)
                    }
                )
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