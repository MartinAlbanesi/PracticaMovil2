package com.practice.practicamovil2.ui.activities

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.practicamovil2.R
import com.practice.practicamovil2.domain.model.APIGameModel
import com.practice.practicamovil2.injectDependencies.remoteRepositoryModule
import com.practice.practicamovil2.ui.adapters.GameAdapter
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules


class MainActivity : AppCompatActivity() {

    //init { loadKoinModules(remoteRepositoryModule) }

    private lateinit var recycler: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private val vm: MainViewModel by viewModel()
    lateinit var lista: List<APIGameModel>
    //private lateinit var toast: Toast

/*
    private val errorMessageObserver = Observer<String> { status ->
        toast.setText(status)
        toast.show()
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //vm.errorMessage.observe(this, errorMessageObserver)



        lifecycleScope.launch {
            Log.d("MainActivity","Entró al launch del método fill()")
            vm.fill()
            Log.d("MainActivity","Se ejecutó el launch del metodo fill()")
        }

        buildRecyclerView()

    }

    //Settea las reparaciones a la lista repairs
    private fun buildRecyclerView(){
        Log.d("MainActivity","Entró al método de build del recycler")
        recycler = findViewById(R.id.recyclerView)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        gameAdapter= GameAdapter(vm.allGamesList)
        recycler.adapter = gameAdapter
        Log.d("MainActivity","Se creo el recyclerView")
    }
}