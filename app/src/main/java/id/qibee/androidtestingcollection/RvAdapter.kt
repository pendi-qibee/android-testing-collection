package id.qibee.androidtestingcollection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import id.qibee.androidtestingcollection.model.Contact
import id.qibee.androidtestingcollection.util.ContactData

typealias ListClickListener = (Contact) -> Unit

class RvAdapter(private val clickListener: ListClickListener) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private var rekapList = ContactData.contactList.toMutableList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RvAdapter.ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false) as ViewGroup

        return ViewHolder(itemContainer)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textAplikasi: AppCompatTextView = view.findViewById(R.id.tvNamaAplikasi)
        val textAkun: AppCompatTextView = view.findViewById(R.id.tvNamaAkun)
    }

    override fun getItemCount(): Int  = rekapList.size

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        holder.textAplikasi.text = rekapList[position].aplikasi
        holder.textAkun.text = rekapList[position].akun

        holder.itemView.setOnClickListener {
            clickListener(rekapList[position])
        }
    }
}