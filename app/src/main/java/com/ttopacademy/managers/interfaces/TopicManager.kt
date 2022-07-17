package com.ttopacademy.managers.interfaces

import com.ttopacademy.localdatasources.entities.Topic

/** Interface for managing topics. */
interface TopicManager {

    /** Returns the topics for given parameters.  */
    fun getTopics(categoryID: Int, subjectID: Int): MutableList<Topic>

}