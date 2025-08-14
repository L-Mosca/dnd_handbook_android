package com.example.dndhandbook.domain.helper.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityContract {
    fun hasNetworkConnection(): Boolean
    val isConnected: Flow<Boolean>
}