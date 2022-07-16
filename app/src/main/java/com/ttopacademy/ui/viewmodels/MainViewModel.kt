package com.ttopacademy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.ui.states.*

/** State holder interface for the UI screens. */
interface MainViewModel {

    /** Returns CategoryUiState. */
    fun getCategoryUiState(): MutableLiveData<CategoryUiState>

    /** Returns SubjectUiState.  */
    fun getSubjectUiState(): MutableLiveData<SubjectUiState>

    /** Returns TopicUiState.  */
    fun getTopicUiState(): MutableLiveData<TopicUiState>

    /** Returns VideoUiState.  */
    fun getVideoUiState(): MutableLiveData<VideoUiState>

    /** Returns VideoItemUiState.  */
    fun getVideoItemUiState(): MutableLiveData<VideoItemUiState>

    /** Returns PracticeQuestionUiState.  */
    fun getPracticeQuestionUiState(): MutableLiveData<PracticeQuestionUiState>

    /** Sets selected category.  */
    fun setSelectedCategory(category: Category)

    /** Sets selected subject.  */
    fun setSelectedSubject(subject: Subject)

    /** Sets selected topic.  */
    fun setSelectedTopic(topic: Topic)

    /** Sets selected video.  */
    fun setSelectedVideo(video: Video)
}