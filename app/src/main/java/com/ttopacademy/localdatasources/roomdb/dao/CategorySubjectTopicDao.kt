package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import java.util.*

/** Room database data access object interface for CategorySubjectTopics. */
@Dao
interface CategorySubjectTopicDao {

    /** Returns all CategorySubjectTopics.  */
    @Query("SELECT * FROM CategorySubjectTopic WHERE categorySubjectID == :categorySubjectID")
    fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic>

    /** Returns categorySubjectTopicID for given parameters.  */
    @Query(
        "SELECT categorySubjectTopicID FROM categorysubjectTopic " +
                "WHERE categorySubjectID == :categorySubjectID AND topicID == :topicID"
    )
    fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int

    /** Saves the categorySubjectTopics.
     * If any categorySubjectTopic already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategorySubjectTopics(categorySubjectTopics: MutableList<CategorySubjectTopic>)

    /** Deletes all categorySubjectTopics in the database.  */
    @Query("DELETE FROM categorySubjectTopic")
    fun deleteAllCategorySubjectTopics()

    /** Returns date of last update.  */
    @Query("SELECT dateSavedToLocalDatabase FROM categorySubjectTopic LIMIT 1")
    fun getDateOfLastUpdate(): Date?
}