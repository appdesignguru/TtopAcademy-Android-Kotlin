package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectTopicDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class CategorySubjectTopicLocalDataSourceTest {

    private lateinit var categorySubjectTopicLocalDataSource: CategorySubjectTopicLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectTopicLocalDataSource = CategorySubjectTopicLocalDataSourceImpl(
            FakeCategorySubjectTopicDao(), FakeDateTimeUtility()
        )

        // PreSave
        val categorySubjectTopics: MutableList<CategorySubjectTopic> = mutableListOf()
        categorySubjectTopics.add(
            CategorySubjectTopic(1, 1, 1, Date())
        )
        categorySubjectTopics.add(
            CategorySubjectTopic(2, 1, 2, Date())
        )
        categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics)
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val result = categorySubjectTopicLocalDataSource.isOutdated()
        Assert.assertTrue(result)
    }

    @Test
    fun getCategorySubjectTopics_ShouldReturnAllForGivenParameter() {
        val categorySubjectID = 1
        val result: MutableList<CategorySubjectTopic> =
            categorySubjectTopicLocalDataSource.getCategorySubjectTopics(categorySubjectID)
        Assert.assertEquals(2, result.size.toLong())
    }

    @Test
    fun getCategorySubjectTopicID_ShouldReturnValue() {
        val categorySubjectID = 1
        val topicID = 1
        val result = categorySubjectTopicLocalDataSource.getCategorySubjectTopicID(categorySubjectID, topicID)
        Assert.assertEquals(1, result.toLong())
    }

    @Test
    fun saveCategorySubjectTopics_ShouldReturnTrueAfterSaving() {
        val categorySubjectTopics: MutableList<CategorySubjectTopic> = ArrayList()
        categorySubjectTopics.add(
            CategorySubjectTopic(3, 2, 1, Date())
        )
        val result =
            categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics)
        Assert.assertTrue(result)
    }

    @Test
    fun deleteAllCategorySubjectTopics_ShouldReturnTrueAfterDeleting() {
        val result = categorySubjectTopicLocalDataSource.deleteAllCategorySubjectTopics()
        Assert.assertTrue(result)
    }
}