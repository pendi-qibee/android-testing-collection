package id.qibee.androidtestingcollection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.qibee.androidtestingcollection.model.Contact
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val clickListener: ListClickListener = this::onItemClicked
    private val mAdapter = RvAdapter(clickListener)
    private lateinit var rvLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        rvLayoutManager = LinearLayoutManager(this)
        rvContact.apply {
            layoutManager = rvLayoutManager
            adapter = mAdapter
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.HORIZONTAL
                )
            )
        }
    }

    private fun onItemClicked(itemContact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        intent.putExtra("contact", itemContact)
        startActivity(intent)
    }
}
