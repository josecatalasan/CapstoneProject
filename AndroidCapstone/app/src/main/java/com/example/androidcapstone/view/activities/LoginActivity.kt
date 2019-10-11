package com.example.androidcapstone.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.androidcapstone.R
import com.example.androidcapstone.databinding.ActivityLoginBinding
import com.example.androidcapstone.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val loginViewModel = LoginViewModel()
    private lateinit var binder : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binder.viewModel = loginViewModel
        binder.lifecycleOwner = this

        setupObservers()

    }

    override fun onStart() {
        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = loginViewModel.getCurrentUser()
//        if(currentUser != null)
//            startActivity(Intent(this, HomeActivity::class.java))

        super.onStart()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loginViewModel.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun setupObservers(){
        loginViewModel.user.observe(this, Observer<FirebaseUser> { user ->
                val bundle = Bundle()
                bundle.putParcelable("user", user)
                intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            })

        loginViewModel.createAccount.observe(this, Observer<Boolean>{
            if(it){
                etUserPasswordConfirm.visibility = View.VISIBLE
                etUserDisplayName.visibility = View.VISIBLE
            }
        })

        loginViewModel.errorMessage.observe(this, Observer<String>{
            if(tvErrorMessage.visibility == View.GONE){
                tvErrorMessage.visibility = View.VISIBLE
            }
            tvErrorMessage.text = it
        })
    }

}
