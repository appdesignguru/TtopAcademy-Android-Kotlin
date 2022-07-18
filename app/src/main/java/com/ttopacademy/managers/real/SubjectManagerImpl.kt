package com.ttopacademy.managers.real

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.managers.interfaces.SubjectManager
import com.ttopacademy.repositories.interfaces.CategorySubjectRepository
import com.ttopacademy.repositories.interfaces.SubjectRepository
import javax.inject.Inject

/** SubjectManager implementation class. */
class SubjectManagerImpl @Inject constructor(
    private val categorySubjectRepository: CategorySubjectRepository,
    private val subjectRepository: SubjectRepository
) : SubjectManager {

    override fun getSubjects(categoryID: Int): MutableList<Subject> {
        val categorySubjects: MutableList<CategorySubject> =
            categorySubjectRepository.getCategorySubjects(categoryID)
        val subjectIDs: MutableList<Int> = mutableListOf()
        for (categorySubject in categorySubjects) {
            subjectIDs.add(categorySubject.subjectID)
        }
        return subjectRepository.getSubjects(subjectIDs)
    }
}