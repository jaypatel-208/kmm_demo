package com.demo.kmmlibrary

import android.content.Context
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.Rum
import com.datadog.android.rum.RumConfiguration

class AndroidAnalyticsManagerDD : DataDogAnalyticsManager {
    override fun logEvent(eventName: String) {
        DataDogLogger.logger.i(eventName)
    }
}

actual fun getAnalyticsManager(): DataDogAnalyticsManager = AndroidAnalyticsManagerDD()