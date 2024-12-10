package com.example.mvvmretofit.Utils

import com.example.mvvmretofit.Model.EmployeeModel
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/employees")
    suspend fun getEmployees():EmployeeModel
}