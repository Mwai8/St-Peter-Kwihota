package com.example.church.hymns.categories

import androidx.annotation.DrawableRes

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on flowersLiveData and holds details about it. */
class DataSource(resources: Resources) {
    private val initialCategoryList = categoryList(resources)
    private val categoryLiveData = MutableLiveData(initialCategoryList)

    /* Adds Hymn Category to liveData and posts value. */
    fun addhymnCategory(hymnCategory: HymnCategory) {
        val currentList = categoryLiveData.value
        if (currentList == null) {
            categoryLiveData.postValue(listOf(hymnCategory))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, hymnCategory)
            categoryLiveData.postValue(updatedList)
        }
    }

    /* Removes flower from liveData and posts value. */
    fun removeCategory(hymnCategory: HymnCategory) {
        val currentList = categoryLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(hymnCategory)
            categoryLiveData.postValue(updatedList)
        }
    }

    /* Returns flower given an ID. */
    fun getCategoryFromId(id: Long): HymnCategory? {
        categoryLiveData.value?.let { hymnCategories ->
            return hymnCategories.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getCategoryList(): LiveData<List<HymnCategory>> {
        return categoryLiveData
    }



    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}