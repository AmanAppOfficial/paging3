package com.example.myretrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MainActivity: AppCompatActivity() {


    lateinit var factory: GithubDataSourceFactory
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recydler_list);
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        adapter = MyAdapter()
        recyclerView.setAdapter(adapter)
        factory = GithubDataSourceFactory()
        CoroutineScope(IO).launch {
            factory.getGithubData().collect { list ->
                adapter.submitData(list)
            }
        }
    }
}