package com.curso.android.app.trabajofinal.trabajofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.trabajofinal.trabajofinal.ViewModel.ComparaViewModel
import com.curso.android.app.trabajofinal.trabajofinal.view.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ViewModelUnitTest {

    private lateinit var viewModel : ComparaViewModel


    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = ComparaViewModel()

    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }


    @Test
    fun ComparaViewModel_CheckInitialValue1() = runTest{
        val palabra1 = viewModel.palabra1.value
        assertEquals("", palabra1)
    }
    @Test
    fun ComparaViewModel_CheckInitialValue2() = runTest{
        val palabra2 = viewModel.palabra2.value
        assertEquals("", palabra2)
    }


    @Test

    fun ComparaViewModel_CheckNewValue1() = runTest{
        launch {


            viewModel.setPalabra1("Hola")
        }

        advanceUntilIdle()
        val palabra1 = viewModel.palabra1.value
        assertEquals("Hola",palabra1)
    }

    @Test
    fun ComparaViewModel_CheckNewValue2() = runTest{
        launch {
            viewModel.setPalabra2("Hola")
        }
        advanceUntilIdle()
        val palabra2 = viewModel.palabra2.value
        assertEquals("Hola",palabra2)
    }
    @Test

    fun ComparaViewModel_CheckComparadorTrue() = runTest{
        launch {
            viewModel.setPalabra1("Hola")
            viewModel.setPalabra2("Hola")
            viewModel.compararCadenas()
        }

        advanceUntilIdle()
        val iguales = viewModel.iguales.value

        assertEquals(true,iguales)

    }
    @Test
    fun ComparaViewModel_CheckComparadorFalse() = runTest{
        launch {
            viewModel.setPalabra1("Somos")
            viewModel.setPalabra2("Distintas")
            viewModel.compararCadenas()
        }
        advanceUntilIdle()
        val iguales = viewModel.iguales.value
        assertEquals(true,iguales)

    }






}