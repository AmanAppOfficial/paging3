package com.example.myretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.model.Git

class MyAdapter: PagingDataAdapter<Git, MyAdapter.MyViewHolder>(MyDiffCallBack()) {

    class MyDiffCallBack : DiffUtil.ItemCallback<Git>() {
        override fun areItemsTheSame(oldItem: Git, newItem: Git): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Git, newItem: Git): Boolean {
            return oldItem.repository_url == newItem.repository_url
        }
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        companion object {
            //get instance of the DoggoImageViewHolder
            fun getInstance(parent: ViewGroup): MyViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item, parent, false)
                return MyViewHolder(view)
            }
        }

        private var txt: TextView = view.findViewById(R.id.txt)
        fun bind(item: String?) {
            txt.text = item
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item?.repository_url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.getInstance(parent)
    }
}