package id.qibee.androidtestingcollection.util

import id.qibee.androidtestingcollection.model.Contact

object ContactData {
    val contactList: List<Contact>
        get() = mutableListOf(
            Contact(1, "Github", "pendi-qibee"),
            Contact(2, "Gitlab", "pendi_qibee"),
            Contact(3, "Blog", "qibandroid.blogspot.com"),
            Contact(4, "Twitter", "@pendimadyana"),
            Contact(5, "Telegram", "@PendiMadyana"),
            Contact(6, "Channel Telegram", "@AndroidLab"),
            Contact(7, "Facebook", "Pendi Madyana"),
            Contact(8, "Alamat", "Semarang Indonesia"),
            Contact(9, "Komunitas", "SANDEC"),
            Contact(10, "IDE", "Android Studio"),
            Contact(11, "Programming Language", "Kotlin"),
            Contact(12, "Remote Work", "Kodingwork")
        )
}