package com.ttopacademy.di

import com.ttopacademy.repositories.fakes.*
import com.ttopacademy.repositories.interfaces.*
import com.ttopacademy.repositories.real.*
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
        categoryRepositoryImpl: CategoryRepositoryImpl
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
        categorySubjectRepositoryImpl: CategorySubjectRepositoryImpl
    ): CategorySubjectRepository

    /** Injects CategorySubjectTopicRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicRepository(
        categorySubjectTopicRepositoryImpl: CategorySubjectTopicRepositoryImpl
    ): CategorySubjectTopicRepository

    /** Injects CategorySubjectTopicVideoRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategorySubjectTopicVideoRepository(
        categorySubjectTopicVideoRepositoryImpl: CategorySubjectTopicVideoRepositoryImpl
    ): CategorySubjectTopicVideoRepository

    /** Injects TopicRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicRepository(
        topicRepositoryImpl: TopicRepositoryImpl
    ): TopicRepository

    /** Injects VideoRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoRepository(
        videoRepositoryImpl: VideoRepositoryImpl
    ): VideoRepository

    /** Injects PracticeQuestionRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindPracticeQuestionRepository(
        practiceQuestionRepositoryImpl: PracticeQuestionRepositoryImpl
    ): PracticeQuestionRepository
}