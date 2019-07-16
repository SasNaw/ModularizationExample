package com.sanoma.feature_impl_test.dagger

import com.sanoma.core.feature.Feature
import com.sanoma.feature_impl_test.FeatureImpl
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FeatureModule::class],
    dependencies = [Feature.Dependencies::class]
)
interface FeatureComponent {
    fun feature(): Feature
}

@Module
class FeatureModule {
    @Provides
    internal fun bindStorageFeatureImpl(featureImpl: FeatureImpl): Feature = featureImpl
}