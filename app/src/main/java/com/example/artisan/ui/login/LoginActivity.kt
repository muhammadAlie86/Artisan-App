package com.example.artisan.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artisan.MainActivity
import com.example.artisan.R
import com.example.artisan.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val loginViewModel : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {

            val username = binding.edUser.text.toString()
            val password = binding.edPassword.text.toString()

            loginViewModel.isValid.observe(this, {
                val listIntent = Intent(this,MainActivity::class.java)
                startActivity(listIntent)
                finish()
            })

            if (username.isNotEmpty() && password.isNotEmpty()){
                loginViewModel.onClickLogin(username,password)
                val snackBar = Snackbar.make(it,getString(R.string.login_successfully),Snackbar.LENGTH_SHORT)
                snackBar.show()
            }
            else{
                val snackBar = Snackbar.make(it,getString(R.string.login_failed),Snackbar.LENGTH_SHORT)
                snackBar.show()
            }
        }
    }

}