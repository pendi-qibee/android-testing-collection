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
            Contact(5, "Channel Telegram", "@AndroidLab")
        )
}