package me.pegbeer.commons.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class GradientLinearBackgroundTest {

    @get:Rule
    val composeTestRule = createComposeRule()

     @Test
     fun testGradientLinearBackground(){
         composeTestRule.setContent {
             me.pegbeer.commons.ui.GradientLinearBackground(
                 from = Color.Red,
                 until = Color.Blue,
                 modifier = Modifier.testTag("gradientBox")
             ) {
                 Box(modifier = Modifier) {}
             }
         }

         // Verifica que el Box con el gradiente existe
         composeTestRule.onNodeWithTag("gradientBox").assertExists()
     }
}