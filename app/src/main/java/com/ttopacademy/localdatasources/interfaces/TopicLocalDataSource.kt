package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.Topic

/** Topic local data source interface. */
interface TopicLocalDataSource {

    /** Checks whether topic local data source is up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns topics with given parameters.  */
    fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic>

    /** Returns true after saving successfully.  */
    fun saveTopics(topics: MutableList<Topic>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllTopics(): Boolean
}