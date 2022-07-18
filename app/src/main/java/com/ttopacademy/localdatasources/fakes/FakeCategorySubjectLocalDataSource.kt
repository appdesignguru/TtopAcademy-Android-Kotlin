package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource
import javax.inject.Inject

/** Fake CategorySubject local data source implementation class. Used for unit testing only. */
class FakeCategorySubjectLocalDataSource @Inject constructor() : CategorySubjectLocalDataSource {

    private val categorySubjects: MutableList<CategorySubject> = mutableListOf()
    private var outdated = true

    override fun isOutdated(): Boolean {
        return outdated
    }

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
            if (categorySubject.categoryID == categoryID
                && categorySubject.subjectID == subjectID
            ) {
                return categorySubject.categorySubjectID
            }
        }
        return 0
    }

    override fun saveCategorySubjects(categorySubjects: MutableList<CategorySubject>): Boolean {
        this.categorySubjects.clear()
        this.categorySubjects.addAll(categorySubjects)
        outdated = false
        return true
    }

    override fun deleteAllCategorySubjects(): Boolean {
        categorySubjects.clear()
        outdated = true
        return true
    }
}