package com.example.dndhandbook.domain.helper

import kotlinx.coroutines.flow.Flow

interface ConnectivityContract {
    fun hasNetworkConnection(): Boolean
    val isConnected: Flow<Boolean>
}