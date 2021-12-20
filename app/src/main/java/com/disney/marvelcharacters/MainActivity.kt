package com.disney.marvelcharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import coil.ImageLoader
import com.disney.core.*
import com.disney.hero_domain.Hero
import com.disney.hero_interactors.HeroInteractors
import com.disney.marvelcharacters.ui.theme.MarvelCharactersTheme
import com.disney.ui_heroList.HeroList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

//class MainActivity : ComponentActivity() {
//
//    private val heros: MutableState<List<Hero>> = mutableStateOf(listOf())
//    private val progressBarState: MutableState<ProgressBarState> = mutableStateOf(ProgressBarState.Idle)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MarvelCharactersTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}
//

class MainActivity : ComponentActivity() {

    private val heros: MutableState<List<Hero>> = mutableStateOf(listOf())
    private val progressBarState: MutableState<ProgressBarState> = mutableStateOf(ProgressBarState.Idle)
    private lateinit var imageLoader: ImageLoader


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        imageLoader = ImageLoader.Builder(applicationContext)
            .error(R.drawable.ic_launcher_foreground)
            .placeholder(R.drawable.ic_launcher_background)
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()


        val getHeros = HeroInteractors.build().getHeros
        val logger = Logger("GetHerosTest")
        getHeros.execute().onEach { dataState ->
            when(dataState){
                is Response -> {
                    when(dataState.uiComponent){
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is Data -> {
                    heros.value = dataState.data?: listOf()
                }
                is Loading -> {
                    progressBarState.value = dataState.progressBarState // todo: uncomment
                }
            }
        }.launchIn(CoroutineScope(IO))

        setContent {
            MarvelCharactersTheme {
                HeroList(heros, progressBarState,imageLoader)

                /*GlideImage(
                    imageModel = "https://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73/portrait_small.jpg",
                    // Crop, Fit, Inside, FillHeight, FillWidth, None
                    contentScale = ContentScale.Fit,
                    // shows an image with a circular revealed animation.
                    circularReveal = CircularReveal(duration = 250),
                    // shows a placeholder ImageBitmap when loading.
//                        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
//                        // shows an error ImageBitmap when the request failed.
//                        error = ImageBitmap.imageResource(R.drawable.error)
                    modifier = Modifier
                        .width(70.dp)
                        .height(130.dp)
                    ,
                )*/
            }
        }
    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarvelCharactersTheme {
        Greeting("Android")
    }
}