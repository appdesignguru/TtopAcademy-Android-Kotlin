package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import java.util.*

/** Room database data access object interface for PhysicsPracticeQuestions. */
@Dao
interface PhysicsPracticeQuestionDao {

    /** Returns practice questions for given parameter.  */
    @Query("SELECT * FROM physicsPracticeQuestion WHERE videoID == :videoID ORDER BY questionNumber")
    fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion>

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPracticeQuestions(physicsPracticeQuestions: MutableList<PhysicsPracticeQuestion>)

    /** Returns date of last update.  */
    @Query(
        "SELECT dateSavedToLocalDatabase FROM physicsPracticeQuestion" +
                " WHERE videoID == :videoID LIMIT 1"
    )
    fun getDateOfLastUpdate(videoID: Int): Date?
}