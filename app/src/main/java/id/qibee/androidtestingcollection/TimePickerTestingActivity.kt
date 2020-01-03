package id.qibee.androidtestingcollection

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_time_picker_testing.*
import java.util.*

class TimePickerTestingActivity : AppCompatActivity() {

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0
    private var hour: Int = 0
    private var minute: Int = 0
    private var second: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker_testing)
        getCalendarValue()
        btnSetDate.setOnClickListener {
            showDatePickerDialog()
        }
        btnSetTime.setOnClickListener {
            showTimePickerDialog()
        }
    }


    private fun getCalendarValue() {
        val calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DATE)
        hour = calendar.get(Calendar.HOUR_OF_DAY)
        minute = calendar.get(Calendar.MINUTE)
        second = calendar.get(Calendar.SECOND)
    }

    private fun showDatePickerDialog() {
        val datePickerDialog =
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val pickedDate = "$year-${month + 1}-$dayOfMonth"
                    tvDate.text = pickedDate
                },
                year,
                month,
                day
            )
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val pickedTime = "$hourOfDay:$minute"
                tvTime.text = pickedTime
            },
            hour,
            minute,
            true
        )
        timePickerDialog.show()
    }
}
