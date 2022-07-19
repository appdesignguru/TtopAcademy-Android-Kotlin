package com.ttopacademy.localdatasources.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ttopacademy.localdatasources.entities.Video
import java.util.*

/** Room database data access object interface for Videos. */
@Dao
interface VideoDao {

    /** Returns videos with given parameters.  */
    @Query("SELECT * FROM video WHERE videoID IN (:videoIDs) ORDER BY number")
    fun getVideos(videoIDs: MutableList<Int>): MutableList<Video>

    /** Saves the videos.
     * If any video already exists in the database, it replaces it.  */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideos(videos: MutableList<Video>)

    /** Returns date of last update.  */
    @Query("SELECT dateSavedToLocalDatabase FROM video WHERE videoID IN (:videoIDs) LIMIT 1")
    fun getDateOfLastUpdate(videoIDs: MutableList<Int>): Date?
}