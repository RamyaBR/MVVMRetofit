package com.example.mvvmretofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretofit.ViewModel.EmployeeVM
import com.example.mvvmretofit.ui.theme.MVVMRetofitTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: EmployeeVM
    private lateinit var someData: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMRetofitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    viewModel= ViewModelProvider(this)[EmployeeVM::class.java]
                    viewModel.loadEMP()
                    viewModel.emp.observe(this, Observer {
                        someData = it.data.toString()
                        Toast.makeText(this,someData, Toast.LENGTH_SHORT).show()
                    })

                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMRetofitTheme {
        Greeting("Android")
    }
}