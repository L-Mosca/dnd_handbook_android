package com.moscatech.dndhandbook.presentation.screen.monsterDetail

import com.moscatech.dndhandbook.domain.models.monster.MonsterDetail

data class MonsterDetailState(
    val isLoading: Boolean = false,
    val monsterDetail: MonsterDetail? = null,
    val isFromCollection: Boolean = false,
    val navigateBack: Boolean = false,
    val showError: Boolean = false,
) {

    fun showLoading() = copy(isLoading = true, showError = false, monsterDetail = null)

    fun showError() = copy(isLoading = false, showError = true, monsterDetail = null)

    fun setMonsterDetail(monsterDetail: MonsterDetail?) =
        copy(monsterDetail = monsterDetail ?: MonsterDetail(), isLoading = false, showError = false)
}