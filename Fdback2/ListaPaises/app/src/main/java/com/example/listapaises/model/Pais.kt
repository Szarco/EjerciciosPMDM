package com.example.listapaises.model

import java.io.Serializable

class Pais(var nombre:String, val poblacion:Int):Serializable{
    override fun toString(): String {
        return nombre
    }
}