package com.example.androidcapstone.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.R
import com.example.androidcapstone.model.datasource.authentication.FirebaseAuthenticationManager
import com.example.androidcapstone.model.datasource.authentication.user.UserLogin
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FirebaseUser

class LoginViewModel : ViewModel(), FirebaseAuthenticationManager.IFirebaseAuthManager {

    private val callbackManager : CallbackManager = CallbackManager.Factory.create()
    private val authManager : FirebaseAuthenticationManager = FirebaseAuthenticationManager(this)
    private lateinit var userLogin : UserLogin

    val userEmailText : MutableLiveData<String> = MutableLiveData()
    val userPasswordText : MutableLiveData<String> = MutableLiveData()
    val userPasswordConfirmText : MutableLiveData<String> = MutableLiveData()
    val userDisplayNameText : MutableLiveData<String> = MutableLiveData()
    val user : MutableLiveData<FirebaseUser> = MutableLiveData()
    val createAccount : MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()

    init{
        registerFacebookCallback()
        createAccount.value = false
        userEmailText.value = ""
        userPasswordText.value = ""
        userPasswordConfirmText.value = ""
        userDisplayNameText.value = ""
    }

    fun getCurrentUser() : FirebaseUser? = authManager.mAuth.currentUser

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    fun onLoginClicked(view : View){
        //TODO make more sophisticated password check
        when(view.id){
            R.id.btnLogin -> {
                if(userEmailText.value!!.isNotEmpty() && userPasswordText.value!!.isNotEmpty()){
                    userLogin = UserLogin(userEmailText.value!!,userPasswordText.value!!)
                    authManager.signInToFirebaseAccount(userLogin)
                }
            }
            R.id.btnCreateAccount -> {
                if(createAccount.value!!){
                    if(userEmailText.value!!.isNotEmpty() && userPasswordText.value!!.isNotEmpty() &&
                        userPasswordConfirmText.value!!.isNotEmpty() && userDisplayNameText.value!!.isNotEmpty()) {
                        if(userPasswordText.value == userPasswordConfirmText.value) {
                            userLogin = UserLogin(userEmailText.value!!, userPasswordText.value!!)
                            authManager.createFirebaseAccount(
                                userLogin,
                                userDisplayNameText.value!!
                            )
                        } else {
                            sendError("Passwords do not match")
                        }
                    }
                }
                else{
                    createAccount.postValue(true)
                }
            }
            R.id.btnGuest -> {
                authManager.signInAnonymously()
            }
        }
    }


    private fun registerFacebookCallback(){
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    authManager.handleFacebookAccessToken(loginResult.accessToken)
                }
                override fun onCancel() {}
                override fun onError(exception: FacebookException) { Log.e("FB_CALLBACK", "Error: ", exception) }
            })
    }

    override fun onSignInUser(user: FirebaseUser?) {
        if(user != null)
            this.user.postValue(user)
        else
            errorMessage.postValue("Email or Password is incorrect")
    }

    override fun sendError(error: String) {
        errorMessage.postValue(error)
    }

}