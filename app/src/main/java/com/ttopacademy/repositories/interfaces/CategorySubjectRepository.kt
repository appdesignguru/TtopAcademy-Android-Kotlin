package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubject

interface CategorySubjectRepository {

    /** Returns categorySubjectID.  */
    fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int

    /** Returns categorySubjects for given parameter.  */
    fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject>

}