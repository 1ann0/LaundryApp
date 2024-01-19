package com.example.firebasestorage.screens.signup

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.data.AuthViewModel
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.navigation.ROUT_SIGNUP
import com.example.firebasestorage.R
import com.example.firebasestorage.ServiceActivity
import com.example.firebasestorage.screens.login.LoginScreen
import com.example.firebasestorage.ui.theme.Blue
import com.example.firebasestorage.ui.theme.blu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController) {
    var mContext = LocalContext.current
    var firstname by remember { mutableStateOf(TextFieldValue("")) }
    var surname by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }


        //TopAppBar
        TopAppBar(title = { Text(text = "Create an account")},
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },
            actions = {
                IconButton(onClick = {
                    val shareIntent=Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                }) {
                    Icon(imageVector = Icons.Filled.Share , contentDescription = "share")
                }
                IconButton(onClick = {
                    val settingsIntent=Intent(Settings.ACTION_SETTINGS)
                    mContext.startActivity(settingsIntent)
                }) {
                    Icon(imageVector = Icons.Filled.Settings , contentDescription = "settings")
                }
            },
            backgroundColor = blu)


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
                label = { Text(text = "Firstname")},
                placeholder = { Text(text = "Enter firstname")},
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = surname ,
                onValueChange = {surname=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Surname")},
                placeholder = { Text(text = "Enter Surname")},
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = username ,
                onValueChange = {username=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Username")},
                placeholder = { Text(text = "Enter username")},
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = email ,
                onValueChange = {email=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Email Address")},
                placeholder = { Text(text = "Enter email")},
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = password ,
                onValueChange = {password=it},
                shape = CutCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Password")},
                placeholder = { Text(text = "Type your password")},
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

        }

        Button(onClick = {
            // HANDLE SIGNUP LOGIC //
            var xyz = AuthViewModel(navController, mContext)
            xyz.signup(email.text.trim(),password.text.trim())
        },
            colors = androidx.compose.material.ButtonDefaults.buttonColors(blu),
            modifier = Modifier.width(300.dp),
            shape = CutCornerShape(5.dp)) {
            Text(text = "Register")
        }

            Text(text = "Have account? Login",
                modifier = Modifier.clickable {
                    navController.navigate(ROUT_LOGIN)
                },
                fontSize = 15.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}