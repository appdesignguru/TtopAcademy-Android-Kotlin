package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource
import com.ttopacademy.localdatasources.roomdb.CategorySubjectLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeCategorySubjectDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class CategorySubjectLocalDataSourceTest {

    private lateinit var categorySubjectLocalDataSource: CategorySubjectLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectLocalDataSource = CategorySubjectLocalDataSourceImpl(
            FakeCategorySubjectDao(), FakeDateTimeUtility()
        )

        // PreSave
        val categorySubjects: MutableList<CategorySubject> = mutableListOf()
        categorySubjects.add(CategorySubject(1, 1, 1, Date()))
        categorySubjects.add(CategorySubject(2, 1, 2, Date()))
        categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects)
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val result = categorySubjectLocalDataSource.isOutdated()
        Assert.assertTrue(result)
    }

    @Test
    fun getCategorySubjects_ShouldReturnAllForGivenParameter() {
        val categoryID = 1
        val result: List<CategorySubject> =
            categorySubjectLocalDataSource.getCategorySubjects(categoryID)
        Assert.assertEquals(2, result.size)
    }

    @Test
    fun getCategorySubjectID_ShouldReturnValue() {
        val categoryID = 1
        val subjectID = 1
        val result = categorySubjectLocalDataSource.getCategorySubjectID(categoryID, subjectID)
        Assert.assertEquals(1, result)
    }

    @Test
    fun saveCategorySubjects_ShouldReturnTrueAfterSaving() {
        val categorySubjects: MutableList<CategorySubject> = ArrayList()
        categorySubjects.add(CategorySubject(3, 2, 1, Date()))
        val result = categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects)
        Assert.assertTrue(result)
    }

    @Test
    fun deleteAllCategorySubjects_ShouldReturnTrueAfterDeleting() {
        val result = categorySubjectLocalDataSource.deleteAllCategorySubjects()
        Assert.assertTrue(result)
    }
}