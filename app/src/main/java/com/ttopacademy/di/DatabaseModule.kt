package com.ttopacademy.di

import android.content.Context
import androidx.room.Room
import com.ttopacademy.localdatasources.roomdb.AppDatabase
import com.ttopacademy.localdatasources.roomdb.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Configures interfaces needed for configuring room database.  */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /** Configures AppDatabase.  */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "TtopAcademy-Database")
            .build()
    }

    /** Configures categoryDao.  */
    @Provides
    @Singleton
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }

    /** Configures categorySubjectDao.  */
    @Provides
    @Singleton
    fun provideCategorySubjectDao(appDatabase: AppDatabase): CategorySubjectDao {
        return appDatabase.categorySubjectDao()
    }

    /** Configures categorySubjectTopicDao.  */
    @Provides
    @Singleton
    fun provideCategorySubjectTopicDao(appDatabase: AppDatabase): CategorySubjectTopicDao {
        return appDatabase.categorySubjectTopicDao()
    }

    /** Configures categorySubjectTopicVideoDao.  */
    @Provides
    @Singleton
    fun provideCategorySubjectTopicVideoDao(appDatabase: AppDatabase): CategorySubjectTopicVideoDao {
        return appDatabase.categorySubjectTopicVideoDao()
    }

    /** Configures subjectDao.  */
    @Provides
    @Singleton
    fun provideSubjectDao(appDatabase: AppDatabase): SubjectDao {
        return appDatabase.subjectDao()
    }

    /** Configures topicDao.  */
    @Provides
    @Singleton
    fun provideTopicDao(appDatabase: AppDatabase): TopicDao {
        return appDatabase.topicDao()
    }

    /** Configures videoDao.  */
    @Provides
    @Singleton
    fun provideVideoDao(appDatabase: AppDatabase): VideoDao {
        return appDatabase.videoDao()
    }

    /** Configures chemistryPracticeQuestionDao.  */
    @Provides
    @Singleton
    fun provideChemistryPracticeQuestionDao(appDatabase: AppDatabase): ChemistryPracticeQuestionDao {
        return appDatabase.chemistryPracticeQuestionDao()
    }

    /** Configures physicsPracticeQuestionDao.  */
    @Provides
    @Singleton
    fun providePhysicsPracticeQuestionDao(appDatabase: AppDatabase): PhysicsPracticeQuestionDao {
        return appDatabase.physicsPracticeQuestionDao()
    }

    /** Configures mathPracticeQuestionDao.  */
    @Provides
    @Singleton
    fun provideMathPracticeQuestionDao(appDatabase: AppDatabase): MathPracticeQuestionDao {
        return appDatabase.mathPracticeQuestionDao()
    }

    /** Configures otherPracticeQuestionDao.  */
    @Provides
    @Singleton
    fun provideOtherPracticeQuestionDao(appDatabase: AppDatabase): OtherPracticeQuestionDao {
        return appDatabase.otherPracticeQuestionDao()
    }
}
