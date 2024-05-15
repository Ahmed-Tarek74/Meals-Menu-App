package com.example.meal_app.di
import com.example.domain.repo.MealsRepo
import com.example.domain.usecases.GetMealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetMealsUseCase(mealsRepo: MealsRepo): GetMealsUseCase {
        return GetMealsUseCase(mealsRepo)
    }
}