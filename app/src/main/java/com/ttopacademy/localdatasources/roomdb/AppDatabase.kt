package com.ttopacademy.localdatasources.roomdb

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ttopacademy.localdatasources.entities.*
import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion
import com.ttopacademy.localdatasources.roomdb.dao.*

/** Declares Room AppDatabase.  */
@Database(
    entities = [Category::class, CategorySubject::class, CategorySubjectTopic::class,
        CategorySubjectTopicVideo::class, Subject::class, Topic::class, Video::class,
        ChemistryPracticeQuestion::class, MathPracticeQuestion::class, PhysicsPracticeQuestion::class,
        OtherPracticeQuestion::class],
    version = 3,
    autoMigrations = [AutoMigration(from = 2, to = 3)]
)
@TypeConverters(
    DateTimeConverters::class
)
abstract class AppDatabase : RoomDatabase() {
    /** Declares data access objects for categories.  */
    abstract fun categoryDao(): CategoryDao

    /** Declares data access objects for categorySubjects.  */
    abstract fun categorySubjectDao(): CategorySubjectDao

    /** Declares data access objects for categorySubjectTopics.  */
    abstract fun categorySubjectTopicDao(): CategorySubjectTopicDao

    /** Declares data access objects for categorySubjectTopicVideos.  */
    abstract fun categorySubjectTopicVideoDao(): CategorySubjectTopicVideoDao

    /** Declares data access objects for Subjects.  */
    abstract fun subjectDao(): SubjectDao

    /** Declares data access objects for Topics.  */
    abstract fun topicDao(): TopicDao

    /** Declares data access objects for Videos.  */
    abstract fun videoDao(): VideoDao

    /** Declares data access objects for ChemistryPracticeQuestions.  */
    abstract fun chemistryPracticeQuestionDao(): ChemistryPracticeQuestionDao

    /** Declares data access objects for PhysicsPracticeQuestions.  */
    abstract fun physicsPracticeQuestionDao(): PhysicsPracticeQuestionDao

    /** Declares data access objects for MathPracticeQuestions.  */
    abstract fun mathPracticeQuestionDao(): MathPracticeQuestionDao

    /** Declares data access objects for otherPracticeQuestions.  */
    abstract fun otherPracticeQuestionDao(): OtherPracticeQuestionDao
}
