package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao
import java.util.*
import javax.inject.Inject

/** Fake Subject DAO implementation class. Used for unit testing only.  */
class FakeSubjectDao @Inject constructor() : SubjectDao {

    private val subjects: MutableList<Subject> = mutableListOf()

    @Inject
    override fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject> {
        val result: MutableList<Subject> = mutableListOf()
        var subject: Subject?
        for (subjectID in subjectIDs) {
            subject = getSubject(subjectID)
            if (subject != null) {
                result.add(subject)
            }
        }
        return result
    }

    override fun insertSubjects(subjects: MutableList<Subject>) {
        this.subjects.addAll(subjects)
    }

    override fun deleteAllSubjects() {
        subjects.clear()
    }

    override fun getDateOfLastUpdate(): Date? {
        return null
    }

    private fun getSubject(subjectID: Int): Subject? {
        for (subject in subjects) {
            if (subject.subjectID == subjectID) {
                return subject
            }
        }
        return null
    }
}
