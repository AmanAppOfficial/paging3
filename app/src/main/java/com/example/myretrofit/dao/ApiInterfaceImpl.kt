package com.example.myretrofit.dao


object ApiInterfaceImpl {
    fun getApi(): ApiInterface {
        val retrofitObj = RetrofitBuilder.build()
        return retrofitObj.create(ApiInterface::class.java)
    }
}