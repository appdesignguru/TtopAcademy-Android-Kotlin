package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao
import java.util.*
import javax.inject.Inject

/** Fake CategorySubject dao implementation class. Used for unit testing only.  */
class FakeCategorySubjectDao @Inject constructor() : CategorySubjectDao {

    private val categorySubjects: MutableList<CategorySubject> = mutableListOf()

    override fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject> {
        val result: MutableList<CategorySubject> = mutableListOf()
        for (categorySubject in categorySubjects) {
            if (categorySubject.categoryID == categoryID) {
                result.add(categorySubject)
            }
        }
        return result
    }

    override fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int {
        for (categorySubject in categorySubjects) {
            if (categorySubject.categoryID == categoryID && categorySubject.subjectID == subjectID) {
                return categorySubject.categorySubjectID
            }
        }
        return 0
    }

    override fun insertCategorySubjects(categorySubjects: MutableList<CategorySubject>) {
        this.categorySubjects.addAll(categorySubjects)
    }

    override fun deleteAllCategorySubjects() {
        categorySubjects.clear()
    }

    override fun getDateOfLastUpdate(): Date? {
        return null
    }
}
