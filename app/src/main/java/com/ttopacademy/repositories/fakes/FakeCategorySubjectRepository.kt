package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import java.util.*
import javax.inject.Inject

/** Fake CategorySubject repository implementation class. Used for unit testing only. */
class FakeCategorySubjectRepository @Inject constructor() : CategorySubjectRepository {

    override fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int {
        return 1
    }

    override fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject> {
        val mockCategorySubjects: MutableList<CategorySubject> = mutableListOf()
        mockCategorySubjects.add(CategorySubject(1, 1, 1, Date()))
        mockCategorySubjects.add(CategorySubject(1, 1, 2, Date()))

        return mockCategorySubjects
    }
}