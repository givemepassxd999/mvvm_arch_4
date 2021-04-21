package com.sample.demo.myapplication

import io.reactivex.Single


class InfoRepository {
    private val apiService = AppClientManager.retrofit.create(ApiService::class.java)
    fun loadInfo(): Single<List<Posts>> {
        return apiService.getPosts()
    }
}