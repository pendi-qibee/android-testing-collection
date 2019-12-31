package id.qibee.androidtestingcollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvEditTextTesting.setOnClickListener {
            startActivity(Intent(this, EditTextTestingActivity::class.java))
        }

        tvTimePickerTesting.setOnClickListener {
            startActivity(Intent(this, TimePickerTestingActivity::class.java))
        }
    }
}
