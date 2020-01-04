package id.qibee.androidtestingcollection


import android.widget.DatePicker
import android.widget.TimePicker
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TimePickerTestFromScratch {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun timePickerTest() {

        onView(withId(R.id.btnTimePickerTesting)).perform(click())

        onView(withId(R.id.btnSetTime)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSetTime)).perform(click())

        onView(withClassName(`is`(TimePicker::class.java.name))).perform(
            PickerActions.setTime(
                13,
                15
            )
        )

        onView(withId(android.R.id.button1)).perform(click())

        Thread.sleep(200)

        onView(withId(R.id.tvTime)).check(matches(withText("13:15")))

        onView(withId(R.id.btnSetDate)).perform(click())

        onView(withClassName(`is`(DatePicker::class.java.name))).perform(
            PickerActions.setDate(
                2020,
                1,
                4
            )
        )

        onView(withId(android.R.id.button1)).perform(click())

        Thread.sleep(200)

        onView(withId(R.id.tvDate)).check(matches(withText("2020-1-4")))

    }
}
