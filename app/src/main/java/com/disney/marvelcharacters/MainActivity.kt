package com.disney.marvelcharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.disney.core.Logger
import com.disney.core.ProgressBarState
import com.disney.hero_domain.Hero
import com.disney.hero_interactors.HeroInteractors
import com.disney.marvelcharacters.di.heroDetail.HeroDetailViewModel
import com.disney.marvelcharacters.di.heroList.HeroListViewModel
import com.disney.marvelcharacters.ui.navigation.Screen
import com.disney.marvelcharacters.ui.theme.MarvelCharactersTheme
import com.disney.ui_heroDetail.HeroDetail
import com.disney.ui_heroList.ui.HeroList
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heros: MutableState<List<Hero>> = mutableStateOf(listOf())
    private val progressBarState: MutableState<ProgressBarState> =
        mutableStateOf(ProgressBarState.Idle)
    private lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var myNewViewModel: MyNewViewModel

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
        /*getHeros.execute().onEach { dataState ->
            when (dataState) {
                is Response -> {
                    when (dataState.uiComponent) {
                        is UIComponent.Dialog -> {
                            logger.log((dataState.uiComponent as UIComponent.Dialog).description)
                        }
                        is UIComponent.None -> {
                            logger.log((dataState.uiComponent as UIComponent.None).message)
                        }
                    }
                }
                is Data -> {
                    heros.value = dataState.data ?: listOf()
                }
                is Loading -> {
                    progressBarState.value = dataState.progressBarState // todo: uncomment
                }
            }
        }.launchIn(CoroutineScope(IO))*/


        setContent {
            MarvelCharactersTheme {

//                val viewModel: HeroListViewModel = viewModel()
//
//                val viewModel: HeroListViewModel = hiltViewModel()
//                viewModel.getHeroes()

//                myNewViewModel.test()


                myNewViewModel.test()

                val navController = rememberNavController()

                val items = listOf(
                    Screen.HeroList,
                    Screen.HeroDetail,
                )

                Scaffold(bottomBar = {
                    BottomNavigation(
                        backgroundColor = colorResource(id = R.color.red)
                    ) {
                        
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = { Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = null, tint = Color.White) },
//                                label = { Text("") },
                                selected = currentDestination?.hierarchy?.any {
                                    it.route == screen.route
                                } == true,
                                onClick = {
                                    navController.navigate(screen.route)
                                })


                        }
                    }
                }) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HeroList.route,
                        builder = {

                            addHeroList(navController)

                            addHeroDetail()
                        }
                    )
                }




                /*
                HeroList(
                    heroes = viewModel.heros,
                    progressBarState = progressBarState,
                    imageLoader = imageLoader
                )*/

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


    private fun NavGraphBuilder.addHeroList(navController: NavHostController) {

        // ToDo: use the viewmodel here
        composable(route = Screen.HeroList.route) {
            val heroListViewModel: HeroListViewModel = hiltViewModel()
            HeroList(
                state = heroListViewModel.state.value,
                progressBarState = progressBarState,
                imageLoader = imageLoader,
                navigateToDetail = { heroId ->
                    navController.navigate("${Screen.HeroDetail.route}/$heroId")
                })
        }
    }

    private fun NavGraphBuilder.addHeroDetail() {
        composable(

            //ToDo: extract a string from this hero Id
            route = Screen.HeroDetail.route + "/{heroId}",
            arguments = Screen.HeroDetail.arguments
        ) { navBackStackEntry ->
            val viewModel: HeroDetailViewModel = hiltViewModel()
            val id = navBackStackEntry.arguments?.getInt("heroId") as Int
            viewModel.getSingleHero(id)
            HeroDetail(id, viewModel.singleHero, imageLoader)
        }
    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MarvelCharactersTheme {
//        Greeting("Android")
//    }
//}