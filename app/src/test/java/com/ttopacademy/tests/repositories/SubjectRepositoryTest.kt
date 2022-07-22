package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.fakes.FakeSubjectLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeSubjectRemoteDataSource
import com.ttopacademy.repositories.interfaces.SubjectRepository
import com.ttopacademy.repositories.real.SubjectRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SubjectRepositoryTest {

    private lateinit var subjectRepository: SubjectRepository

    @Before
    fun initializeBeforeEachTest() {
        subjectRepository = SubjectRepositoryImpl(
            FakeSubjectLocalDataSource(), FakeSubjectRemoteDataSource()
        )
    }

    @Test
    fun getSubjects_ShouldReturnForGivenParameters() {
        val subjectIDs: MutableList<Int> = ArrayList()
        subjectIDs.add(1)
        subjectIDs.add(2)
        val result: List<Subject> = subjectRepository.getSubjects(subjectIDs)
        Assert.assertEquals(subjectIDs.size, result.size)
    }
}