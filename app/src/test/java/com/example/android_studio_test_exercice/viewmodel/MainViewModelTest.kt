package com.example.android_studio_test_exercice.viewmodel


import androidx.compose.ui.state.ToggleableState
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun checkSumaTest() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun initialState() {
        assertEquals(true, viewModel.estatSwitch.value)
        assertEquals(false, viewModel.esVegetaria.value)
        assertEquals(false, viewModel.esVega.value)
        assertEquals(true, viewModel.esCarnivor.value)
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
        assertEquals("Messi", viewModel.selectedOption.value)
        assertEquals(0f, viewModel.sliderValue.value ?: 0f, 0f)
        assertEquals(false, viewModel.expanded.value)
        assertEquals("Opción A", viewModel.selectedItem.value)
        assertEquals("", viewModel.searchText.value)
        assertEquals(false, viewModel.showSnackbar.value)
        assertEquals(false, viewModel.toggleState.value)
    }

    @Test
    fun checkToggleEstatSwitch() {
        viewModel.toggleEstatSwitch()
        assertEquals(false, viewModel.estatSwitch.value)

        viewModel.toggleEstatSwitch()
        assertEquals(true, viewModel.estatSwitch.value)
    }

    @Test
    fun checkToggleEsVegetaria() {
        viewModel.toggleEsVegetaria()
        assertEquals(true, viewModel.esVegetaria.value)

        viewModel.toggleEsVegetaria()
        assertEquals(false, viewModel.esVegetaria.value)
    }

    @Test
    fun checkToggleEsVega() {
        viewModel.toggleEsVega()
        assertEquals(true, viewModel.esVega.value)

        viewModel.toggleEsVega()
        assertEquals(false, viewModel.esVega.value)
    }

    @Test
    fun checkToggleEsCarnivor() {
        viewModel.toggleEsCarnivor()
        assertEquals(false, viewModel.esCarnivor.value)

        viewModel.toggleEsCarnivor()
        assertEquals(true, viewModel.esCarnivor.value)
    }

    @Test
    fun checkToggleTriStateStatus() {
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)

        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    @Test
    fun checkSetSelectedOption() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)
    }

    @Test
    fun checkSetSliderValue() {
        viewModel.setSliderValue(55f)
        assertEquals(55f, viewModel.sliderValue.value ?: 0f, 0f)
    }

    @Test
    fun checkSetExpanded() {
        viewModel.setExpanded(true)
        assertEquals(true, viewModel.expanded.value)
    }

    @Test
    fun checkSetSelectedItem() {
        viewModel.setSelectedItem("Opción B")
        assertEquals("Opción B", viewModel.selectedItem.value)
    }

    @Test
    fun checkSetSearchText() {
        viewModel.setSearchText("Messi")
        assertEquals("Messi", viewModel.searchText.value)
    }

    @Test
    fun checkPerformSearch() {
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun checkToggle() {
        viewModel.toggle()
        assertEquals(true, viewModel.toggleState.value)

        viewModel.toggle()
        assertEquals(false, viewModel.toggleState.value)
    }
}
