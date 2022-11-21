package com.example.church.hymns.categories.CategoryList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.church.R
import com.example.church.hymns.categories.HymnCategory

const val CATEGORY_ID = "category id"

class CategoryListActivity : AppCompatActivity(){
    private val newCategoryActivityRequestCode = 1
    private val categoryListViewModel by viewModels<CategoriesListViewModel> {
        CategoriesListViewModelFactory(this)
    }

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_hymn_category)

    /* Instantiates headerAdapter and flowersAdapter. Both adapters are added to concatAdapter.
    which displays the contents sequentially */

   val categoryAdapter = CategoryAdapter { category -> adapterOnClick(category) }


    val recyclerView: RecyclerView = findViewById(R.id.recycler_hymncategory_list)
    recyclerView.adapter = categoryAdapter

    categoryListViewModel.categoriesLiveData.observe(this, {
        it?.let {
            categoryAdapter.submitList(it as MutableList<HymnCategory>)

        }
    })


}

/* Opens FlowerDetailActivity when RecyclerView item is clicked.*/
private fun adapterOnClick(category: HymnCategory) {
   // val intent = Intent(this, CategoryDetailActivity()::class.java)
   // intent.putExtra(CATEGORY_ID, category.id)
   // startActivity(intent)
}




/*
override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
    super.onActivityResult(requestCode, resultCode, intentData)

    /* Inserts flower into viewModel. */
    if (requestCode == newFlowerActivityRequestCode && resultCode == Activity.RESULT_OK) {
        intentData?.let { data ->
            val flowerName = data.getStringExtra(FLOWER_NAME)
            val flowerDescription = data.getStringExtra(FLOWER_DESCRIPTION)

            flowersListViewModel.insertFlower(flowerName, flowerDescription)
        }
    }
}*/
}