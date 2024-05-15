package com.example.domain.repo

import com.example.domain.models.MealsResponse

interface MealsRepo {
    suspend fun getMealsFromRemote(): MealsResponse
}