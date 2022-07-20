package com.ttopacademy.di

import com.ttopacademy.utilities.DateTimeUtility
import com.ttopacademy.utilities.FakeDateTimeUtility
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects utility interfaces.  */
@Module
@InstallIn(SingletonComponent::class)
abstract class UtilityModule {

    /** Injects DateTimeUtility implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindDateTimeUtility(
        dateTimeUtilityImpl: FakeDateTimeUtility
    ): DateTimeUtility
}