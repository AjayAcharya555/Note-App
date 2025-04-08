package com.example.daggerroom.di


import android.content.Context
import androidx.room.Room
import com.example.daggerroom.db.NoteDatabase
import com.example.daggerroom.db.NoteEntity
import com.example.daggerroom.utils.Constants.NOTE_DATABASE

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, NoteDatabase::class.java, NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: NoteDatabase) = db.noteDoa()

    @Provides
    fun provideEntity() = NoteEntity()


}