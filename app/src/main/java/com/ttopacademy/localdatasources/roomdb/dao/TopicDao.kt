package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.Topic
import java.util.*

/** Room database data access object interface for Topics. */
@Dao
interface TopicDao {

    /** Returns topics with given parameters.  */
    @Query("SELECT * FROM topic WHERE topicID IN (:topicIDs) ORDER BY number")
    fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic>

    /** Saves the topics.
     * If any topic already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopics(topics: MutableList<Topic>)

    /** Deletes all topics in the database.  */
    @Query("DELETE FROM topic")
    fun deleteAllTopics()

    /** Returns date of last update.  */
    @Query("SELECT dateSavedToLocalDatabase FROM topic LIMIT 1")
    fun getDateOfLastUpdate(): Date?
}