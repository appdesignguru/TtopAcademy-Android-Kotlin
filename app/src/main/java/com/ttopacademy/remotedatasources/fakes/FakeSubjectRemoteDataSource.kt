package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.SubjectResponse
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource
import javax.inject.Inject

/** Fake Subject remote data source implementation class. Used for unit testing only. */
class FakeSubjectRemoteDataSource @Inject constructor() : SubjectRemoteDataSource {

    override fun getAllSubjects(): Result<MutableList<SubjectResponse>> {
        val mockSubjectResponses: MutableList<SubjectResponse> = mutableListOf()
        mockSubjectResponses.add(SubjectResponse(1, 1, "Physics"))
        mockSubjectResponses.add(SubjectResponse(2, 2, "Chemistry"))

        return Result.success(mockSubjectResponses)
    }
}