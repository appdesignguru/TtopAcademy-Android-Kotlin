package com.ttopacademy.di

import com.ttopacademy.repositories.fakes.*
import com.ttopacademy.repositories.interfaces.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects manager interfaces. */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /** Injects CategoryRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: FakeCategoryRepository
    ): CategoryRepository

    /** Injects SubjectRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSubjectRepository(
        subjectRepositoryImpl: FakeSubjectRepository
    ): SubjectRepository

    /** Injects CategorySubjectRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectRepository(
        categorySubjectRepositoryImpl: FakeCategorySubjectRepository
    ): CategorySubjectRepository

    /** Injects CategorySubjectTopicRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicRepository(
        categorySubjectTopicRepositoryImpl: FakeCategorySubjectTopicRepository
    ): CategorySubjectTopicRepository

    /** Injects CategorySubjectTopicVideoRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicVideoRepository(
        categorySubjectTopicVideoRepositoryImpl: FakeCategorySubjectTopicVideoRepository
    ): CategorySubjectTopicVideoRepository?

    /** Injects TopicRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicRepository(
        topicRepositoryImpl: FakeTopicRepository
    ): TopicRepository

    /** Injects VideoRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoRepository(
        videoRepositoryImpl: FakeVideoRepostory
    ): VideoRepository?

    /** Injects PracticeQuestionRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionRepository(
        practiceQuestionRepositoryImpl: FakePracticeQuestionRepository
    ): PracticeQuestionRepository
}