package com.moscatech.dndhandbook.presentation.screen.monsterDetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.domain.useCase.bestiary.getMonster.GetMonsterUseCase
import com.moscatech.dndhandbook.navigation.MonsterDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MonsterDetailViewModel @Inject constructor(
    private val getMonsterDetailUseCase: GetMonsterUseCase,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MonsterDetailState())
    val uiState: StateFlow<MonsterDetailState> = _uiState.asStateFlow()

    private var isFromCollection = false
    private var monsterIndex: String

    val deepLinkArg: String = savedStateHandle.get<String>("deepLinkMonsterIndex") ?: ""

    init {
        Log.e("test", "deepLink: $deepLinkArg")
        if (deepLinkArg.isNotBlank()) {
            monsterIndex = deepLinkArg
        } else {
            savedStateHandle.toRoute<MonsterDetailRoute>().let { args ->
                isFromCollection = args.isFromCollection
                monsterIndex = args.monsterIndex

                _uiState.update {
                    it.copy(isFromCollection = args.isFromCollection)
                }
            }
        }
        getMonsterDetail()
    }

    fun getMonsterDetail() {
        defaultLaunch(
            loadingStatus = { isLoading ->
                if (isLoading) _uiState.update { it.showLoading() }
            },
            exceptionHandler = { _ ->
                _uiState.update { it.showError() }
            },
            function = {
                val monster = getMonsterDetailUseCase.invoke(monsterIndex)
                _uiState.update { it.setMonsterDetail(monster) }
            },
        )
    }
}