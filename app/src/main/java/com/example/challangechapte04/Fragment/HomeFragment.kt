package com.example.challangechapte04.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapte04.NoteAdapter
import com.example.challangechapte04.NoteViewModel
import com.example.challangechapte04.R
import com.example.challangechapte04.Room.DataNote
import com.example.challangechapte04.Room.NoteDatabase
import com.example.challangechapte04.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var sharedprefs: SharedPreferences
    lateinit var adapter: NoteAdapter
    lateinit var noteVm: NoteViewModel
    var noteDb : NoteDatabase? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedprefs =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        var nama = sharedprefs.getString("username", "")
        binding.txtWelcome.text = "Welcome! $nama"
        noteVm = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        noteVm.noteObserve().observe(requireActivity(), Observer{
            adapter.setNote(it as ArrayList<DataNote>)
        })
        noteDb = NoteDatabase.getInstance(requireActivity())

        binding.btnAdd.setOnClickListener{
            val addDialog = AddDialog()
            addDialog.show(parentFragmentManager,"AddDialog")
        }
        binding.btnLogout.setOnClickListener(){
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_loginFragment)
        }


    }

    fun getAllNote(){
        adapter = NoteAdapter(ArrayList())
        binding.rvHome.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        binding.rvHome.adapter = adapter

        adapter.edit ={
            val bundle = Bundle()
            bundle.putSerializable("dataNote", it)
            Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_editFragment)
            val addDialog = EditDialog()
            addDialog.arguments = bundle
            addDialog.show(parentFragmentManager, "AddDialog")
        }


    }
}