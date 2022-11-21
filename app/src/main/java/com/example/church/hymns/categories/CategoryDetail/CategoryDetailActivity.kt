import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.church.R
import com.example.church.hymns.categories.CategoryDetail.CategoryDetailViewModel
import com.example.church.hymns.categories.CategoryDetail.CategoryDetailViewModelFactory
import com.example.church.hymns.categories.CategoryList.CATEGORY_ID


class FlowerDetailActivity : AppCompatActivity() {

    private val categoryDetailViewModel by viewModels<CategoryDetailViewModel> {
        CategoryDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hymn_category)

        var currentCategoryId: Long? = null

        /* Connect variables to UI elements. */
        val categoryName: TextView = findViewById(R.id.categoryListText)


        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentCategoryId = bundle.getLong(CATEGORY_ID)
        }

        /* If currentFlowerId is not null, get corresponding flower and set name, image and
        description */
        currentCategoryId?.let {
            val currentFlower = categoryDetailViewModel.getCategoryFromId(it)
            categoryName.text = currentFlower?.name




        }

    }
}