package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import java.util.*

/** Room database data access object interface for ChemistryPracticeQuestions. */
@Dao
interface MathPracticeQuestionDao {

    /** Returns practice questions for given parameter.  */
    @Query("SELECT * FROM mathpracticequestion WHERE videoID == :videoID ORDER BY questionNumber")
    fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion>

    /** Saves the practiceQuestions.
     * If any practiceQuestions already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPracticeQuestions(mathPracticeQuestions: MutableList<MathPracticeQuestion>)

    /** Returns date of last update.  */
    @Query(
        "SELECT dateSavedToLocalDatabase FROM mathpracticequestion" +
                " WHERE videoID == :videoID LIMIT 1"
    )
    fun getDateOfLastUpdate(videoID: Int): Date?
}