package com.example.dune

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var titulos = arrayOf("Dune","EL Mesias de Dune", "Hijos de Dune", "Dios Emperador de Dune", "Herejes de Dune", "Casa Capitular Dune")
    var autores = arrayOf("Frank Herbert", "Frank Herbert", "Frank Herbert", "Frank Herbert", "Frank Herbert", "Frank Herbert")
    var imagenes = intArrayOf(R.drawable.libro01, R.drawable.libro02,R.drawable.libro03,R.drawable.libro04,R.drawable.libro05,R.drawable.libro06)



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitulo.text = titulos[i]
        viewHolder.itemAutor.text = autores[i]
        viewHolder.itemImage.setImageResource(imagenes[i])

        //click
        //hasta aca
    }

    override fun getItemCount(): Int {
        return titulos.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitulo: TextView
        var itemAutor: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitulo = itemView.findViewById(R.id.item_titulo)
            itemAutor = itemView.findViewById(R.id.item_autor)
        }

    }


}