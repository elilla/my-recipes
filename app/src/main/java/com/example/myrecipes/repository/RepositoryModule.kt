package com.example.myrecipes.repository

/**
 * Created by Acer on 2019. 05. 06..
 */
import com.example.myrecipes.repository.room.RoomRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(roomRepository: RoomRepository): Repository

}