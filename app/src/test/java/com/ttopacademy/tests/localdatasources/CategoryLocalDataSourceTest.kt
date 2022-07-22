package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource
import com.ttopacademy.localdatasources.roomdb.CategoryLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategoryDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class CategoryLocalDataSourceTest {

    private lateinit var categoryLocalDataSource: CategoryLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        categoryLocalDataSource = CategoryLocalDataSourceImpl(
            FakeCategoryDao(), FakeDateTimeUtility()
        )

        // PreSave
        val categories: MutableList<Category> = mutableListOf()
        categories.add(Category(1, 1, "JAMB", Date()))
        categories.add(Category(2, 2, "SS3", Date()))
        categoryLocalDataSource.saveCategories(categories)
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val result = categoryLocalDataSource.isOutdated()
        Assert.assertTrue(result)
    }

    @Test
    fun getAllCategories_ShouldReturnEmpty() {
        val result: MutableList<Category> = categoryLocalDataSource.getAllCategories()
        Assert.assertEquals(2, result.size)
    }

    @Test
    fun saveCategories_ShouldReturnTrueAfterSaving() {
        val categories: MutableList<Category> = ArrayList()
        categories.add(Category(3, 3, "SS2", Date()))
        val result = categoryLocalDataSource.saveCategories(categories)
        Assert.assertTrue(result)
    }

    @Test
    fun deleteAllCategories_ShouldReturnTrueAfterDeleting() {
        val result = categoryLocalDataSource.deleteAllCategories()
        Assert.assertTrue(result)
    }
}