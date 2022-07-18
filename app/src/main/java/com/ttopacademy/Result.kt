package com.ttopacademy

/** Models a Result.  */
sealed class Result<T>
/** Constructs a new instance.  */
{
    /** Represents success.  */
    data class Success<T>(val data: T) : Result<T>()

    /** Represents error.  */
    data class Error<T>(
        /** Represents error exception.  */
        var exception: Exception
    ) : Result<Nothing>()
}