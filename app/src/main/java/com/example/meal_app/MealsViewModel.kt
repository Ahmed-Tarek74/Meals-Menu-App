package com.example.meal_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Meal
import com.example.domain.usecases.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase
): ViewModel() {

    private val _mealsList: MutableStateFlow<List<Meal>> = MutableStateFlow(emptyList())
    val mealsList: StateFlow<List<Meal>> = _mealsList
    private val _isLoading=MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> =_isLoading

    fun fetchMealsData(){
        viewModelScope.launch{
            _isLoading.value=true
            try {
                _mealsList.value = getMealsUseCase.getMeals()
                _isLoading.value=false

            } catch (e: Exception){
                Log.e("catching meals error", e.message.toString())
            }
        }
    }

}