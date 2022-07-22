package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource
import com.ttopacademy.localdatasources.roomdb.SubjectLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeSubjectDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class SubjectLocalDataSourceTest {

    private lateinit var subjectLocalDataSource: SubjectLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        subjectLocalDataSource = SubjectLocalDataSourceImpl(FakeSubjectDao(), FakeDateTimeUtility())

        // PreSave
        val subjects: MutableList<Subject> = mutableListOf()
        subjects.add(Subject(1, 1, "Physics", Date()))
        subjects.add(Subject(2, 2, "Chemistry", Date()))
        subjectLocalDataSource.saveSubjects(subjects)
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val result = subjectLocalDataSource.isOutdated()
        Assert.assertTrue(result)
    }

    @Test
    fun getSubjects_ShouldReturnAllForGivenParameters() {
        val subjectIDs: MutableList<Int> = mutableListOf()
        subjectIDs.add(1)
        subjectIDs.add(2)
        val result: List<Subject> = subjectLocalDataSource.getSubjects(subjectIDs)
        Assert.assertEquals(subjectIDs.size.toLong(), result.size.toLong())
    }

    @Test
    fun saveSubjects_ShouldReturnTrueAfterSaving() {
        val subjects: MutableList<Subject> = mutableListOf()
        subjects.add(Subject(3, 3, "Biology", Date()))
        val result = subjectLocalDataSource.saveSubjects(subjects)
        Assert.assertTrue(result)
    }

    @Test
    fun deleteAllSubjects_ShouldReturnTrueAfterDeleting() {
        val result = subjectLocalDataSource.deleteAllSubjects()
        Assert.assertTrue(result)
    }
}