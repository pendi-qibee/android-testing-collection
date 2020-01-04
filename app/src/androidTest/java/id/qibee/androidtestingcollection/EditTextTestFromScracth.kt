package id.qibee.androidtestingcollection


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EditTextTestFromScracth {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun editTextTest() {

        //klik button "Tes Edit Text"
        onView(withId(R.id.btnEditTextTesting)).perform(click())

        //cek apakah TextView Menu 1 sudah ditampilkan
        onView(withId(R.id.tvLabelMenu1)).check(matches(isDisplayed()))

        // memberikan input text pada menu 1
        onView(withId(R.id.etMenu1)).perform(replaceText("ayam goreng"), closeSoftKeyboard())

        // memberikan input text pada menu 2
        onView(withId(R.id.etMenu2)).perform(replaceText("tempe bakar"), closeSoftKeyboard())

        // klik button Pesan
        onView(withId(R.id.btnPesan)).perform(click())

        //kadang perlu menambahkan thread sleep
        //Thread.sleep(200)

        //cek apakah textview respon ditampilkan
        onView(withId(R.id.tvResponPesanan)).check(matches(isDisplayed()))
    }
}
