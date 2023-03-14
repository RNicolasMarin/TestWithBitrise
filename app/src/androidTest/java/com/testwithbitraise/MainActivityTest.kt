package com.testwithbitraise

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun firstNumberEmpty() {
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withText(R.string.invalid_first_number))
            .check(matches(isDisplayed()))
    }

    @Test
    fun symbolEmpty() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withText(R.string.invalid_symbol))
            .check(matches(isDisplayed()))
    }

    @Test
    fun secondNumberEmpty() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.symbolEt)).perform(replaceText("/"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withText(R.string.invalid_second_number))
            .check(matches(isDisplayed()))
    }

    @Test
    fun additionSuccess() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.symbolEt)).perform(replaceText("+"))
        onView(withId(R.id.secondNumberEt)).perform(replaceText("5.7"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withId(R.id.resultTv)).check(matches(withText("20.7")))
    }

    @Test
    fun subtractionSuccess() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.symbolEt)).perform(replaceText("-"))
        onView(withId(R.id.secondNumberEt)).perform(replaceText("5.0"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withId(R.id.resultTv)).check(matches(withText("10.0")))
    }

    @Test
    fun multiplicationSuccess() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.symbolEt)).perform(replaceText("x"))
        onView(withId(R.id.secondNumberEt)).perform(replaceText("3"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withId(R.id.resultTv)).check(matches(withText("45.0")))
    }

    @Test
    fun divisionSuccess() {
        onView(withId(R.id.firstNumberEt)).perform(replaceText("15"))
        onView(withId(R.id.symbolEt)).perform(replaceText("/"))
        onView(withId(R.id.secondNumberEt)).perform(replaceText("3"))
        onView(withId(R.id.calculateBt)).perform(click())
        onView(withId(R.id.resultTv)).check(matches(withText("5.0")))
    }
}