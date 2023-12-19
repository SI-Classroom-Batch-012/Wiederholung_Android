package com.example.tierlexikonrepeat.data

import com.example.tierlexikonrepeat.R

class Repository {

    var getAnimals: MutableList<Animal> =
        mutableListOf(
            Animal("Schneeleopard", R.drawable.leopard, false),
            Animal("Fuchs", R.drawable.fox, false),
            Animal("Luchs", R.drawable.luchs, false),
            Animal("Panda", R.drawable.panda, false),
            Animal("Braunbär", R.drawable.braunbaer, false),
            Animal("Tiger", R.drawable.tiger, false),
            Animal("Eichhörnchen", R.drawable.eichhoernchen, false),
            Animal("Nashorn", R.drawable.nashorn, false)
        )
}