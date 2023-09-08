package com.curso.android.app.trabajofinal.trabajofinal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.curso.android.app.trabajofinal.trabajofinal.ViewModel.ComparaViewModel
import com.curso.android.app.trabajofinal.trabajofinal.Model.ComparaModel
import com.curso.android.app.trabajofinal.trabajofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val comparaViewModel : ComparaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






        binding.button.setOnClickListener{
            comparaViewModel.setPalabra1(binding.editTextText.text.toString())
            comparaViewModel.setPalabra2(binding.editTextText2.text.toString())
            comparaViewModel.compararCadenas()
        }

        comparaViewModel.comparaModel.observe(this, Observer {

            binding.textView3.text= if (it.iguales) "Las cadenas son iguales" else "Las cadenas son diferentes"})


    }
}