package com.example.challangechapte04.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.challangechapte04.NoteViewModel
import com.example.challangechapte04.R
import com.example.challangechapte04.Room.DataNote
import com.example.challangechapte04.databinding.FragmentAddDialogBinding

class AddDialog : DialogFragment() {

    lateinit var binding : FragmentAddDialogBinding
    lateinit var noteVm: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteVm = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        var newTittle = binding.edtNewJudul.text.toString()
        var newNote = binding.edtNewNote.text.toString()

        binding.btnSub.setOnClickListener{
            noteVm.insertNote(DataNote(id, newTittle,newNote ))
            dismiss()
            Toast.makeText(context, "Berhasil Menambahkan Note Baru", Toast.LENGTH_LONG).show()
        }
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


}