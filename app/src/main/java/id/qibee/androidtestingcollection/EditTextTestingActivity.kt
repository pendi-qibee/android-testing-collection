package id.qibee.androidtestingcollection

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_text_testing.*

class EditTextTestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_testing)

        btnPesan.setOnClickListener {

            //menyimpan value dari edittext
            val menu1 = etMenu1.text.toString()
            val menu2 = etMenu2.text.toString()

            //menampilkan textview respon pesanan
            tvResponPesanan.visibility = View.VISIBLE
            tvResponPesanan.text = "Pesanan kamu sudah dicatat : \n $menu1 dan $menu2"
        }
    }
}
