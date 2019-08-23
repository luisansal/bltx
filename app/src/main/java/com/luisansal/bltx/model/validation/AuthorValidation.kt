package com.luisansal.bltx.model.validation

import com.luisansal.bltx.model.domain.Author

class AuthorValidation {
    companion object{
        fun dniCorrecto(dni : String) : Boolean{
            return (dni.length == 7)
        }

        fun comprobarCamposObligatorios(author: Author) : Boolean{
            if (author.dni.isEmpty())
                return false
            if (author.nombre.isEmpty())
                return false
            if (author.apellido.isEmpty())
                return false
            return true
        }
    }

}