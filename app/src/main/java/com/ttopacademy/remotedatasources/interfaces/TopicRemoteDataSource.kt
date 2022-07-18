package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.TopicResponse

/** Topic remote data source interface. */
interface TopicRemoteDataSource {

    /** Returns topic responses.  */
    fun getAllTopics(): Result<MutableList<TopicResponse>>

}