package com.disney.marvelcharacters.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero

@ExperimentalCoilApi
@Composable
fun HeroList(
    heroes: MutableState<List<Hero>>,
    progressBarState: MutableState<ProgressBarState>,
    imageLoader: ImageLoader
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        LazyColumn {
            //                        items(heros.value){ hero ->
            //                            Text(hero. ) // Todo: show name here
            //                        }


            items(heroes.value) {

                Column {
                    val painter = rememberImagePainter(
                        "http://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73/portrait_fantastic.jpg",
                        imageLoader = imageLoader,
//                        builder = {
//                            placeholder(R)
//                        }
                    )
                    Text(text = it.urls.toString(), color = Color.Red)
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        modifier = Modifier
                            .width(70.dp)
                            .height(130.dp)
                        ,
                        painter = painter,
                        contentDescription = "description goes here",
                        contentScale = ContentScale.Fit,
                    )
                }
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