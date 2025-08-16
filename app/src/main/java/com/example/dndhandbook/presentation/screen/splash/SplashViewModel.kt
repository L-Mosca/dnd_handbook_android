package com.example.dndhandbook.presentation.screen.splash

import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.data.repository.monster.MonsterRepositoryContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val monsterRepository: MonsterRepositoryContract
) : BaseViewModel() {

    private val _showHome = MutableStateFlow(false)
    val showHome: StateFlow<Boolean> = _showHome.asStateFlow()

    init {
        //updateBestiaryData()
        defaultLaunch {
            delay(2000)
            _showHome.update { true }
        }
    }

    private fun updateBestiaryData() {
        defaultLaunch(
            function = {
                monsterRepository.saveAllMonsters()
                delay(1000)
                _showHome.update { true }
            }
        )
    }
}