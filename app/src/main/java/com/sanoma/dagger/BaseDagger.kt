package com.sanoma.dagger

import android.content.Context
import com.sanoma.core.Providers
import com.sanoma.core.feature.Feature
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import timber.log.Timber

@Component(modules = [BaseModule::class])
interface BaseComponent : Feature.Dependencies {

    fun feature(): Feature?

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): BaseComponent
    }

}

@Module
object BaseModule {
    private var feature: Feature? = null

    @Provides
    @JvmStatic
    fun featureProvider(baseComponent: BaseComponent): Feature? {
        if (feature != null) {
            return feature as Feature
        }
        return try {
            Providers.FEATURE_PROVIDER.get(baseComponent)
                .also { feature = it }
        } catch (e: ClassNotFoundException) {
            Timber.e(e)
            null
        }
    }
}
