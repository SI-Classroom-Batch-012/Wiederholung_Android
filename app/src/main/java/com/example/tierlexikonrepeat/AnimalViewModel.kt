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

    //Live Data um die Tierliste aus dem Repository zu verwalten. Wird aus dem Repository herausgeladen.
    private val _animalList : MutableLiveData<List<Animal>> = MutableLiveData(animals)
    val animalList: LiveData<List<Animal>>
        get() = _animalList

    //Live Data um das aktuelle aktuelle Animal zu sichern. Dient dazu, die Daten
    //aus dem Objekt in den verschiedenen Fragmenten abrufbar zu machen.
    private val _currentAnimal : MutableLiveData<Animal> = MutableLiveData()
    val currentAnimal : LiveData<Animal>
        get() = _currentAnimal

    //Funktion um das aktuell ausgewählte Animal zu setzen
    fun setCurrentAnimal(animal: Animal) {
        _currentAnimal.postValue(animal)
    }

    //Funktion um den Status eines Tieres zu ändern, ob dieses geliket ist oder nicht.
    //Danach wird _currentAnimal durch die postValue Funktion überschrieben und der Observer im
    //DetailFragment getriggert
    fun changeLikedStatus(animal: Animal) {
        animal.isLiked = !animal.isLiked
        Log.d("ViewModel", "${animal.isLiked}")
        _currentAnimal.postValue(animal)
    }
}