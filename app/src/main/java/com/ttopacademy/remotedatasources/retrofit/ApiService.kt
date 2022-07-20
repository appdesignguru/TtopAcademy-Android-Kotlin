package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/** Retrofit interface for making api calls.  */
interface ApiService {

    /** Returns all categories.  */
    @get:GET("categories")
    val allCategories: Call<MutableList<CategoryResponse>>

    /** Returns all CategorySubjects.  */
    @get:GET("CategorySubjects")
    val allCategorySubjects: Call<MutableList<CategorySubjectResponse>>

    /** Returns all CategorySubjectTopics.  */
    @get:GET("CategorySubjectTopics")
    val allCategorySubjectTopics: Call<MutableList<CategorySubjectTopicResponse>>

    /** Returns all CategorySubjectTopicVideos.  */
    @GET("CategorySubjectTopicVideo/{id}")
    fun getCategorySubjectTopicVideos(
        @Path("id") categorySubjectTopicID: Int
    ): Call<MutableList<CategorySubjectTopicVideoResponse>>

    /** Returns all subjects.  */
    @get:GET("subjects")
    val allSubjects: Call<MutableList<SubjectResponse>>

    /** Returns all topics.  */
    @get:GET("topics")
    val allTopics: Call<MutableList<TopicResponse>>

    /** Returns all CategorySubjectTopicVideos.  */
    @GET("Video/{id}")
    fun getVideos(@Path("id") categorySubjectTopicID: Int): Call<MutableList<VideoResponse>>

    /** Returns all CategorySubjectTopicVideos.  */
    @GET("PracticeQuestions/{id}")
    fun getPracticeQuestions(
        @Path("id") hyphenConcatenatedSubjectNameAndVideoID: String
    ): Call<MutableList<PracticeQuestionResponse>>
}
