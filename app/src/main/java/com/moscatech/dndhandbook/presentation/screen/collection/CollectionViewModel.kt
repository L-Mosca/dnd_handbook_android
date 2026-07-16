package com.moscatech.dndhandbook.presentation.screen.collection

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.domain.useCase.collection.getCollections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val getCollectionsUseCase: GetCollectionsUseCase,
    crashlytics: FirebaseCrashlytics
) : BaseViewModel(crashlytics) {

    private val _uiState = MutableStateFlow(CollectionUiState())
    val uiState: StateFlow<CollectionUiState> = _uiState.asStateFlow()

    init {
        getList()
    }

    fun getList() {
        defaultLaunch(
            loadingStatus = {},
            exceptionHandler = {},
            function = {
                _uiState.update { it.setCollectionList(getCollectionsUseCase.invoke()) }
            }
        )
    }
}

data class CollectionUiState(
    val collectionList: List<MonsterCollection> = emptyList(),
) {
    fun setCollectionList(list: List<MonsterCollection>) = copy(
        collectionList = list
    )
}