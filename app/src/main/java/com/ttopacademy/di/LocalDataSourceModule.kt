package com.ttopacademy.di

import com.ttopacademy.localdatasources.fakes.*
import com.ttopacademy.localdatasources.interfaces.*
import com.ttopacademy.localdatasources.roomdb.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects manager interfaces. */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    /** Injects CategoryLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategoryLocalDataSource(
        categoryLocalDataSourceImpl: CategoryLocalDataSourceImpl
    ): CategoryLocalDataSource

    /** Injects CategorySubjectLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectLocalDataSource(
        categorySubjectLocalDataSourceImpl: CategorySubjectLocalDataSourceImpl
    ): CategorySubjectLocalDataSource

    /** Injects CategorySubjectTopicLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicLocalDataSource(
        categorySubjectTopicLocalDataSourceImpl: CategorySubjectTopicLocalDataSourceImpl
    ): CategorySubjectTopicLocalDataSource

    /** Injects CategorySubjectTopicVideoLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicVideoLocalDataSource(
        categorySubjectTopicVideoLocalDataSourceImpl: CategorySubjectTopicVideoLocalDataSourceImpl
    ): CategorySubjectTopicVideoLocalDataSource

    /** Injects PracticeQuestionLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionLocalDataSource(
        practiceQuestionLocalDataSourceImpl: PracticeQuestionLocalDataSourceImpl
    ): PracticeQuestionLocalDataSource

    /** Injects SubjectLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSubjectLocalDataSource(
        subjectLocalDataLocalSourceImpl: SubjectLocalDataSourceImpl
    ): SubjectLocalDataSource

    /** Injects TopicLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicLocalDataSource(
        topicLocalDataSourceImpl: TopicLocalDataSourceImpl
    ): TopicLocalDataSource?

    /** Injects VideoLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoLocalDataSource(
        videoLocalDataSourceImpl: VideoLocalDataSourceImpl
    ): VideoLocalDataSource
}