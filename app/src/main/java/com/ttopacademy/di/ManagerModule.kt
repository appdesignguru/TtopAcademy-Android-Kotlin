package com.ttopacademy.di

import com.ttopacademy.managers.interfaces.SubjectManager
import com.ttopacademy.managers.interfaces.TopicManager
import com.ttopacademy.managers.interfaces.VideoManager
import com.ttopacademy.managers.real.SubjectManagerImpl
import com.ttopacademy.managers.real.TopicManagerImpl
import com.ttopacademy.managers.real.VideoManagerImpl
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
        subjectManagerImpl: SubjectManagerImpl
    ): SubjectManager

    /** Injects TopicManager implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindTopicManager(
        topicManagerImpl: TopicManagerImpl
    ): TopicManager

    /** Injects VideoManager implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindVideoManager(
        videoManagerImpl: VideoManagerImpl
    ): VideoManager
}