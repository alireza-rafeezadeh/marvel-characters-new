package com.disney.ui_heroList

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero
import com.disney.hero_domain.getImageFullPath
import com.disney.ui_herolist.R


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

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(heroes.value) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = colorResource(id = R.color.card_background))
                    .padding(16.dp)
                ) {
                    Log.i("hero_thumb", "HeroList: ${it.thumbnail.getImageFullPath()}")
                    val painter = rememberImagePainter(
                        it.thumbnail.getImageFullPath(),
                        imageLoader = imageLoader,
//                        builder = {
//                            placeholder(R)
//                        }
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(3f)
                            ,
                    ) {

                        Text(
                            text = it.name, color = colorResource(id = R.color.text),
//                            modifier = Modifier.weight(2f),
                            fontSize = 19.sp
                        )
//                    Spacer(modifier = Modifier.height(32.dp))

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = it.description, color = colorResource(id = R.color.text_description),
//                            modifier = Modifier.weight(2f),
                            fontSize = 11.sp
                        )
//                    Spacer(modifier = Modifier.height(32.dp))
                    }

                    Image(
                        modifier = Modifier
//                            .width(200.dp)
                            .weight(3f)
                            .height(290.dp)
                            .clip(RoundedCornerShape(20.dp))
                        ,
                        painter = painter,
                        contentDescription = "description goes here",

                        contentScale = ContentScale.Crop,
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