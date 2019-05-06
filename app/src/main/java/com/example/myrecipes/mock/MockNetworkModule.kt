package com.example.myrecipes.mock

import com.example.myrecipes.mock.interceptors.MockInterceptor
import com.example.myrecipes.mock.interceptors.RecipeMock
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.network.NetworkModule
import com.example.myrecipes.network.RecipeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MockNetworkModule {

    private val networkModule = NetworkModule()

//    @Provides
//    @Singleton
//    fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
////        return networkModule.provideOkHttpClientBuilder(settings)
//    }

    @Provides
    @Singleton
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        builder.interceptors().add(builder.interceptors().size, MockInterceptor())

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return networkModule.provideRetrofit(client)
    }

    @Provides
    @Singleton
    fun provideStuffsApi(client: OkHttpClient): RecipeApi {
        return networkModule.provideRecipeApi(client)
    }
}