package me.pegbeer.commons.ui

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class OutlinedTextFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOutlinedTextFieldDisplaysPlaceholder() {
        composeTestRule.setContent {
            me.pegbeer.commons.ui.OutlinedTextField(
                placeholder = "Placeholder"
            )
        }

        // Verifica que el placeholder se muestra cuando el texto está vacío
        composeTestRule.onNodeWithText("Placeholder").assertExists()
    }

    @Test
    fun testOutlinedTextFieldInput() {
        composeTestRule.setContent {
            me.pegbeer.commons.ui.OutlinedTextField(
                placeholder = "Placeholder"
            )
        }

        // Ingresa texto en el OutlinedTextField
        composeTestRule.onNodeWithText("Placeholder").performTextInput("Hello")

        // Verifica que el texto ingresado se muestra correctamente
        composeTestRule.onNodeWithText("Hello").assertTextEquals("Hello")
    }
}