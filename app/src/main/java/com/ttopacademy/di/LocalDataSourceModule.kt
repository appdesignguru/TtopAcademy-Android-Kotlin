package com.ttopacademy.di

import com.ttopacademy.localdatasources.fakes.*
import com.ttopacademy.localdatasources.interfaces.*
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
        categoryLocalDataSourceImpl: FakeCategoryLocalDataSource
    ): CategoryLocalDataSource

    /** Injects CategorySubjectLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectLocalDataSource(
        categorySubjectLocalDataSourceImpl: FakeCategorySubjectLocalDataSource
    ): CategorySubjectLocalDataSource

    /** Injects CategorySubjectTopicLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicLocalDataSource(
        categorySubjectTopicLocalDataSourceImpl: FakeCategorySubjectTopicLocalDataSource
    ): CategorySubjectTopicLocalDataSource

    /** Injects CategorySubjectTopicVideoLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicVideoLocalDataSource(
        categorySubjectTopicVideoLocalDataSourceImpl: FakeCategorySubjectTopicVideoLocalDataSource
    ): CategorySubjectTopicVideoLocalDataSource

    /** Injects PracticeQuestionLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionLocalDataSource(
        practiceQuestionLocalDataSourceImpl: FakePracticeQuestionLocalDataSource
    ): PracticeQuestionLocalDataSource

    /** Injects SubjectLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSubjectLocalDataSource(
        subjectLocalDataLocalSourceImpl: FakeSubjectLocalDataSource
    ): SubjectLocalDataSource

    /** Injects TopicLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicLocalDataSource(
        topicLocalDataSourceImpl: FakeTopicLocalDataSource
    ): TopicLocalDataSource?

    /** Injects VideoLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoLocalDataSource(
        videoLocalDataSourceImpl: FakeVideoLocalDataSource
    ): VideoLocalDataSource
}