package com.example.meal_app
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Meal
import com.example.meal_app.databinding.MealItemInListBinding

class MealAdapter: ListAdapter<Meal, MealAdapter.MealsViewHolder>(CategoryDiffCallback()) {
    inner class MealsViewHolder(private val itemViewBinding: MealItemInListBinding):RecyclerView.ViewHolder(itemViewBinding.root){
        fun bind(meal: Meal) {
            itemViewBinding.mealName.text = meal.strCategory
            itemViewBinding.mealDesc.text = meal.strCategoryDescription
            Glide.with(itemViewBinding.root.context).load(meal.strCategoryThumb).into(itemViewBinding.mealImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val mealItemViewBinding= MealItemInListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(mealItemViewBinding)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class CategoryDiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }
        override fun areContentsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem == newItem
        }
    }

}