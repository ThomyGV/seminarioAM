package com.example.dune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dune.ui.theme.DuneTheme

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.CheckBox
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {

    lateinit var btnCrearUsuario: Button
    lateinit var btnIniciarSesion: Button
    lateinit var etUsuario: EditText
    lateinit var etContraseña: EditText
    lateinit var cbChequeo: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        registroExitoso()

        etUsuario = findViewById(R.id.usuario)
        etContraseña = findViewById(R.id.contraseña)
        cbChequeo = findViewById(R.id.chequeo)

        btnCrearUsuario = findViewById(R.id.crearUsuario)
        btnCrearUsuario.setOnClickListener {
            //pasa a la activity Registro y crea un usuario nuevo
            val intentRegistro = Intent(this, Registro::class.java)
            startActivity(intentRegistro)
        }

        btnIniciarSesion = findViewById(R.id.iniciarSesion)
        btnIniciarSesion.setOnClickListener{
            //intentara pasar a la activity de datos propiamente dicha

            // primero verifica que haya datos en los campos de ingreso, usuario y password
            var mensaje = "Inicio de Sesion"

            //var nombreUsuario = etUsuario.text.toString()

            if(etUsuario.text.toString().isEmpty() || etContraseña.text.toString().isEmpty()){
                //mensaje+= ". Faltan Datos"
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_LONG).show()
            }else {

                // Verificamos si esta tildado el CechBox
                if(cbChequeo.isChecked)
                    mensaje+= "- Recordar Usuario"

                //ENTREGA 2 - Aca se realizara el chequeo del usuario y password
                //sitodo esta bien, entra a la activity que muestra el contenido en si

                // Indicamos a que pantalla queremos ir
                val intentLista = Intent(this, ListaLibros::class.java)

                // Cambiamos de activity
                startActivity(intentLista)
                finish()//cierra la actividad actuual

            }

        }

    }

    private fun registroExitoso() {
        // Obtengo los datos que me mandaron
        var bundle: Bundle? = intent.extras
        // Reviso que efectivamente tenga datos
        if(bundle != null){
            // Obtengo el dato especifico
            var mensaje = bundle?.getString("mensaje")
            // Muestro el mensaje
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

}