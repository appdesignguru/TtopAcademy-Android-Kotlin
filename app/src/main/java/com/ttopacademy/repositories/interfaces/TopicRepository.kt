package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.Topic

/** Repository interface for topics. */
interface TopicRepository {

    /** Returns topics with given parameters.  */
    fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic>
}