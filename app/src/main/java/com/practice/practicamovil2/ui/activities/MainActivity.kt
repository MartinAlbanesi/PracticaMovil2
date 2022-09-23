package com.practice.practicamovil2.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.practicamovil2.R
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import com.practice.practicamovil2.ui.adapters.GameAdapter
import com.practice.practicamovil2.ui.components.ErrorMessage
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    //init { loadKoinModules(remoteRepositoryModule) }

    private lateinit var recycler: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private val vm: MainViewModel by viewModel()
    lateinit var lista: List<APIGameModel>
    private lateinit var toast: Toast


    private val errorMessageObserver = Observer<ErrorMessage> { errorMessage ->
        if (errorMessage.active) {
            toast.setText(errorMessage.message)
            toast.show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast = Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)
        setContentView(R.layout.activity_main)
        vm.errorMessage.observe(this, errorMessageObserver)
        lifecycleScope.launch {
            vm.fill()
        }

        buildRecyclerView()
    }

    //Settea las reparaciones a la lista repairs
    private fun buildRecyclerView() {
        recycler = findViewById(R.id.recyclerView)
        recycler.setHasFixedSize(true)
        recycler.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        gameAdapter = GameAdapter(vm.allGamesList)
        recycler.adapter = gameAdapter
    }
}