package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.interfaces.SubjectLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.SubjectDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** SubjectLocalDataSource implementation class.  */
class SubjectLocalDataSourceImpl @Inject constructor(
    private val subjectDao: SubjectDao,
    private val dateTimeUtility: DateTimeUtility
) : SubjectLocalDataSource {

    override fun isOutdated(): Boolean {
        val todaysDate = Date()
        val lastUpdated = subjectDao.getDateOfLastUpdate() ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getSubjects(subjectIDs: MutableList<Int>): MutableList<Subject> {
        return subjectDao.getSubjects(subjectIDs)
    }

    override fun saveSubjects(subjects: MutableList<Subject>): Boolean {
        subjectDao.insertSubjects(subjects)
        return true
    }

    override fun deleteAllSubjects(): Boolean {
        subjectDao.deleteAllSubjects()
        return true
    }
}
