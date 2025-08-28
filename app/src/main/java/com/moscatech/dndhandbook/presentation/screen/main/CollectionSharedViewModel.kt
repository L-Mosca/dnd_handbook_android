package com.moscatech.dndhandbook.presentation.screen.main

import android.net.Uri
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.domain.helper.file.FileContract
import com.moscatech.dndhandbook.domain.helper.pdf.PDFHelper
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.domain.useCase.collection.deleteCollectionUseCase.DeleteCollectionUseCase
import com.moscatech.dndhandbook.domain.useCase.collection.newCollectionUseCase.NewCollectionUseCase
import com.moscatech.dndhandbook.domain.useCase.collection.pdfCollectionUseCase.PDFCollectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CollectionSharedViewModel @Inject constructor(
    private val newCollectionUseCase: NewCollectionUseCase,
    private val deleteCollectionUseCase: DeleteCollectionUseCase,
    private val pdfCollectionUseCase: PDFCollectionUseCase,
    private val fileHelper: FileContract,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(NewCollectionUIState())
    val uiState: StateFlow<NewCollectionUIState> = _uiState.asStateFlow()

    private var hasChanges = false

    fun setCollection(newCollection: MonsterCollection) {
        _uiState.update { it.copy(collection = newCollection) }
    }

    fun updateName(name: String) {
        val oldCollection = _uiState.value.collection.copy()
        _uiState.update {
            it.copy(collection = it.collection.copy(name = name))
        }
        hasChanges = oldCollection.hasChanges(_uiState.value.collection)
    }

    fun addMonster(monster: DefaultObject) {
        val newList = (_uiState.value.collection.monsterList ?: emptyList()).toMutableList()

        if (newList.contains(monster)) return

        newList.add(monster)
        val newCollection =
            _uiState.value.collection.copy(monsterList = newList.sortedBy { it.name })
        hasChanges = _uiState.value.collection.hasChanges(newCollection)
        _uiState.update { it.addMonsterSuccess(newCollection) }
    }

    fun deleteMonster(monster: DefaultObject) {
        val newList = (_uiState.value.collection.monsterList ?: emptyList()).toMutableList()

        if (!newList.contains(monster)) return
        newList.remove(monster)

        val newCollection =
            _uiState.value.collection.copy(monsterList = newList.sortedBy { it.name })
        hasChanges = _uiState.value.collection.hasChanges(newCollection)
        _uiState.update { it.deleteMonsterSuccess(newCollection) }
    }

    fun saveCollection() {
        defaultLaunch(
            function = {
                newCollectionUseCase.invoke(_uiState.value.collection.copy())
                _uiState.update { it.saveSuccess() }
            }
        )
    }

    fun deleteCollection() {
        defaultLaunch {
            deleteCollectionUseCase.invoke(_uiState.value.collection.id)
            _uiState.update { it.deleteSuccess() }
        }
    }

    fun resetData() {
        _uiState.update { it.resetData() }
        hasChanges = false
    }

    fun resetAddMonsterSuccess() {
        _uiState.update { it.copy(addMonsterSuccess = false) }
    }

    fun shareCollection() {
        defaultLaunch {
            newCollectionUseCase.invoke(_uiState.value.collection.copy())
            pdfCollectionUseCase.shareFile(_uiState.value.collection)
        }
    }

    fun downloadCollection(uri: Uri) {
        defaultLaunch {
            showDownloadDialog(false)
            newCollectionUseCase.invoke(_uiState.value.collection.copy())
            val file = pdfCollectionUseCase.generatePDF(_uiState.value.collection)
            fileHelper.saveFile(file, uri)
        }
    }

    fun getFileName(): String {
        if (_uiState.value.collection.name.isBlank()) _uiState.update {
            it.copy(collection = it.collection.copy(name = "unnamed collection"))
        }
        return "${_uiState.value.collection.name}.${PDFHelper.PDF_EXTENSION}"
    }

    fun showDownloadDialog(show: Boolean) {
        _uiState.update { it.copy(showDownloadDialog = show) }
    }

    fun showDeleteDialog(show: Boolean) {
        _uiState.update { it.copy(showDeleteDialog = show) }
    }

    fun showChangesDialog(show: Boolean) {
        _uiState.update { it.copy(showChangesDialog = show) }
    }

    fun hasChanges(): Boolean = hasChanges
}

data class NewCollectionUIState(
    val collection: MonsterCollection = MonsterCollection.newInstance(),
    val saveSuccess: Boolean = false,
    val deleteSuccess: Boolean = false,
    val addMonsterSuccess: Boolean = false,
    val showDownloadDialog: Boolean = false,
    val showDeleteDialog: Boolean = false,
    val showChangesDialog: Boolean = false,
) {
    fun deleteSuccess() = copy(
        collection = MonsterCollection.newInstance(),
        saveSuccess = false,
        deleteSuccess = true,
        addMonsterSuccess = false,
        showDeleteDialog = false,
    )

    fun saveSuccess() = copy(
        collection = MonsterCollection.newInstance(),
        saveSuccess = true,
        deleteSuccess = false,
        addMonsterSuccess = false,
        showChangesDialog = false,
        showDownloadDialog =  false,
        showDeleteDialog = false,
    )

    fun addMonsterSuccess(collection: MonsterCollection) = copy(
        collection = collection,
        saveSuccess = false,
        deleteSuccess = false,
        addMonsterSuccess = true,
    )

    fun deleteMonsterSuccess(collection: MonsterCollection) = copy(
        collection = collection,
        saveSuccess = false,
        deleteSuccess = false,
        addMonsterSuccess = false,
    )

    fun resetData() = copy(
        collection = MonsterCollection.newInstance(),
        saveSuccess = false,
        deleteSuccess = false,
        addMonsterSuccess = false,
        showDeleteDialog = false,
        showDownloadDialog = false,
        showChangesDialog = false,
    )
}