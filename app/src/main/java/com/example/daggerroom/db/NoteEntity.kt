
package com.example.daggerroom.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.daggerroom.utils.Constants.NOTE_TABLE
import androidx.room.PrimaryKey


@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId :Int =0,
    @ColumnInfo(name = "note_title")
    val noteTitle:String="",
    @ColumnInfo(name = "note_desc")
    val noteDesc : String=""
)
