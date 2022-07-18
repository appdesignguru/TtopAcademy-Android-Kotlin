package com.ttopacademy.di

import com.ttopacademy.remotedatasources.fakes.*
import com.ttopacademy.remotedatasources.interfaces.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects manager interfaces. */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    /** Injects CategoryRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategoryRemoteDataSource(
        categoryRemoteDataSourceImpl: FakeCategoryRemoteDataSource
    ): CategoryRemoteDataSource

    /** Injects CategorySubjectRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectRemoteDataSource(
        categorySubjectRemoteDataSourceImpl: FakeCategorySubjectRemoteDataSource
    ): CategorySubjectRemoteDataSource

    /** Injects CategorySubjectTopicRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicRemoteDataSource(
        categorySubjectTopicRemoteDataSourceImpl: FakeCategorySubjectTopicRemoteDataSource
    ): CategorySubjectTopicRemoteDataSource

    /** Injects CategorySubjectTopicVideoRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicVideoRemoteDataSource(
        categorySubjectTopicVideoRemoteDataSourceImpl: FakeCategorySubjectTopicVideoRemoteDataSource
    ): CategorySubjectTopicVideoRemoteDataSource

    /** Injects PracticeQuestionRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionRemoteDataSource(
        practiceQuestionRemoteDataSourceImpl: FakePracticeQuestionRemoteDataSource
    ): PracticeQuestionRemoteDataSource

    /** Injects SubjectRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSubjectRemoteDataSource(
        subjectLocalDataRemoteSourceImpl: FakeSubjectRemoteDataSource
    ): SubjectRemoteDataSource

    /** Injects TopicRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicRemoteDataSource(
        topicRemoteDataSourceImpl: FakeTopicRemoteDataSource
    ): TopicRemoteDataSource

    /** Injects VideoRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoRemoteDataSource(
        videoRemoteDataSourceImpl: FakeVideoRemoteDataSource
    ): VideoRemoteDataSource
}