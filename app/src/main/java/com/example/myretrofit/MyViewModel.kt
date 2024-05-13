package com.example.myretrofit

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myretrofit.model.Git
import kotlinx.coroutines.flow.Flow

class GithubDataSourceFactory: ViewModel(){

    private var item= ArrayList<Git>()
    private val PAGE_SIZE = 1

     private var source: GithubDataSource? = null
        private fun getSource(): GithubDataSource?{
            if (source == null || source?.invalid == true)
                source = GithubDataSource(item)
            return source
        }


    fun getGithubData(): Flow<PagingData<Git>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, maxSize = 50),
            pagingSourceFactory = {getSource()!!}
        ).flow
    }


    fun add(git: Git) {
        item.add(git)
        getSource()?.invalidate()
    }



}