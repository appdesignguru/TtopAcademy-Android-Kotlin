package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource
import com.ttopacademy.remotedatasources.entities.SubjectResponse
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource
import com.ttopacademy.repositories.interfaces.SubjectRepository
import java.util.*
import javax.inject.Inject

/** SubjectRepository implementation class. */
class SubjectRepositoryImpl @Inject constructor(
    private val subjectLocalDataSource: SubjectLocalDataSource,
    private val subjectRemoteDataSource: SubjectRemoteDataSource
) : SubjectRepository {

    override fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject> {
        if (subjectLocalDataSource.isOutdated()) {
            refreshSubjects()
        }
        return subjectLocalDataSource.getSubjects(subjectIDs)
    }

    private fun refreshSubjects() {
        val result: Result<MutableList<SubjectResponse>> = subjectRemoteDataSource.getAllSubjects()
        if (result.isSuccess) {
            val subjectResponses: MutableList<SubjectResponse>? = result.getOrNull()
            if (subjectResponses != null){
                updateSubjectLocalDataSource(subjectResponses)
            }
        }
    }

    private fun updateSubjectLocalDataSource(subjectResponses: MutableList<SubjectResponse>) {
        subjectLocalDataSource.deleteAllSubjects()
        val subjects: MutableList<Subject> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((subjectID, number, name) in subjectResponses) {
            subjects.add(Subject(subjectID, number, name, dateSavedToLocalDatabase))
        }
        subjectLocalDataSource.saveSubjects(subjects)
    }
}