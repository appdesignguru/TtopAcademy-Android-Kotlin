package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.SubjectResponse

/** Subject remote data source interface.  */
interface SubjectRemoteDataSource {

    /** Returns subject responses.  */
    fun getAllSubjects(): Result<List<SubjectResponse>>
}