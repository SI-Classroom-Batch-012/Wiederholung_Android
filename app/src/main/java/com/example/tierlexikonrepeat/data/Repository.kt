package com.example.tierlexikonrepeat.data

import com.example.tierlexikonrepeat.R

class Repository {

    var getAnimals: MutableList<Animal> =
        mutableListOf(
            Animal("Schneeleopard", R.drawable.leopard),
            Animal("Fuchs", R.drawable.fox),
            Animal("Luchs", R.drawable.luchs),
            Animal("Panda", R.drawable.panda),
            Animal("Braunbär", R.drawable.braunbaer),
            Animal("Tiger", R.drawable.tiger),
            Animal("Eichhörnchen", R.drawable.eichhoernchen),
            Animal("Nashorn", R.drawable.nashorn)
        )
}