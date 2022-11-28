package com.tomsk.alykov.recipes.data

import com.tomsk.alykov.recipes.data.network.FoodRecipeApi
import com.tomsk.alykov.recipes.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipeApi
) {
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}