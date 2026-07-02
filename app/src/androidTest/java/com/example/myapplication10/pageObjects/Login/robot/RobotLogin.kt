package com.example.myapplication10.pageObjects.Login.robot


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.myapplication10.R
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.BEM_VINDO
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.DIGITE_PASSWORD
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.DIGITE_USERNAME
import com.example.myapplication10.pageObjects.Login.constants.ConstantsLogin.TEXTO_LOGADO


class RobotLogin {

    fun validarTituloNaTela(){

        onView(withText(BEM_VINDO)).check(matches(isDisplayed()))
    }
    fun escreverUser(){
        onView(withId(CAMPO_USERNAME)).perform(typeText(DIGITE_USERNAME))
    }
    fun escreverSenha(){
        onView(withId(R.id.et_password)).perform(typeText(DIGITE_PASSWORD))
    }
    fun clicarBotaoLogin(){
        onView(withId(R.id.btn_login)).perform(click())
    }
    fun fecharTeclado(){
        closeSoftKeyboard()
    }
    fun logadoSucesso(){
        onView(withText(TEXTO_LOGADO)).check(matches(isDisplayed()))

    }
    companion object{
        private val CAMPO_USERNAME = R.id.et_username
    }

}