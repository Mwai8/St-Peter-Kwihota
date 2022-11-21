package com.example.church.hymns.categories.CategoryList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.church.hymns.categories.DataSource
import com.example.church.hymns.categories.HymnCategory
import kotlin.random.Random

class CategoriesListViewModel (val dataSource: DataSource): ViewModel() {
    val categoriesLiveData = dataSource.getCategoryList()

    /* If the name and description are present, create new Flower and add it to the datasource */
    fun insertCategory(categoryName: String?, categoryDescription: String?) {
        if (categoryName == null || categoryDescription == null) {
            return
        }


        val newCategory = HymnCategory(
            Random.nextLong(),
            categoryName,
            categoryDescription
        )

        dataSource.addhymnCategory(newCategory)
    }
}
class CategoriesListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoriesListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}