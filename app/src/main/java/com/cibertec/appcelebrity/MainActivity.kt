package com.cibertec.appcelebrity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.cibertec.appcelebrity.adapter.AdapterCel
import com.cibertec.appcelebrity.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listado = DataCelebrity.listCelebrity.toMutableList()
    private lateinit var adaptador : AdapterCel
    private var llManager = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mostrarData()

        //agregar nueva celebridad
        binding.btnAdd.setOnClickListener {
            agregar()
        }

        //filtrar

        binding.etFilter.addTextChangedListener {texto ->
        var listaFiltered =   listado.filter { it.nombre.lowercase().contains(texto.toString().lowercase()) }.toMutableList()
        adaptador.updateLista(listaFiltered)
        }
    }
    fun mostrarData(){
        adaptador = AdapterCel(listado,{
            mostrarToask("El actor es "+ it.nombre )
        },{
            eliminar(it)
        })

        val recycler =  binding.rvGeneral
        recycler.adapter = adaptador
        recycler.layoutManager = llManager
    }

    fun mostrarToask(mensaje:String){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
    }

    fun eliminar(pos: Int){
        listado.removeAt(pos)
       adaptador.notifyItemRemoved(pos)
    }

    fun agregar(){
        val num = listado.count()-3
        listado.add(num, Celebrity(
            "Will Smith",
            "will_smith@gmail.com",
            "https://es.web.img3.acsta.net/c_310_420/pictures/17/02/08/16/50/452749.jpg"
        )
        )

        //actualizar data en el adapter localizadamente
        adaptador.notifyItemInserted(num)
        //para ir al punto donde se agrega y el padding de 50
        llManager.scrollToPositionWithOffset(num,50)

    }

}