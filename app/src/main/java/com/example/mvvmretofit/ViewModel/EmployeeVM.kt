package com.example.mvvmretofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretofit.Model.EmployeeModel
import com.example.mvvmretofit.Repository.EmployeeRepo
import kotlinx.coroutines.launch

class EmployeeVM : ViewModel() {

    private val repo = EmployeeRepo()

    private val _emp = MutableLiveData<EmployeeModel>()

    val emp : LiveData<EmployeeModel>
            get() = _emp

    fun loadEMP(){
        viewModelScope.launch {
            val result = repo.getEmployee()
            _emp.postValue(result)
        }
    }
}