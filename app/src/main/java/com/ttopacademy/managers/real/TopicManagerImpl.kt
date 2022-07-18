package com.ttopacademy.managers.real

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.managers.interfaces.TopicManager
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository
import com.ttopacademy.repositories.interfaces.TopicRepository
import javax.inject.Inject

/** TopicManager implementation class. */
class TopicManagerImpl @Inject constructor(
    private val categorySubjectRepository: CategorySubjectRepository,
    private val categorySubjectTopicRepository: CategorySubjectTopicRepository,
    private val topicRepository: TopicRepository
) : TopicManager {

    override fun getTopics(categoryID: Int, subjectID: Int): MutableList<Topic> {
        val categorySubjectID: Int =
            categorySubjectRepository.getCategorySubjectID(categoryID, subjectID)
        val categorySubjectTopics: MutableList<CategorySubjectTopic> =
            categorySubjectTopicRepository.getCategorySubjectTopics(categorySubjectID)
        val topicIDs: MutableList<Int> = mutableListOf()
        for ((_, _, topicID) in categorySubjectTopics) {
            topicIDs.add(topicID)
        }
        return topicRepository.getTopics(topicIDs)
    }

}