package com.rolochat.homework.ui.contacts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rolochat.homework.enums.FilterType
import com.rolochat.homework.model.api.ApiResult
import com.rolochat.homework.model.api.model.response.Contact
import com.rolochat.homework.model.repository.RoloDbRepository
import com.rolochat.homework.model.repository.RoloRepository
import com.rolochat.homework.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ContactsViewModel @ViewModelInject constructor(
        private var roloRepository: RoloRepository,
        private var roloDbRepository: RoloDbRepository
) : BaseViewModel() {

    private val _contactsResult = MutableLiveData<ApiResult<List<Contact>?>>()
    val contactsResult: LiveData<ApiResult<List<Contact>?>> = _contactsResult

    private val _starredContactsResult = MutableLiveData<ApiResult<List<Contact>?>>()
    val starredContactsResult: LiveData<ApiResult<List<Contact>?>> = _starredContactsResult

    private val _currentFilterResult = MutableLiveData<FilterType>()
    val currentFilterResult: LiveData<FilterType> = _currentFilterResult


    fun getAllContacts() {
        viewModelScope.launch {
            roloRepository.getContacts()
                    .onStart { _contactsResult.value = ApiResult.loading() }
                    .catch { e -> _contactsResult.value = ApiResult.error(e) }
                    .onCompletion { _contactsResult.value = ApiResult.loaded() }
                    .collect { _contactsResult.value = ApiResult.success(it) }
        }
    }

    fun getStarredContacts() {
        viewModelScope.launch {
            roloRepository.getStarredContacts()
                    .onStart { _starredContactsResult.value = ApiResult.loading() }
                    .catch { e -> _starredContactsResult.value = ApiResult.error(e) }
                    .onCompletion { _starredContactsResult.value = ApiResult.loaded() }
                    .collect {
                        _starredContactsResult.value = ApiResult.success(it)
                    }
        }
    }


    fun updateFavorite(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            roloDbRepository.updateContactsData(contact)
        }
    }

    fun updateFilter(type: FilterType) {
        if (_currentFilterResult.value != type)
            _currentFilterResult.value = type
    }
}