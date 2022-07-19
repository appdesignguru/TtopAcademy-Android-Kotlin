package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import java.util.*

/** Room database data access object interface for CategorySubjectTopicVideos. */
@Dao
interface CategorySubjectTopicVideoDao {

    /** Returns all CategorySubjectTopicVideos.  */
    @Query(
        "SELECT * FROM CategorySubjectTopicVideo " +
                "WHERE categorySubjectTopicID == :categorySubjectTopicID"
    )
    fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo>

    /** Returns CategorySubjectTopicVideoID for given parameters.  */
    @Query(
        "SELECT categorySubjectTopicVideoID FROM CategorySubjectTopicVideo " +
                "WHERE categorySubjectTopicID == :categorySubjectTopicID AND videoID == :videoID"
    )
    fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int

    /** Saves the categorySubjectTopicVideos.
     * If any categorySubjectTopicVideo already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategorySubjectTopicVideos(categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo>)

    /** Returns date of last update.  */
    @Query(
        "SELECT dateSavedToLocalDatabase FROM CategorySubjectTopicVideo" +
                " WHERE categorySubjectTopicID == :categorySubjectTopicID LIMIT 1"
    )
    fun getDateOfLastUpdate(categorySubjectTopicID: Int): Date?
}