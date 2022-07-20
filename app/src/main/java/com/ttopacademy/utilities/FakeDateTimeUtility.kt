package com.ttopacademy.utilities

import java.util.*
import javax.inject.Inject

/** FakeDateTimeUtility implementation class.  */
class FakeDateTimeUtility @Inject constructor() : DateTimeUtility {

    override fun numberOfDaysBetween(firstDate: Date, secondDate: Date): Long {
        return 0
    }

}