package id.qibee.androidtestingcollection.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val id: Int,
    val aplikasi: String,
    val akun: String
) : Parcelable