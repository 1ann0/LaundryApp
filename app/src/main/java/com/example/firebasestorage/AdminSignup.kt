package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import com.example.firebasestorage.ui.theme.blu

class AdminSignup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            signup()
        }
    }
}

@Composable
fun signup(){
    var mContext = LocalContext.current
    var firstname by remember { mutableStateOf(TextFieldValue("")) }
    var surname by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }


    //TopAppBar
    TopAppBar(title = { androidx.compose.material.Text(text = "Create an account") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
            }
        },
        actions = {
            IconButton(onClick = {
                val shareIntent= Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

            }) {
                Icon(imageVector = Icons.Filled.Share , contentDescription = "share")
            }
            IconButton(onClick = {
                val settingsIntent= Intent(Settings.ACTION_SETTINGS)
                mContext.startActivity(settingsIntent)
            }) {
                Icon(imageVector = Icons.Filled.Settings , contentDescription = "settings")
            }
        },
        backgroundColor = blu
    )


    Spacer(modifier = Modifier.height(20.dp))

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {


        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.laundrymachine))
        val progress by animateLottieCompositionAsState(composition )

        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp))

        //Textfields
        Column(modifier = Modifier.padding(20.dp)) {

            OutlinedTextField(value = firstname ,
                onValueChange = {firstname=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { androidx.compose.material.Text(text = "Firstname") },
                placeholder = { androidx.compose.material.Text(text = "Enter firstname") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = surname ,
                onValueChange = {surname=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { androidx.compose.material.Text(text = "Surname") },
                placeholder = { androidx.compose.material.Text(text = "Enter Surname") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = username ,
                onValueChange = {username=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { androidx.compose.material.Text(text = "Username") },
                placeholder = { androidx.compose.material.Text(text = "Enter username") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = email ,
                onValueChange = {email=it},
                shape = CutCornerShape(5.dp),
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
                shape = CutCornerShape(5.dp),
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
            androidx.compose.material.Text(text = "Register")
        }

        androidx.compose.material.Text(text = "Have account? Login",
            modifier = Modifier.clickable {
            },
            fontSize = 15.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun AdminSignupPreview() {
    signup()
}