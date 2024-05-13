package com.example.myretrofit;

import android.os.Bundle;
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myretrofit.model.Git
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity: AppCompatActivity() {


    lateinit var factory: GithubDataSourceFactory
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recydler_list);
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        adapter = MyAdapter()
        recyclerView.setAdapter(adapter)
        factory = ViewModelProvider(this)[GithubDataSourceFactory::class.java]
        CoroutineScope(IO).launch {
            factory.getGithubData().collect {
                list ->
                adapter.submitData(list)
            }
        }

        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            factory.add(Git("www.aman.com", 101))
        }



    }
}