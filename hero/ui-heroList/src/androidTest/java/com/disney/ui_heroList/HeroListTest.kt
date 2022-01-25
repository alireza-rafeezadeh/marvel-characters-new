package com.disney.ui_heroList

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import com.disney.core.ProgressBarState
import com.disney.hero_datasource_test.network.HeroDataValid
import com.disney.hero_datasource_test.network.serializeHeroData
import com.disney.ui_heroList.ui.HeroList
import com.disney.ui_heroList.ui.HeroListState
import org.junit.Rule
import org.junit.Test

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HeroListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val imageLoader: ImageLoader = FakeImageLoader.build(context)
    private val heroData = serializeHeroData(HeroDataValid.data)

    @ExperimentalCoilApi
    @Test
    fun areHerosShown() {
        composeTestRule.setContent {
            val state = remember{
                HeroListState(
                    heroes = heroData,
                    filteredHeroes = heroData,
                )
            }
            HeroList(
                state = state,
                events = {},
                progressBarState = mutableStateOf(ProgressBarState.Idle),
                imageLoader = imageLoader,
                navigateToDetail = { }
            )
        }
//        composeTestRule.onNodeWithText("Anti-Mage").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Axe").assertIsDisplayed()
        composeTestRule.onNodeWithText("3-D Man").assertIsDisplayed()
        composeTestRule.onNodeWithText("A-Bomb (HAS)").assertIsDisplayed()
        composeTestRule.onNodeWithText("A.I.M.").assertIsDisplayed()
    }

}