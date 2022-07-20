package com.ttopacademy.di

import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects factory interfaces.  */
@Module
@InstallIn(SingletonComponent::class)
abstract class FactoryModule {

    /** Injects PracticeQuestionLocalDataSourceFactory implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionLocalDataSourceFactory(
        practiceQuestionLocalDataSourceFactoryImpl: PracticeQuestionLocalDataSourceFactoryImpl
    ): PracticeQuestionLocalDataSourceFactory

}