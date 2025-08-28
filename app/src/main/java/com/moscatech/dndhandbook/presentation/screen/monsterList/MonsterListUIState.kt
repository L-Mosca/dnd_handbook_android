package com.moscatech.dndhandbook.presentation.screen.monsterList

import com.moscatech.dndhandbook.domain.models.base.DefaultList

data class MonsterListUIState(
    val isLoading: Boolean = false,
    val showError: Boolean = false,
    val showEmptyList: Boolean = false,
    val monsterList: DefaultList = DefaultList(),
    val filterList: DefaultList = DefaultList(),
    val filterText: String = "",
) {
    fun addList(list: DefaultList) = copy(
        monsterList = list,
        filterList = list,
        isLoading = false,
        showError = false,
        showEmptyList = false,
    )

    fun updateFilterList(list: DefaultList) = copy(
        filterList = list,
        showEmptyList = list.results.isEmpty(),
        showError = false,
        isLoading = false,
    )

    fun showError() = copy(
        showEmptyList = false,
        showError = true,
        isLoading = false,
        monsterList = DefaultList(),
        filterList = DefaultList(),
    )

    fun showLoading() = copy(
        showEmptyList = false,
        showError = false,
        isLoading = true,
    )
}