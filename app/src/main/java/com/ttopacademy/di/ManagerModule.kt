package com.ttopacademy.di

import com.ttopacademy.managers.fakes.FakeSubjectManager
import com.ttopacademy.managers.fakes.FakeTopicManager
import com.ttopacademy.managers.fakes.FakeVideoManager
import com.ttopacademy.managers.interfaces.SubjectManager
import com.ttopacademy.managers.interfaces.TopicManager
import com.ttopacademy.managers.interfaces.VideoManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects manager interfaces. */
@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {

    /** Injects SubjectManager implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSubjectManager(
        subjectManagerImpl: FakeSubjectManager
    ): SubjectManager

    /** Injects TopicManager implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicManager(
        topicManagerImpl: FakeTopicManager
    ): TopicManager

    /** Injects VideoManager implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoManager(
        videoManagerImpl: FakeVideoManager
    ): VideoManager
}