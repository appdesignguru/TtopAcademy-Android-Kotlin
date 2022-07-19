package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.CategorySubject
import java.util.*

/** Room database data access object interface for CategorySubjects. */
@Dao
interface CategorySubjectDao {

    /** Returns all CategorySubjects.  */
    @Query("SELECT * FROM categorySubject WHERE categoryID == :categoryID")
    fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject>

    /** Returns categorySubjectID for given parameters.  */
    @Query(
        "SELECT categorySubjectID FROM categorysubject " +
                "WHERE categoryID == :categoryID AND subjectID == :subjectID"
    )
    fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int

    /** Saves the categorySubjects. If any categorySubject already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategorySubjects(categorySubjects: MutableList<CategorySubject>)

    /** Deletes all categorySubjects in the database.  */
    @Query("DELETE FROM categorySubject")
    fun deleteAllCategorySubjects()

    /** Returns date of last update.  */
    @Query("SELECT dateSavedToLocalDatabase FROM categorySubject LIMIT 1")
    fun getDateOfLastUpdate(): Date?
}