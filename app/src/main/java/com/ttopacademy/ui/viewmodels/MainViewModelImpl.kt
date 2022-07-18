package com.ttopacademy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.managers.interfaces.SubjectManager
import com.ttopacademy.managers.interfaces.TopicManager
import com.ttopacademy.managers.interfaces.VideoManager
import com.ttopacademy.repositories.interfaces.CategoryRepository
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository
import com.ttopacademy.ui.states.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/** MainViewModel implementation class. */
@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val subjectManager: SubjectManager,
    private val topicManager: TopicManager,
    private val videoManager: VideoManager,
    private val practiceQuestionRepository: PracticeQuestionRepository
) : ViewModel(), MainViewModel {

    private var selectedCategory: Category
    private var selectedSubject: Subject
    private var selectedTopic: Topic
    private var selectedVideo: Video

    override fun getCategoryUiState(): MutableLiveData<CategoryUiState> {
        val categoryUiState: MutableLiveData<CategoryUiState> by lazy {
            MutableLiveData<CategoryUiState>()
        }
        categoryUiState.value = CategoryUiState(true, mutableListOf())
        viewModelScope.launch(Dispatchers.IO) {
            val categories: MutableList<Category> = categoryRepository.getAllCategories()
            categoryUiState.postValue(CategoryUiState(false, categories))
        }
        return categoryUiState
    }

    override fun getSubjectUiState(): MutableLiveData<SubjectUiState> {
        val subjectUiState: MutableLiveData<SubjectUiState> by lazy {
            MutableLiveData<SubjectUiState>()
        }
        subjectUiState.value = SubjectUiState(true, mutableListOf(), selectedCategory)
        viewModelScope.launch(Dispatchers.IO) {
            val subjects: MutableList<Subject> = subjectManager.getSubjects(selectedCategory.categoryID)
            subjectUiState.postValue(SubjectUiState(false, subjects, selectedCategory))
        }
        return subjectUiState
    }

    override fun getTopicUiState(): MutableLiveData<TopicUiState> {
        val topicUiState: MutableLiveData<TopicUiState> by lazy {
            MutableLiveData<TopicUiState>()
        }
        topicUiState.value = TopicUiState(false, mutableListOf(), selectedCategory, selectedSubject)
        viewModelScope.launch(Dispatchers.IO) {
            val topics: MutableList<Topic>
                = topicManager.getTopics(selectedCategory.categoryID, selectedSubject.subjectID)
            topicUiState.postValue(TopicUiState(false, topics, selectedCategory, selectedSubject))
        }
        return topicUiState
    }

    override fun getVideoUiState(): MutableLiveData<VideoUiState> {
        val videoUiState: MutableLiveData<VideoUiState> by lazy {
            MutableLiveData<VideoUiState>()
        }
        videoUiState.value = VideoUiState(
            false, mutableListOf(), selectedCategory, selectedSubject, selectedTopic
        )
        viewModelScope.launch(Dispatchers.IO) {
            val videos: MutableList<Video> = videoManager.getVideos(
                selectedCategory.categoryID, selectedSubject.subjectID, selectedTopic.topicID
            )
            videoUiState.postValue(
                VideoUiState(false, videos, selectedCategory, selectedSubject, selectedTopic)
            )
        }
        return videoUiState
    }

    override fun getVideoItemUiState(): MutableLiveData<VideoItemUiState> {
        val videoItemUiState: MutableLiveData<VideoItemUiState> by lazy {
            MutableLiveData<VideoItemUiState>()
        }
        videoItemUiState.postValue(
            VideoItemUiState(selectedCategory, selectedSubject, selectedTopic, selectedVideo)
        )
        return videoItemUiState
    }

    override fun getPracticeQuestionUiState(): MutableLiveData<PracticeQuestionUiState> {
        val practiceQuestionUiState: MutableLiveData<PracticeQuestionUiState> by lazy {
            MutableLiveData<PracticeQuestionUiState>()
        }
        practiceQuestionUiState.value = PracticeQuestionUiState(
            false, mutableListOf(), selectedCategory,
            selectedSubject, selectedTopic, selectedVideo
        )
        viewModelScope.launch(Dispatchers.IO) {
            val practiceQuestions: MutableList<PracticeQuestion>
                = practiceQuestionRepository.getPracticeQuestions(selectedSubject.name, selectedVideo.videoID)
            practiceQuestionUiState.postValue(PracticeQuestionUiState(
                false, practiceQuestions, selectedCategory, selectedSubject, selectedTopic, selectedVideo
            ))

        }
        return practiceQuestionUiState
    }

    override fun setSelectedCategory(category: Category) {
        selectedCategory = category
    }

    override fun setSelectedSubject(subject: Subject) {
        selectedSubject = subject
    }

    override fun setSelectedTopic(topic: Topic) {
        selectedTopic = topic
    }

    override fun setSelectedVideo(video: Video) {
        selectedVideo = video
    }

    init {
        selectedCategory = Category(0, 0, "", Date())
        selectedSubject = Subject(0, 1, "", Date())
        selectedTopic = Topic(0, 0, "", Date())
        selectedVideo = Video(
            0,  0, "", "", "","", "", Date()
        )
    }
}