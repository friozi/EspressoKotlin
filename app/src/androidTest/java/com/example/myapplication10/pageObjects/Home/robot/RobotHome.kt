package com.example.myapplication10.pageObjects.Home.robot

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myapplication10.R
import com.example.myapplication10.pageObjects.Home.constants.ConstantsHome.CATEGORY_BEACHFRONT
import com.example.myapplication10.pageObjects.Home.constants.ConstantsHome.FIRST_STAY_LOCATION
import com.example.myapplication10.pageObjects.Home.constants.ConstantsHome.FIRST_STAY_PRICE
import com.example.myapplication10.pageObjects.Home.constants.ConstantsHome.SEARCH_HINT_TITLE
import org.hamcrest.Matchers.allOf

class RobotHome {

    fun checkSearchBarIsVisible() {
        onView(withId(R.id.searchCard)).check(matches(isDisplayed()))
        onView(withText(SEARCH_HINT_TITLE)).check(matches(isDisplayed()))
    }

    fun checkCategoryExists(categoryName: String = CATEGORY_BEACHFRONT) {
        onView(allOf(withText(categoryName), isDisplayed())).check(matches(isDisplayed()))
    }

    fun checkStayLocation(location: String = FIRST_STAY_LOCATION) {
        onView(allOf(withText(location), isDisplayed())).check(matches(isDisplayed()))
    }

    fun checkStayPrice(price: String = FIRST_STAY_PRICE) {
        onView(allOf(withText(price), isDisplayed())).check(matches(isDisplayed()))
    }
}
