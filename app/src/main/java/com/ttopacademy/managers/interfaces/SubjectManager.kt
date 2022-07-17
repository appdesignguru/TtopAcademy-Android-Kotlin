package com.ttopacademy.managers.interfaces

import com.ttopacademy.localdatasources.entities.Subject

/** Interface for managing topics. */
interface SubjectManager {

    /** Returns the subjects for given parameter. */
    fun getSubjects(categoryID: Int) : MutableList<Subject>

}