package com.example.testpokeon.Utils

class ValidateName {

    fun getInitialName(name: String): String{
        val words = name.split(" ")
        val initials = StringBuilder()

        for (word in words) {
            if (word.isNotEmpty()) {
                initials.append(word[0].toUpperCase())
            }
        }

        return initials.toString()
    }

    fun validateFirstLetter(cadena: String): Boolean {
        if (cadena.isNotEmpty()) {
            val primerCaracter = cadena[0]
            return !primerCaracter.isLetter() || primerCaracter.isDigit()
        }
        return false
    }
}