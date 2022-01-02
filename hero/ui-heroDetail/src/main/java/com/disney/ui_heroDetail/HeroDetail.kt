package com.disney.ui_heroDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberImagePainter
import com.disney.hero_domain.Hero
import com.disney.hero_domain.getImageFullPath
import com.disney.hero_domain.getLandscapeImageFullPath

@Composable
fun HeroDetail(id: Int, singleHero: MutableState<Hero?>, imageLoader: ImageLoader) {

    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {

        val painter = rememberImagePainter(
            singleHero.value?.thumbnail?.getLandscapeImageFullPath(),
            imageLoader = imageLoader,
//                        builder = {
//                            placeholder(R)
//                        }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            painter = painter,
            contentDescription = "description goes here",

            contentScale = ContentScale.Crop,
        )

        Text(
            text = "${singleHero.value?.name}",

            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            style = TextStyle(textAlign = TextAlign.Center, fontSize = 25.sp)

        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Comics")
        Spacer(modifier = Modifier.height(4.dp))

        LazyRow() {
            singleHero.value?.comics?.items?.let { list ->
                items(list) { comic ->
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Red)
                            .fillMaxHeight(0.3f)
                            .width(160.dp)

//                        .height(45.dp)
                    ) {
                        Text(
                            text = comic.name,
                            modifier = Modifier.align(alignment = Alignment.Center),
                            style = TextStyle(fontSize = 13.sp, textAlign = TextAlign.Center)

                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        }
    }


}