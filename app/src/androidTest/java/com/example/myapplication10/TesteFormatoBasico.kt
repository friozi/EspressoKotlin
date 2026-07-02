package com.example.myapplication10

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class TesteFormatoBasico {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    @Test
    fun testeLogin() {
        onView(withText("Bem-vindo")).check(matches(isDisplayed()))
        onView(withText("Faça login para continuar")).check(matches(isDisplayed()))
        onView(withId(R.id.et_username)).perform(typeText("admin"))
        closeSoftKeyboard()
        onView(withId(R.id.et_password)).perform(typeText("12345678"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_login)).perform(click())
        onView(withText("Logado com Sucesso")).check(matches(isDisplayed()))
    }
    @Test
    fun testefalha() {
        onView(withText("Bom dia")).check(matches(isDisplayed()))

    }
}