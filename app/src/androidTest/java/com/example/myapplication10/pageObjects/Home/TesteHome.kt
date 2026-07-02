package com.example.myapplication10.pageObjects.Home

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.myapplication10.MainActivity
import com.example.myapplication10.pageObjects.Home.robot.RobotHome
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TesteHome {

    private val robot = RobotHome()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun validateAirbnbHomeLayout() {
        robot.checkSearchBarIsVisible()
        robot.checkCategoryExists("Beachfront")
        robot.checkCategoryExists("Cabins")
        robot.checkStayLocation("Guarda do Embaú, Brazil")
        robot.checkStayPrice("R$ 450")
    }
}
