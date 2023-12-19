package com.example.tierlexikonrepeat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tierlexikonrepeat.AnimalViewModel
import com.example.tierlexikonrepeat.adapter.AnimalAdapter
import com.example.tierlexikonrepeat.data.Repository
import com.example.tierlexikonrepeat.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel: AnimalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = Repository()
        var animals = viewModel.animalList.value!!
        binding.animalRV.adapter = AnimalAdapter(animals, viewModel)
    }

}