package com.example.challangechapte04.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Binder
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.challangechapte04.R
import com.example.challangechapte04.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
lateinit var binding: FragmentSplashBinding
lateinit var sharedprefs : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedprefs = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)

        Handler().postDelayed({
            if (sharedprefs.getString("username", "").equals("")){
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }
        },3000)
    }
}