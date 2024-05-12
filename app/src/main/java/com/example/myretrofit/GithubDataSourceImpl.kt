package com.example.myretrofit

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.myretrofit.model.Git
import kotlinx.coroutines.flow.Flow

class GithubDataSourceFactory{

    private val PAGE_SIZE = 10


    fun getGithubData(): Flow<PagingData<Git>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, maxSize = 50),
            pagingSourceFactory = {GithubDataSource()}
        ).flow
    }

}