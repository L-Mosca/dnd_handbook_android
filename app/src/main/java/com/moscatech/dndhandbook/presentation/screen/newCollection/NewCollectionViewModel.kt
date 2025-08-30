package com.moscatech.dndhandbook.presentation.screen.newCollection

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.moscatech.dndhandbook.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewCollectionViewModel @Inject constructor(
    crashlytics: FirebaseCrashlytics,
) : BaseViewModel(crashlytics)