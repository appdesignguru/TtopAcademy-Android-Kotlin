package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.repositories.interfaces.SubjectRepository
import java.util.*
import javax.inject.Inject

/** Fake Subject repository implementation class. Used for unit testing only.  */
class FakeSubjectRepository @Inject constructor() : SubjectRepository {

    override fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject> {
        val mockSubjects: MutableList<Subject> = mutableListOf()
        mockSubjects.add(Subject(1, 1, "Physics", Date()))
        mockSubjects.add(Subject(2, 2, "Biology", Date()))

        return mockSubjects
    }
}