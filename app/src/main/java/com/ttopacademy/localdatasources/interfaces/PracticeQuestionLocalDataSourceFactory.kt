package com.ttopacademy.localdatasources.interfaces

/** PracticeQuestionLocalDataSourceFactory interface. */
interface PracticeQuestionLocalDataSourceFactory {

    /** Returns the appropriate practice question local data source for the given subject name.  */
    fun getSpecificPracticeQuestionLocalDataSource(subjectName: String): SpecificPracticeQuestionLocalDataSource

}