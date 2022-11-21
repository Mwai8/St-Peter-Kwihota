package com.example.church.hymns.categories.CategoryDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.church.hymns.categories.DataSource
import com.example.church.hymns.categories.HymnCategory

class CategoryDetailViewModel(private val datasource: DataSource) : ViewModel() {

    /* Queries datasource to returns a flower that corresponds to an id. */
    fun getCategoryFromId(id: Long) : HymnCategory? {
        return datasource.getCategoryFromId(id)
    }

    /* Queries datasource to remove a flower. */
    fun removeCategory(category: HymnCategory) {
        datasource.removeCategory(category)
    }
}

class CategoryDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
