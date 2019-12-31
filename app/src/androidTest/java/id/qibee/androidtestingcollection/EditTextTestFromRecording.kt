package id.qibee.androidtestingcollection


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EditTextTestFromRecording {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun editTextTestFromRecording() {

        //klik button "Tes Edit Text"

        val appCompatButton = onView(
            allOf(
                withId(R.id.tvEditTextTesting), withText("Tes Edit text"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        //cek apakah TextView Menu 1 sudah ditampilkan

        val textView = onView(
            allOf(
                withId(R.id.tvLabelMenu1), withText("Menu 1"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))

        val appCompatEditText = onView(
            allOf(
                withId(R.id.etMenu1),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        // memberikan input text pada menu 1
        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etMenu1),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("ayam goreng"), closeSoftKeyboard())

        // memberikan input text pada menu 2

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etMenu2),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("tempe bakar"), closeSoftKeyboard())

        // klik button Pesan

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.btnPesan), withText("Pesan Sekarang"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        //kadang perlu menambahkan thread sleep
        //Thread.sleep(200)

        //cek apakah textview respon ditampilkan

        val textView2 = onView(
            allOf(
                withId(R.id.tvResponPesanan),
                withText("Pesanan kamu sudah dicatat : \n ayam goreng dan tempe bakar"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(isDisplayed()))
    }

    //function ini digenerate dari Espresso Recording

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
