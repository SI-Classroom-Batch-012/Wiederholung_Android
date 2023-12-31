package com.example.tierlexikonrepeat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tierlexikonrepeat.AnimalViewModel
import com.example.tierlexikonrepeat.data.Animal
import com.example.tierlexikonrepeat.databinding.AnimalItemBinding
import com.example.tierlexikonrepeat.ui.HomeFragmentDirections

class AnimalAdapter(private val dataset: List<Animal>, private val viewModel: AnimalViewModel)
    : RecyclerView.Adapter<AnimalAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var animal = dataset[position]
        holder.binding.animalImage.setImageResource(animal.image)
        holder.binding.animalTv.text = animal.name
        //Hier setzen wir per Click auf die CardView das currentAnimal welches wir auswählen
        //und navigieren gleichzeitig in das DetailFragment
        holder.binding.animalCv.setOnClickListener {
            viewModel.setCurrentAnimal(animal)
            val navController = holder.itemView.findNavController()
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }
    }
}