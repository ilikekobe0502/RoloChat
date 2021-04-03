package com.rolochat.homework.ui.contacts

import com.rolochat.homework.model.api.model.response.Contact

class ContactsFuncListener(
        /**
         * Favorite button click event
         */
        val onFavoriteClick: (Contact) -> Unit = { },
        /**
         * Item click event
         */
        val onItemClick: (Contact) -> Unit = { },
)