package com.example.tierlexikonrepeat

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tierlexikonrepeat.data.Animal
import com.example.tierlexikonrepeat.data.Repository

class AnimalViewModel : ViewModel() {
    private val repository : Repository = Repository()
    private val animals = repository.getAnimals

    private val _animalList : MutableLiveData<List<Animal>> = MutableLiveData(animals)
    val animalList: LiveData<List<Animal>>
        get() = _animalList

    private val _currentAnimal : MutableLiveData<Animal> = MutableLiveData()
    val currentAnimal : LiveData<Animal>
        get() = _currentAnimal

    fun setCurrentAnimal(animal: Animal) {
        _currentAnimal.postValue(animal)
    }

    fun changeLikedStatus(animal: Animal) {
        animal.isLiked = !animal.isLiked
        Log.d("ViewModel", "${animal.isLiked}")
        _currentAnimal.postValue(animal)
    }
}