package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.CategoryResponse

/** Category remote data source interface.  */
interface CategoryRemoteDataSource {

    /** Returns category responses.  */
    fun getAllCategories(): Result<MutableList<CategoryResponse>>
}