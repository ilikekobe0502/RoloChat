package com.rolochat.homework.ui.contacts

import com.rolochat.homework.model.api.model.response.Contact

class ContactsFuncListener(
        val onFavoriteClick: (Contact) -> Unit = { },
        val onItemClick: (Contact) -> Unit = { },
)