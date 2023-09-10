package com.example.dune

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegistrosDao {
    @Query("select * from Registros")//aca uso la clase como nombre de la tabla
    fun getAll(): List<Registros>

    @Query("select usuario from Registros")//aca uso la clase como nombre de la tabla
    fun getUsuario(usuario : String): Boolean

    @Insert
    fun insertRegistro(registro: Registros)
}