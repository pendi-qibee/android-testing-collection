package id.qibee.androidtestingcollection

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SpinnerActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    private val TAHU_GIMBAL_POSITION = 2

    @Test
    fun testSelectTahuGimbal() {

        onView(withId(R.id.btnSpinnerTesting))
            .perform(click())

        onView(withId(R.id.spinnerMakanan))
            .check(matches(isDisplayed()))
            .perform(click())

        onData(anything()).atPosition(TAHU_GIMBAL_POSITION)
            .perform(click())

        onView(withId(R.id.spinnerMakanan))
            .check(matches(withSpinnerText(containsString("Tahu Gimbal"))))
    }

    @Test
    fun testSelectLumpia() {

        onView(withId(R.id.btnSpinnerTesting))
            .perform(click())

        onView(withId(R.id.spinnerMakanan))
            .check(matches(isDisplayed()))
            .perform(click())

        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`("Lumpia")
            )
        )
            .perform(click())

        onView(withId(R.id.spinnerMakanan))
            .check(matches(withSpinnerText(containsString("Lumpia"))))
    }
}