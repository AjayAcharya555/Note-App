package com.example.daggerroom.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerroom.adapter.NoteAdapter
import com.example.daggerroom.databinding.ActivityUpdateNoteBinding
import com.example.daggerroom.db.NoteEntity
import com.example.daggerroom.repository.DbRepository
import com.example.daggerroom.utils.Constants.BUNDLE_NOTE_ID

import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateNoteBinding

    @Inject
    lateinit var  repository: DbRepository

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var note: NoteEntity

    private var noteId = 0
    private var defaultTitle = ""
    private var defaultDesc = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            noteId = it.getInt(BUNDLE_NOTE_ID)
        }

        binding.apply {
            defaultTitle=repository.getNote(noteId).noteTitle
            defaultDesc=repository.getNote(noteId).noteDesc

            edtTitle.setText(defaultTitle)
            edtDesc.setText(defaultDesc)

            btnDelete.setOnClickListener {
                note= NoteEntity(noteId,defaultTitle,defaultDesc)
                repository.deleteNote(note)
                finish()
            }

            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc=edtDesc.text.toString()
                if (title.isNotEmpty() || desc.isNotEmpty()){
                    note= NoteEntity(noteId,title,desc)
                    repository.updateNote(note)
                    finish()
                }
                else{
                    Snackbar.make(it,"Title and Description cannot be Empty", Snackbar.LENGTH_LONG).show()
                }
            }
        }

    }
}