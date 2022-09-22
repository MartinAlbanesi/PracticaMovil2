package com.practice.practicamovil2.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.practicamovil2.R
import com.practice.practicamovil2.domain.adapters.GameAdapter
import com.practice.practicamovil2.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    //val firstPresenter: MainApplication by inject()
    private val vm: MainViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.fill()


        buildRecyclerView()
    }

    //Settea las reparaciones a la lista repairs
    private fun buildRecyclerView(){
        recycler = findViewById(R.id.recyclerView)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        gameAdapter= GameAdapter(vm.gamesList.value!!)
        recycler.adapter = gameAdapter
    }
}