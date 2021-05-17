package com.example.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavHost

class MainActivity : AppCompatActivity() {

    private val FormViewModel : FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtengo el fragmento
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_fragment) as NavHost
        //Del fragmento obtengo la navegación
        val navController = navHostFragment.navController

        FormViewModel.current.observe(this){
            navController.navigate(FormViewModel.getCurrentPage())
        }
    }
}