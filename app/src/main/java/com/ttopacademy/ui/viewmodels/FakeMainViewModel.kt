package com.ttopacademy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.ui.states.*
import java.util.*
import javax.inject.Inject

class FakeMainViewModel @Inject constructor() : ViewModel(), MainViewModel {

    override fun getCategoryUiState(): MutableLiveData<CategoryUiState> {
        val categoryUiState: MutableLiveData<CategoryUiState> by lazy {
            MutableLiveData<CategoryUiState>()
        }

        val testCategories: MutableList<Category> = mutableListOf()
        testCategories.add(Category(1, 1, "JAMB", Date()))
        testCategories.add(Category(2, 2, "SS3", Date()))

        categoryUiState.value = CategoryUiState(false, testCategories)

        return categoryUiState
    }

    override fun getSubjectUiState(): MutableLiveData<SubjectUiState> {
        TODO("Not yet implemented")
    }

    override fun getTopicUiState(): MutableLiveData<TopicUiState> {
        TODO("Not yet implemented")
    }

    override fun getVideoUiState(): MutableLiveData<VideoUiState> {
        TODO("Not yet implemented")
    }

    override fun getVideoItemUiState(): MutableLiveData<VideoItemUiState> {
        TODO("Not yet implemented")
    }

    override fun getPracticeQuestionUiState(): MutableLiveData<PracticeQuestionUiState> {
        TODO("Not yet implemented")
    }

    override fun setSelectedCategory(category: Category) {
        TODO("Not yet implemented")
    }

    override fun setSelectedSubject(subject: Subject) {
        TODO("Not yet implemented")
    }

    override fun setSelectedTopic(topic: Topic) {
        TODO("Not yet implemented")
    }

    override fun setSelectedVideo(video: Video) {
        TODO("Not yet implemented")
    }
}