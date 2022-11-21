package com.example.church.hymns.categories

import android.content.res.Resources
import com.example.church.R

fun categoryList(resources: Resources): List<HymnCategory> {
    return listOf(
        HymnCategory(
            id = 1,
            name = resources.getString(R.string.category1_name),
            description = resources.getString(R.string.category1_description)
        ),
        HymnCategory(
            id = 2,
            name = resources.getString(R.string.category2_name),
            description = resources.getString(R.string.category2_description)
        ),
        HymnCategory(
            id = 3,
            name = resources.getString(R.string.category3_name),
            description = resources.getString(R.string.category3_description)
        ),
        HymnCategory(
            id = 4,
            name = resources.getString(R.string.category4_name),
            description = resources.getString(R.string.category4_description)
        ),
        HymnCategory(
            id = 5,
            name = resources.getString(R.string.category5_name),
            description = resources.getString(R.string.category5_description)
        ),
    )
}