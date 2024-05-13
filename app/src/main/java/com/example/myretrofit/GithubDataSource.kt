package com.example.myretrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myretrofit.dao.ApiInterface
import com.example.myretrofit.dao.ApiInterfaceImpl
import com.example.myretrofit.model.Git

class GithubDataSource(val item: ArrayList<Git>? = null): PagingSource<Int, Git>() {


    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
    lateinit var repo: ApiInterface
    val responseData = mutableListOf<Git>()

    override fun getRefreshKey(state: PagingState<Int, Git>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Git> {
        val position: Int = params.key ?: STARTING_PAGE_INDEX
        repo = ApiInterfaceImpl.getApi()
        val data = repo.getList(position).body() ?: emptyList()
//        val nk: Int = data[data.size-1].number
        responseData.addAll(data)
        item?.forEach {
            responseData.add(it)
        }


        return LoadResult.Page(
            data = responseData,
            prevKey = if (position == STARTING_PAGE_INDEX) null else -1,
            nextKey = null
        )
    }
}