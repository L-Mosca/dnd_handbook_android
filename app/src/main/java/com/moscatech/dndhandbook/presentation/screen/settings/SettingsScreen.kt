@file:OptIn(ExperimentalMaterial3Api::class)

package com.moscatech.dndhandbook.presentation.screen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moscatech.dndhandbook.BuildConfig
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs
import com.moscatech.dndhandbook.presentation.baseComponents.BaseScaffold
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.baseComponents.BaseTopBar
import com.moscatech.dndhandbook.presentation.baseComponents.placeHolders.ErrorContentPlaceHolder
import com.moscatech.dndhandbook.presentation.screen.settings.components.SettingsOption
import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson900
import com.moscatech.dndhandbook.utils.openUrlInApp

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    onBackPressed: (() -> Unit) = {},
) {

    val uiState by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    Screen(
        showLoading = uiState.showLoading,
        showError = uiState.showError,
        settingsConfigs = uiState.configs,
        onBackPressed = onBackPressed,
        onPrivacyPoliciesClicked = { openUrlInApp(it, context) },
        onApiReferenceClicked = { openUrlInApp(it, context) },
        onDbReferenceClicked = { openUrlInApp(it, context) },
        onApiDocsClicked = { openUrlInApp(it, context) },
        onReloadClicked = { viewModel.reload() },
    )
}

@Composable
private fun Screen(
    showLoading: Boolean = false,
    showError: Boolean = false,
    settingsConfigs: SettingsConfigs? = null,
    onBackPressed: (() -> Unit) = {},
    onPrivacyPoliciesClicked: ((String) -> Unit) = {},
    onApiReferenceClicked: ((String) -> Unit) = {},
    onDbReferenceClicked: ((String) -> Unit) = {},
    onApiDocsClicked: ((String) -> Unit) = {},
    onReloadClicked: (() -> Unit) = {},
) {
    BaseScaffold(
        topBar = { scrollBehavior ->
            BaseTopBar(
                title = stringResource(R.string.settings),
                onBackClick = onBackPressed,
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding, _ ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Black800)
        ) {
            BaseText(
                text = "See:",
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 30.dp, start = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            SettingsOption(
                text = stringResource(R.string.privacy_policies),
                onOptionClicked = {
                    onPrivacyPoliciesClicked.invoke(BuildConfig.PRIVACY_POLICIES)
                },
            )

            Spacer(modifier = Modifier.height(10.dp))

            SettingsOption(
                text = stringResource(R.string.api_reference),
                hexagonColor = Crimson800,
                onOptionClicked = {
                    onApiReferenceClicked.invoke(settingsConfigs?.apiRepo ?: BuildConfig.API_REPO)
                },
            )

            SettingsOption(
                text = stringResource(R.string.database_reference),
                hexagonColor = Crimson800,
                onOptionClicked = {
                    onDbReferenceClicked.invoke(
                        settingsConfigs?.databaseRepo ?: BuildConfig.DATABASE_REPO
                    )
                },
            )

            SettingsOption(
                text = stringResource(R.string.api_doc),
                hexagonColor = Crimson800,
                onOptionClicked = {
                    onApiDocsClicked.invoke(settingsConfigs?.apiDoc ?: BuildConfig.API_DOC)
                },
            )

            Spacer(modifier = Modifier.weight(1f))

            if (settingsConfigs?.hasLicense() == true) {
                BaseText(
                    text = settingsConfigs.license,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center,
                    color = Crimson900,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
        ErrorContentPlaceHolder(
            show = showError,
            message = stringResource(R.string.unexpected_error),
            onTryAgainClicked = { onReloadClicked.invoke() },
            modifier = Modifier
                .fillMaxSize()
                .background(Black800)
        )
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    Screen(
        settingsConfigs = SettingsConfigs(license = "License text")
    )
}

@Preview
@Composable
private fun SettingsScreenErrorPreview() {
    Screen(
        settingsConfigs = SettingsConfigs(),
        showError = true,
    )
}