package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource
import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import java.util.*
import javax.inject.Inject

/** CategorySubjectRepository Implementation class. */
class CategorySubjectRepositoryImpl @Inject constructor(
    private val categorySubjectLocalDataSource: CategorySubjectLocalDataSource,
    private val categorySubjectRemoteDataSource: CategorySubjectRemoteDataSource
) : CategorySubjectRepository {

    override fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int {
        if (categorySubjectLocalDataSource.isOutdated()) {
            refreshCategorySubjects()
        }
        return categorySubjectLocalDataSource.getCategorySubjectID(categoryID, subjectID)
    }

    override fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject> {
        if (categorySubjectLocalDataSource.isOutdated()) {
            refreshCategorySubjects()
        }
        return categorySubjectLocalDataSource.getCategorySubjects(categoryID)
    }

    private fun refreshCategorySubjects() {
        val result: Result<MutableList<CategorySubjectResponse>> =
            categorySubjectRemoteDataSource.getAllCategorySubjects()
        if (result.isSuccess) {
            val categorySubjectResponses: MutableList<CategorySubjectResponse>? = result.getOrNull()
            if (categorySubjectResponses != null){
                updateCategorySubjectLocalDataSource(categorySubjectResponses)
            }
        }
    }

    private fun updateCategorySubjectLocalDataSource(categorySubjectResponses: MutableList<CategorySubjectResponse>) {
        categorySubjectLocalDataSource.deleteAllCategorySubjects()
        val categorySubjects: MutableList<CategorySubject> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((categorySubjectID, categoryID, subjectID) in categorySubjectResponses) {
            categorySubjects.add(
                CategorySubject(categorySubjectID,categoryID, subjectID,dateSavedToLocalDatabase
                )
            )
        }
        categorySubjectLocalDataSource.saveCategorySubjects(categorySubjects)
    }
}