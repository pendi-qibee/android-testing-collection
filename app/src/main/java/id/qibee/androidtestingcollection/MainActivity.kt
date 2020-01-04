package id.qibee.androidtestingcollection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEditTextTesting.setOnClickListener {
            startActivity(Intent(this, EditTextTestingActivity::class.java))
        }

        btnTimePickerTesting.setOnClickListener {
            startActivity(Intent(this, TimePickerTestingActivity::class.java))
        }
    }
}
