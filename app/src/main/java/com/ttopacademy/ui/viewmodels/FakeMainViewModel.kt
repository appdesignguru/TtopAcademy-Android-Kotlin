package com.ttopacademy.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.entities.practicequestions.Option
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.ui.states.*
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

/** Fake MainViewModel implementation class. */
@HiltViewModel
class FakeMainViewModel @Inject constructor() : ViewModel(), MainViewModel {

    private lateinit var selectedCategory: Category
    private lateinit var selectedSubject: Subject
    private lateinit var selectedTopic: Topic
    private lateinit var selectedVideo: Video

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
        val subjectUiState: MutableLiveData<SubjectUiState> by lazy {
            MutableLiveData<SubjectUiState>()
        }
        val testSubjects: MutableList<Subject> = mutableListOf()
        testSubjects.add(Subject(1, 1, "Biology", Date()))
        testSubjects.add(Subject(2, 2, "Physics", Date()))

        subjectUiState.value = SubjectUiState(false, testSubjects, selectedCategory)

        return subjectUiState
    }

    override fun getTopicUiState(): MutableLiveData<TopicUiState> {
        val topicUiState: MutableLiveData<TopicUiState> by lazy {
            MutableLiveData<TopicUiState>()
        }
        val testTopics: MutableList<Topic> = mutableListOf()
        testTopics.add(Topic(1, 1, "Topic 1", Date()))
        testTopics.add(Topic(2, 1, "Topic 2", Date()))

        topicUiState.value = TopicUiState(false, testTopics, selectedCategory, selectedSubject)

        return topicUiState
    }

    override fun getVideoUiState(): MutableLiveData<VideoUiState> {
        val videoUiState: MutableLiveData<VideoUiState> by lazy {
            MutableLiveData<VideoUiState>()
        }
        val testVideos: MutableList<Video> = mutableListOf()
        testVideos.add(
                Video(1,  1, "Video Title 1", "youtubeID 1", "10",
                "solution youtubeID 1", "10", Date())
        )
        testVideos.add(
                Video(2,  1, "Video Title 2", "youtubeID 2", "10",
            "solution youtubeID 2", "10", Date())
        )
        videoUiState.value = VideoUiState(
            false, testVideos, selectedCategory, selectedSubject, selectedTopic
        )

       return videoUiState
    }

    override fun getVideoItemUiState(): MutableLiveData<VideoItemUiState> {
        val videoItemUiState: MutableLiveData<VideoItemUiState> by lazy {
            MutableLiveData<VideoItemUiState>()
        }
        videoItemUiState.value = VideoItemUiState(
            selectedCategory, selectedSubject, selectedTopic, selectedVideo
        )

        return videoItemUiState
    }

    override fun getPracticeQuestionUiState(): MutableLiveData<PracticeQuestionUiState> {
        val practiceQuestionUiState: MutableLiveData<PracticeQuestionUiState> by lazy {
            MutableLiveData<PracticeQuestionUiState>()
        }
        val testPracticeQuestions: MutableList<PracticeQuestion> = mutableListOf()
        testPracticeQuestions.add(
            PracticeQuestion(1, 1, 1, "Question 1",
            "Option A", "Option B", "Option C", "Option D",
            Option.D, Date())
        )
        testPracticeQuestions.add(
             PracticeQuestion(2, 2, 2, "Question 2",
            "Option A", "Option B", "Option C", "Option D",
            Option.D,  Date())
        )

        practiceQuestionUiState.value = PracticeQuestionUiState(
            false, testPracticeQuestions, selectedCategory,
            selectedSubject, selectedTopic, selectedVideo
        )

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
        selectedCategory = Category(1, 1, "JAMB", Date())
        selectedSubject = Subject(1, 1, "Biology", Date())
        selectedTopic = Topic(1, 1, "Topic 1", Date())
        selectedVideo = Video(1,  1, "Video Title 1", "youtubeID 1", "10",
            "solution youtubeID 1", "10", Date())
    }
}