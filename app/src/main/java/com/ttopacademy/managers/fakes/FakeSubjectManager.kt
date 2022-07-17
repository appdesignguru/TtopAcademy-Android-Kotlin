package com.ttopacademy.managers.fakes

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.managers.interfaces.SubjectManager
import java.util.*
import javax.inject.Inject

/** Fake Subject Manager implementation class. Used for unit testing only. */
class FakeSubjectManager @Inject constructor() : SubjectManager {

    override fun getSubjects(categoryID: Int): MutableList<Subject> {
        val mockSubjects: MutableList<Subject> = mutableListOf()
        mockSubjects.add(Subject(1, 1, "Physics", Date()))
        mockSubjects.add(Subject(2, 2, "Biology", Date()))

        return mockSubjects
    }
}