package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubject

/** CategorySubject local data source interface. */
interface CategorySubjectLocalDataSource {

    /** Checks whether categorySubject local data source is NOT up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns categorySubjects for given parameter.  */
    fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject>

    /** Returns categorySubjectID for given parameters.  */
    fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int

    /** Returns true after saving successfully.  */
    fun saveCategorySubjects(categorySubjects: MutableList<CategorySubject>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllCategorySubjects(): Boolean
}