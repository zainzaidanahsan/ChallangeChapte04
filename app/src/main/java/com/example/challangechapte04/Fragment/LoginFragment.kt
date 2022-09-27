package com.example.challangechapte04.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.challangechapte04.R
import com.example.challangechapte04.databinding.FragmentLoginBinding
import com.example.challangechapte04.databinding.FragmentRegisterBinding

class LoginFragment : Fragment() {
lateinit var binding: FragmentLoginBinding
lateinit var sharedprefs: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedprefs = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)

        binding.textBelumPunyaAkun.setOnClickListener{
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener{
            if ((binding.edtUsername.text.toString() == sharedprefs.getString("username", "")) &&
                (binding.edtPass.text.toString().equals(sharedprefs.getString("password", "")))){
                Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_homeFragment)
            }else if(binding.edtPass.text.toString().isEmpty() || binding.edtUsername.text.toString().isEmpty()){
                Toast.makeText(context, "Isi semua data dengan benar", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Username/Password Salah!", Toast.LENGTH_LONG).show()
            }
        }
    }

}