package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource
import javax.inject.Inject

/** Fake Subject local data source implementation class. Used for unit testing only. */
class FakeSubjectLocalDataSource @Inject constructor() : SubjectLocalDataSource {

    private val subjects: MutableList<Subject> = mutableListOf()
    private var outdated = true

    override fun isOutdated(): Boolean {
        return outdated
    }

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

    override fun saveSubjects(subjects: MutableList<Subject>): Boolean {
        this.subjects.clear()
        this.subjects.addAll(subjects)
        outdated = false
        return true
    }

    override fun deleteAllSubjects(): Boolean {
        subjects.clear()
        outdated = true
        return true
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