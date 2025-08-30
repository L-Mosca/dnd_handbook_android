package com.moscatech.dndhandbook.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel(
    private val crashlytics: FirebaseCrashlytics,
) : ViewModel() {

    fun defaultLaunch(
        exceptionHandler: ((Throwable) -> Unit)? = null,
        dispatcher: CoroutineContext = EmptyCoroutineContext,
        loadingStatus: ((Boolean) -> Unit)? = null,
        function: suspend () -> Unit,
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                loadingStatus?.invoke(true)
                function.invoke()
            } catch (throwable: Throwable) {
                crashlytics.recordException(throwable)
                throwable.printStackTrace()
                defaultCatch(throwable, exceptionHandler)
            } finally {
                loadingStatus?.invoke(false)
            }
        }
    }

    private fun defaultCatch(
        throwable: Throwable,
        exceptionHandler: ((Throwable) -> Unit)? = null,
    ) {
        when {
            exceptionHandler != null -> exceptionHandler.invoke(throwable)
        }
    }
}