package com.aryasurya.restaurantreview.di

import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantInteractor
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideRestaurantUseCase(restaurantInteractor: RestaurantInteractor): RestaurantUseCase

}