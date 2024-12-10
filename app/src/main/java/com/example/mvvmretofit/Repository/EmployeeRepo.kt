package com.example.mvvmretofit.Repository

import com.example.mvvmretofit.Model.EmployeeModel
import com.example.mvvmretofit.Utils.RetrofitObject

class EmployeeRepo
{
private val apiService = RetrofitObject.apiService

    suspend fun getEmployee(): EmployeeModel{
        return apiService.getEmployees();
    }
}