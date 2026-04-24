package com.example.android_studio_test_exercice.view

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeRight
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Rule
import org.junit.Test

class MainViewInstrumentedTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun mainView_displaysMainElements() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("wifiText_id").assertExists()
        composeRule.onNodeWithTag("triStateText_id").assertExists()
        composeRule.onNodeWithTag("pilotText_id").assertExists()
        composeRule.onNodeWithTag("volumeText_id").assertTextEquals("Volum: 0%")
        composeRule.onNodeWithTag("outlinedTextField_id").assertExists()
        composeRule.onNodeWithTag("searchButton_id").assertExists()
        composeRule.onNodeWithTag("toggleButton_id").assertExists()
        composeRule.onNodeWithTag("checkBoxMulti_id").assertIsOff()
    }

    @Test
    fun mainView_toggleButton_changesStateText() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("toggleButtonText_id", useUnmergedTree = true).assertTextEquals("Desactivat")
        composeRule.onNodeWithTag("toggleButton_id").performClick()
        composeRule.onNodeWithTag("toggleButtonText_id", useUnmergedTree = true).assertTextEquals("Activat")
    }

    @Test
    fun mainView_wifiSwitch_togglesState() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("switchWifi_id").assertIsOn()
        composeRule.onNodeWithTag("switchWifi_id").performClick()
        composeRule.onNodeWithTag("switchWifi_id").assertIsOff()
    }

    @Test
    fun mainView_multiCheckbox_togglesState() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("checkBoxMulti_id").assertIsOff()
        composeRule.onNodeWithTag("checkBoxMulti_id").performClick()
        composeRule.onNodeWithTag("checkBoxMulti_id").assertIsOn()
    }

    @Test
    fun mainView_vegaCheckbox_togglesState() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("checkBoxVega_id").assertIsOff()
        composeRule.onNodeWithTag("checkBoxVega_id").performClick()
        composeRule.onNodeWithTag("checkBoxVega_id").assertIsOn()
    }

    @Test
    fun mainView_selectedItemDropdown_changesText() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("selectedItemText_id").assertTextEquals("Opción A")
        composeRule.onNodeWithTag("selectedItemText_id").performClick()
        composeRule.onNodeWithText("Opción B").performClick()
        composeRule.onNodeWithTag("selectedItemText_id").assertTextEquals("Opción B")
    }

    @Test
    fun mainView_searchField_updatesTextAndShowsSnackbar() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("outlinedTextField_id", useUnmergedTree = true).performTextInput("Messi")
        composeRule.onNodeWithTag("outlinedTextField_id", useUnmergedTree = true).assertTextEquals("Messi")
        composeRule.onNodeWithTag("searchButton_id").performClick()
        composeRule.onNodeWithTag("snackbarText_id").assertExists()
    }

    @Test
    fun mainView_radioButton_changesSelectedOption() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeRule.onNodeWithTag("radioButton_LamineYamal").performClick()
        composeRule.onNodeWithTag("radioButton_LamineYamal").assertIsSelected()
    }

    @Test
    fun mainView_slider_updatesVolumeText() {
        composeRule.setContent {
            MainView(myViewModel = MainViewModel())
        }
        composeRule.onNodeWithTag("sliderVolume_id").performTouchInput {
            this.swipeRight()
        }
        composeRule.onNodeWithTag("volumeText_id", useUnmergedTree = true).assertTextEquals("Volum: 100%")
    }
}
