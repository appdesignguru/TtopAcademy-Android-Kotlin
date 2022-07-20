package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao
import com.ttopacademy.utilities.DateTimeUtility
import javax.inject.Inject

/** PracticeQuestionLocalDataSourceFactory implementation class.  */
class PracticeQuestionLocalDataSourceFactoryImpl @Inject constructor(
    private val mathPracticeQuestionDao: MathPracticeQuestionDao,
    private val physicsPracticeQuestionDao: PhysicsPracticeQuestionDao,
    private val chemistryPracticeQuestionDao: ChemistryPracticeQuestionDao,
    private val otherPracticeQuestionDao: OtherPracticeQuestionDao,
    private val dateTimeUtility: DateTimeUtility
) : PracticeQuestionLocalDataSourceFactory {

    override fun getSpecificPracticeQuestionLocalDataSource(subjectName: String): SpecificPracticeQuestionLocalDataSource {
        return when (subjectName) {
            "Mathematics" -> MathPracticeQuestionLocalDataSourceImpl(
                mathPracticeQuestionDao, dateTimeUtility
            )
            "Physics" -> PhysicsPracticeQuestionLocalDataSourceImpl(
                physicsPracticeQuestionDao, dateTimeUtility
            )
            "Chemistry" -> ChemistryPracticeQuestionLocalDataSourceImpl(
                chemistryPracticeQuestionDao, dateTimeUtility
            )
            else -> OtherPracticeQuestionLocalDataSourceImpl(
                otherPracticeQuestionDao,
                dateTimeUtility
            )
        }
    }
}
