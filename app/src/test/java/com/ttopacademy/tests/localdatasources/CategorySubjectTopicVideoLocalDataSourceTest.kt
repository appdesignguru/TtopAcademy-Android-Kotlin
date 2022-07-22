package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource
import com.ttopacademy.localdatasources.roomdb.CategorySubjectTopicVideoLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectTopicVideoDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class CategorySubjectTopicVideoLocalDataSourceTest {

    private lateinit var categorySubjectTopicVideoLocalDataSource: CategorySubjectTopicVideoLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectTopicVideoLocalDataSource = CategorySubjectTopicVideoLocalDataSourceImpl(
            FakeCategorySubjectTopicVideoDao(), FakeDateTimeUtility()
        )

        // PreSave
        val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = ArrayList()
        categorySubjectTopicVideos.add(
            CategorySubjectTopicVideo(1, 1, 1, Date())
        )
        categorySubjectTopicVideos.add(
            CategorySubjectTopicVideo(2, 1, 2, Date())
        )
        categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(
            categorySubjectTopicVideos
        )
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val categorySubjectTopicID = 1
        val result = categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(
            categorySubjectTopicID
        )
        Assert.assertTrue(result)
    }

    @Test
    fun getCategorySubjectTopicVideos_ShouldReturnAllForGivenParameter() {
        val categorySubjectTopicID = 1
        val result: List<CategorySubjectTopicVideo> =
            categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideos(categorySubjectTopicID)
        Assert.assertEquals(2, result.size.toLong())
    }

    @Test
    fun getCategorySubjectTopicVideoID_ShouldReturnValue() {
        val categorySubjectTopicID = 1
        val videoID = 1
        val result = categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideoID(
            categorySubjectTopicID, videoID
        )
        Assert.assertEquals(1, result.toLong())
    }

    @Test
    fun saveCategorySubjectTopicVideos_ShouldReturnTrueAfterSaving() {
        val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = ArrayList()
        categorySubjectTopicVideos.add(
            CategorySubjectTopicVideo(3, 2, 1, Date())
        )
        val result = categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(
            categorySubjectTopicVideos
        )
        Assert.assertTrue(result)
    }
}