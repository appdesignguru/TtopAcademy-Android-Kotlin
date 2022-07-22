package com.ttopacademy.tests.managers

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.managers.interfaces.SubjectManager
import com.ttopacademy.managers.real.SubjectManagerImpl
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository
import com.ttopacademy.repositories.fakes.FakeSubjectRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SubjectManagerTest {

    private lateinit var subjectManager: SubjectManager

    @Before
    fun initializeBeforeEachTest() {
        subjectManager = SubjectManagerImpl(
            FakeCategorySubjectRepository(), FakeSubjectRepository()
        )
    }

    @Test
    fun getSubjects_ShouldReturnSubjectsForGivenParameter(){
        val categoryID = 1
        val result: MutableList<Subject> = subjectManager.getSubjects(categoryID)
        assertEquals(2, result.size)
    }
}