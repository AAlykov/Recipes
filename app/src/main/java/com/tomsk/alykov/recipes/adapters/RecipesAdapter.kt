package com.tomsk.alykov.recipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tomsk.alykov.recipes.R
import com.tomsk.alykov.recipes.databinding.RecipesRowLayoutBinding
import com.tomsk.alykov.recipes.models.FoodRecipe
import com.tomsk.alykov.recipes.models.Result
import com.tomsk.alykov.recipes.util.RecipesDiffUtil


class RecipesAdapter: RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipe = emptyList<Result>()


    //class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class MyViewHolder(private val binding: RecipesRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: com.tomsk.alykov.recipes.models.Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.recipes_row_layout, parent, false)
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentResult = recipe[position]
        holder.bind(currentResult)
    }

    override fun getItemCount(): Int {
        return recipe.size
    }

    fun setData(newData: FoodRecipe) {
        val recipesDiffUtil = RecipesDiffUtil(recipe, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipe = newData.results
    }
}