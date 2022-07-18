package com.ttopacademy.managers.real

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.managers.interfaces.VideoManager
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository
import com.ttopacademy.repositories.interfaces.VideoRepository
import javax.inject.Inject

/**  VideoManager implementation class. */
class VideoManagerImpl @Inject constructor(
    private val categorySubjectRepository: CategorySubjectRepository,
    private val categorySubjectTopicRepository: CategorySubjectTopicRepository,
    private val categorySubjectTopicVideoRepository: CategorySubjectTopicVideoRepository,
    private val videoRepository: VideoRepository
) : VideoManager {

    override fun getVideos(categoryID: Int, subjectID: Int, topicID: Int): MutableList<Video> {
        val categorySubjectID: Int =
            categorySubjectRepository.getCategorySubjectID(categoryID, subjectID)
        val categorySubjectTopicID: Int =
            categorySubjectTopicRepository.getCategorySubjectTopicID(categorySubjectID, subjectID)

        val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> =
            categorySubjectTopicVideoRepository.getCategorySubjectTopicVideos(categorySubjectTopicID)

        val videoIDs: MutableList<Int> = mutableListOf()
        for ((_, _, videoID) in categorySubjectTopicVideos) {
            videoIDs.add(videoID)
        }
        return videoRepository.getVideos(categorySubjectTopicID, videoIDs)

    }
}