package com.demo.kmmlibrary

import android.app.Application
import com.datadog.android.Datadog
import com.datadog.android.DatadogSite
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.Rum
import com.datadog.android.rum.RumConfiguration

open class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val clientToken = "pub6ecd29ca5d2ca0840273b13b60870e65"
        val environmentName = "staging-1"
        val appVariantName = "<SHELL_APP_1>"

        val configuration = Configuration.Builder(
            clientToken = clientToken,
            env = environmentName,
            variant = appVariantName
        )
            .useSite(DatadogSite.US5)
            .build()
        Datadog.initialize(applicationContext, configuration, TrackingConsent.GRANTED)

        val applicationId = "fa04ba5f-9571-4a82-ba58-26a63725e9ed"
        val rumConfiguration = RumConfiguration.Builder(applicationId)
            .trackUserInteractions()
            .trackLongTasks(50000).trackFrustrations(true).trackBackgroundEvents(true)
//            .useViewTrackingStrategy(strategy)
            .build()
        Rum.enable(rumConfiguration)
    }
}