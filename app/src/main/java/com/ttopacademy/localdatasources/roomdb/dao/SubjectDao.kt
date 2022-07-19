package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.Subject
import java.util.*

/** Room database data access object interface for PhysicsPracticeQuestions. */
@Dao
interface SubjectDao {

    /** Returns subjects with given parameters.  */
    @Query("SELECT * FROM subject WHERE subjectID IN (:subjectIDs) ORDER BY number")
    fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject>

    /** Saves the subjects.
     * If any subject already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubjects(subjects: MutableList<Subject>)

    /** Deletes all subjects in the database.  */
    @Query("DELETE FROM subject")
    fun deleteAllSubjects()

    /** Returns date of last update.  */
    @Query("SELECT dateSavedToLocalDatabase FROM subject LIMIT 1")
    fun getDateOfLastUpdate(): Date?
}