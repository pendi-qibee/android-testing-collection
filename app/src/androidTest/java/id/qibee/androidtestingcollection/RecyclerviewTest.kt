package id.qibee.androidtestingcollection


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import id.qibee.androidtestingcollection.util.ContactData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RecyclerviewTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    val TELEGRAM_ACCOUNT_POSITION = 4

    @Test
    fun test_isContactList_displayed() {
        onView(withId(R.id.btnRecyclerViewTesting)).perform(click())
        onView(withId(R.id.rvContact)).check(matches(isDisplayed()))
    }

    @Test
    fun testClickTelegramPosition() {
        onView(withId(R.id.btnRecyclerViewTesting)).perform(click())
        onView(withId(R.id.rvContact)).perform(
            actionOnItemAtPosition<RvAdapter.ViewHolder>(
                TELEGRAM_ACCOUNT_POSITION,
                click()
            )
        )

        onView(withId(R.id.tvNamaAkunDetail)).check(matches(withText("@PendiMadyana")))
    }

    @Test
    fun testScrollToBottom() {
        onView(withId(R.id.btnRecyclerViewTesting)).perform(click())
        onView(withId(R.id.rvContact)).perform(
            scrollToPosition<RvAdapter.ViewHolder>(ContactData.contactList.size - 1)
        )

        onView(withText("Remote Work")).perform(click())
        onView(withId(R.id.tvNamaAkunDetail)).check(matches(withText("Kodingwork")))
    }
}
