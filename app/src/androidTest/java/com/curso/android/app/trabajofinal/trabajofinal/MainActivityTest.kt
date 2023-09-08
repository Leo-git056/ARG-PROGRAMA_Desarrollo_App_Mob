package com.curso.android.app.trabajofinal.trabajofinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.trabajofinal.trabajofinal.view.MainActivity
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
    @Test
    fun mainActivity_ingresodepalabrasiguales(){
        Espresso.onView(ViewMatchers.withId(R.id.editTextText)
        ).perform(
            ViewActions.typeText("Probando")
        )
        Espresso.onView(ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.typeText("Probando")
        )


              Espresso.onView(ViewMatchers.withId(R.id.button)
               ).perform(
                   ViewActions.click()
               )

                Espresso.onView(
                      ViewMatchers.withId(R.id.textView3)
                  ).check(
                      ViewAssertions.matches(
                          ViewMatchers.withText("Las cadenas son iguales")
                      )
                  )

    }
    @Test
    fun mainActivity_ingresodepalabradiferentes(){
        Espresso.onView(ViewMatchers.withId(R.id.editTextText)
        ).perform(
            ViewActions.typeText("Somos")
        )
        Espresso.onView(ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.typeText("Diferentes")
        )


        Espresso.onView(ViewMatchers.withId(R.id.button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.textView3)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas son diferentes")
            )
        )

    }
}