package com.example.androidcapstone.model.datasource.authentication

import android.util.Log
import com.example.androidcapstone.model.datasource.authentication.user.UserLogin
import com.facebook.AccessToken
import com.google.firebase.auth.*
import java.lang.Exception

class FirebaseAuthenticationManager(var callback: IFirebaseAuthManager) {

    var mAuth : FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()
    }


    fun signInToFirebaseAccount(userLogin: UserLogin){
        mAuth = FirebaseAuth.getInstance()
        val email = userLogin.email
        val password = userLogin.password
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAB_FB", "signInWithEmail:success")
                    val user = mAuth.currentUser
                    callback.onSignInUser(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG_FB", "signInWithEmail:failure", task.exception)
                    try{
                        throw task.exception as Throwable
                    } catch(e : Exception) {
                        callback.sendError(e.toString().substringAfter(":"))
                    }
                }
            }
    }

    fun createFirebaseAccount(userLogin: UserLogin, displayName : String){
        val email = userLogin.email
        val password = userLogin.password

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG_FB", "createUserWithEmail:success")
                    val user = mAuth.currentUser
                    val profileUpdate = UserProfileChangeRequest.Builder().setDisplayName(displayName).build()
                    user!!.updateProfile(profileUpdate)
                    signInToFirebaseAccount(userLogin)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG_FB", "createUserWithEmail:failure", task.exception)
                    try{
                        throw task.exception as Throwable
                    } catch(e : Exception) {
                        callback.sendError(e.toString().substringAfter(":"))
                    }
                }
            }
    }

    fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("TAG_HANDLE", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG_HANDLE", "signInWithCredential:success")
                    val user = mAuth.currentUser
                    callback.onSignInUser(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG_HANDLE", "signInWithCredential:failure", task.exception)
                    callback.onSignInUser(null)
                }
            }
    }

    fun signInAnonymously(){
        mAuth.signInAnonymously().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("TAG_HANDLE", "signInAnonymously:success")
                val user = mAuth.currentUser
                callback.onSignInUser(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("TAG_HANDLE", "signInAnonymously:failure", task.exception)
                callback.onSignInUser(null)
            }
        }
    }

    interface IFirebaseAuthManager {
        fun onSignInUser(user : FirebaseUser?)
        fun sendError(error : String)
    }
}