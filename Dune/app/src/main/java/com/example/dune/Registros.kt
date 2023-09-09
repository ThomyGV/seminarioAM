package com.example.dune

import androidx.room.ColumnInfo
import androidx.room.Entity

//De forma predeterminada, Room usa el nombre de la clase como el nombre de la tabla de la base de datos.
@Entity(primaryKeys = ["usuario", "password"])
data class Registros(
    @ColumnInfo(name = "usuario") var usuario:String,
    @ColumnInfo(name = "password") var password:String
)
