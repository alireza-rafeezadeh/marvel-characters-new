package com.disney.ui_heroDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
    }

    singleHero.value?.name
    //todo: pass state here and show
}