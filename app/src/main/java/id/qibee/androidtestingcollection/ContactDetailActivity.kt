package id.qibee.androidtestingcollection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.qibee.androidtestingcollection.model.Contact
import kotlinx.android.synthetic.main.activity_contact_detail.*

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val contactIntent = intent.getParcelableExtra<Contact>("contact")

        contactIntent?.let {
            tvNamaAkunDetail.text = it.akun
        }
    }
}
