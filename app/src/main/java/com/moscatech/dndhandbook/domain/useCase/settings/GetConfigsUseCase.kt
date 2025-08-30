package com.moscatech.dndhandbook.domain.useCase.settings

import com.moscatech.dndhandbook.data.repository.settings.SettingsContract
import com.moscatech.dndhandbook.domain.models.settings.NullSettingsException
import com.moscatech.dndhandbook.domain.models.settings.SettingsConfigs
import javax.inject.Inject

class GetConfigsUseCase @Inject constructor(
    private val settingsRepository: SettingsContract,
) {
    suspend fun invoke(): SettingsConfigs? {
        val configs = settingsRepository.getConfigs()

        if (configs == null) throw NullSettingsException()

        return configs
    }
}