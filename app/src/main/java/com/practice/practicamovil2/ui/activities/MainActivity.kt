package com.practice.practicamovil2.ui.activities

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.practicamovil2.R
import com.practice.practicamovil2.ui.adapters.GameAdapter
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private val vm: MainViewModel by viewModel()
    private var job: Job = Job()
    val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch { fillList() }
        buildRecyclerView()

    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    suspend fun fillList(){
        vm.fill()
    }

    //Settea las reparaciones a la lista repairs
    private fun buildRecyclerView(){
        recycler = findViewById(R.id.recyclerView)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
        gameAdapter= GameAdapter(vm.allGamesList.value!!)
        recycler.adapter = gameAdapter
    }
}