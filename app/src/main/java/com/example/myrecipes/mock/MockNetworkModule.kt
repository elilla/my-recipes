package com.example.myrecipes.mock

import com.example.myrecipes.mock.interceptors.MockInterceptor
import com.example.myrecipes.mock.interceptors.RecipeMock
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.network.NetworkModule
import com.example.myrecipes.network.RecipeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.Nullable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MockNetworkModule {
    private val networkModule = NetworkModule()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = MockInterceptor()
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }

    @Provides
    @Singleton
    fun provideRecipeApi(client: OkHttpClient): RecipeApi {
        return networkModule.provideRecipeApi(client)
    }
}