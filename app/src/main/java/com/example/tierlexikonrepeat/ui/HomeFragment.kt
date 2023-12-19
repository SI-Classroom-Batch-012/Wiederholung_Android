package com.example.tierlexikonrepeat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tierlexikonrepeat.adapter.AnimalAdapter
import com.example.tierlexikonrepeat.data.Repository
import com.example.tierlexikonrepeat.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding


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
        var animals = repository.getAnimals
        binding.animalRV.adapter = AnimalAdapter(animals)
    }

}