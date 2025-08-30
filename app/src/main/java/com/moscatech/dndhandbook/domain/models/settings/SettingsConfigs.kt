package com.moscatech.dndhandbook.domain.models.settings

import com.moscatech.dndhandbook.BuildConfig

data class SettingsConfigs(
    val apiDoc: String = BuildConfig.API_DOC,
    val apiRepo: String = BuildConfig.API_REPO,
    val databaseRepo: String = BuildConfig.DATABASE_REPO,
    val license: String = "",
    val privacyPolicies: String = BuildConfig.PRIVACY_POLICIES,
) {
    companion object {
        fun fromJson(json: Any?): SettingsConfigs {
            if (json !is Map<*, *>) return SettingsConfigs()

            return SettingsConfigs(
                apiDoc = json["api_doc"] as? String ?: BuildConfig.API_DOC,
                apiRepo = json["api_repo"] as? String ?: BuildConfig.API_REPO,
                databaseRepo = json["database_repo"] as? String ?: BuildConfig.DATABASE_REPO,
                license = json["license"] as? String ?: "",
                privacyPolicies = json["privacy_policies"] as? String
                    ?: BuildConfig.PRIVACY_POLICIES,
            )
        }
    }

    fun hasLicense(): Boolean = license.isNotBlank()
}