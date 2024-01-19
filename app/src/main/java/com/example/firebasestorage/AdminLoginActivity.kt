package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_SIGNUP
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import com.example.firebasestorage.ui.theme.blu

class AdminLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           login()
        }
    }
}

@Composable
fun login(){
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        //TopAppBar
        TopAppBar(title = { androidx.compose.material.Text(text = "Admin Login") },
            navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },
            backgroundColor = blu
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.laundrymachine))
        val progress by animateLottieCompositionAsState(composition )

        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp))

        //Textfields
        Column(modifier = Modifier.padding(20.dp)) {

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = email ,
                onValueChange = {email=it},
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { androidx.compose.material.Text(text = "Email Address") },
                placeholder = { androidx.compose.material.Text(text = "Enter email") },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = password ,
                onValueChange = {password=it},
                modifier = Modifier
                    .fillMaxWidth(),
                label = { androidx.compose.material.Text(text = "Password") },
                placeholder = { androidx.compose.material.Text(text = "Type your password") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()

            )

        }

        Button(onClick = {

        },
            colors = ButtonDefaults.buttonColors(blu),
            modifier = Modifier.width(300.dp),
            shape = CutCornerShape(5.dp)
        ) {
            androidx.compose.material.Text(text = "Login")
        }

        androidx.compose.material.Text(text = "No account? Signup",
            modifier = Modifier.clickable {

            },
            fontSize = 15.sp)

    }

}

@Preview(showBackground = true)
@Composable
fun loginPreview() {
  login()
}