package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.Subject

/** Repository interface for subjects. */
interface SubjectRepository {

    /** Returns subjects with given parameters.  */
    fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject>
}