package com.example.domain.usecases

import com.example.domain.models.Meal
import com.example.domain.repo.MealsRepo

class GetMealsUseCase (private val getMealsRepo: MealsRepo) {
    suspend fun getMeals (): List<Meal> {
        return getMealsRepo.getMealsFromRemote().categories
    }
}