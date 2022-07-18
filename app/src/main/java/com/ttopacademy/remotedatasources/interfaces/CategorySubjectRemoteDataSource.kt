package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse

/** CategorySubject remote data source interface.  */
interface CategorySubjectRemoteDataSource {

    /** Returns CategorySubject responses.  */
    fun getAllCategorySubjects(): Result<List<CategorySubjectResponse>>

}