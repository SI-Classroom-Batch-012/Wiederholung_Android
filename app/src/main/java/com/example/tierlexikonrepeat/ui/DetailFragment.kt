package com.example.tierlexikonrepeat.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tierlexikonrepeat.AnimalViewModel
import com.example.tierlexikonrepeat.R
import com.example.tierlexikonrepeat.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel : AnimalViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("ViewModel", "${viewModel.currentAnimal.value!!.name}")
        viewModel.currentAnimal.observe(viewLifecycleOwner) {
            binding.detailImage.setImageResource(viewModel.currentAnimal.value!!.image)
            binding.detailName.text = viewModel.currentAnimal.value!!.name
            if(it.isLiked) {
                binding.thumpsLikedImage.visibility = View.VISIBLE
                binding.thumpsImage.visibility = View.GONE
            } else {
                binding.thumpsLikedImage.visibility = View.GONE
                binding.thumpsImage.visibility = View.VISIBLE
            }
        }
        binding.thumpsImage.setOnClickListener {
            viewModel.changeLikedStatus(viewModel.currentAnimal.value!!)
        }
        binding.thumpsLikedImage.setOnClickListener {
            viewModel.changeLikedStatus(viewModel.currentAnimal.value!!)
        }

        binding.detailBackButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}