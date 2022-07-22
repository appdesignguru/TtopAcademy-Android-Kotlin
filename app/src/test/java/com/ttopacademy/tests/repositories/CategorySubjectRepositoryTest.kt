package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import com.ttopacademy.repositories.real.CategorySubjectRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategorySubjectRepositoryTest {

    private lateinit var categorySubjectRepository: CategorySubjectRepository

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectRepository = CategorySubjectRepositoryImpl(
            FakeCategorySubjectLocalDataSource(), FakeCategorySubjectRemoteDataSource()
        )
    }

    @Test
    fun getCategorySubjectID_ShouldReturnValueForGivenParameters() {
        val categoryID = 1
        val subjectID = 2
        val result = categorySubjectRepository.getCategorySubjectID(categoryID, subjectID)
        Assert.assertEquals(2, result)
    }

    @Test
    fun getCategorySubjects_ShouldReturnForGivenParameter() {
        val categoryID = 2
        val result: List<CategorySubject> =
            categorySubjectRepository.getCategorySubjects(categoryID)
        Assert.assertEquals(2, result.size)
    }
}