package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.Subject

/** Subject local data source interface. */
interface SubjectLocalDataSource {

    /** Checks whether subject local data source is NOT up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns subjects with given parameters.  */
    fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject>

    /** Returns true after saving successfully.  */
    fun saveSubjects(subjects: MutableList<Subject>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllSubjects(): Boolean
}