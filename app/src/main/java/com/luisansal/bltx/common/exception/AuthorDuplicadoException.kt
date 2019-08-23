package com.luisansal.bltx.common.exception

import com.luisansal.bltx.model.domain.Author


class AuthorDuplicadoException(val author : Author) : Exception("Author ${author.nombre} con DNI ${author.dni} duplicado ") {
}