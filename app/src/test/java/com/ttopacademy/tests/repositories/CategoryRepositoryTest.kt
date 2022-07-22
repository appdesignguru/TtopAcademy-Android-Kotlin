package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.fakes.FakeCategoryLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeCategoryRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategoryRepository
import com.ttopacademy.repositories.real.CategoryRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategoryRepositoryTest {

    private lateinit var categoryRepository: CategoryRepository

    @Before
    fun initializeBeforeEachTest() {
        categoryRepository = CategoryRepositoryImpl(
            FakeCategoryLocalDataSource(), FakeCategoryRemoteDataSource()
        )
    }

    @Test
    fun getAllCategories_ShouldReturnAllCategories() {
        val result: List<Category> = categoryRepository.getAllCategories()
        Assert.assertEquals(2, result.size)
    }
}