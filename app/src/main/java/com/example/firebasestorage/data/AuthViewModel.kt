package com.example.firebasestorage.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.navigation.ROUT_SIGNUP
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(var navController:NavHostController, var context:Context) {
    private var mAuth: FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()

    }

    fun signup(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please Email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Register successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUT_LOGIN)
                } else {
                    Toast.makeText(context, "Failed to create user", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    fun login(email: String, password: String) {

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please Email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
        } else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUT_HOME)
                }
                else{
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()

                }

            }
        }


    }


    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUT_LOGIN)
    }

    fun isLoggedIn():Boolean{
        return mAuth.currentUser != null
    }
}