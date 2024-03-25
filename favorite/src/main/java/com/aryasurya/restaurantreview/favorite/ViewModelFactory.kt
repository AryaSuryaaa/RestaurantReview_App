package com.aryasurya.restaurantreview.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val restaurantUseCase: RestaurantUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(restaurantUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}