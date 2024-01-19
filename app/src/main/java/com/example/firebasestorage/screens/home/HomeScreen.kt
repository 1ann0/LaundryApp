package com.example.firebasestorage.screens.home

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.AdminLoginActivity
import com.example.firebasestorage.InsertActivity
import com.example.firebasestorage.LocationActivity
import com.example.firebasestorage.ServiceActivity
import com.example.firebasestorage.R
import com.example.firebasestorage.navigation.ROUT_CONTACT
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.navigation.ROUT_SIGNUP
import com.example.firebasestorage.screens.login.LoginScreen
import com.example.firebasestorage.ui.theme.blu

@Composable
fun HomeScreen(navController:NavHostController) {
        var mContext = LocalContext.current
        Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

                //TopAppBar
                TopAppBar(
                        title = { Text(text = "Home") },
                        navigationIcon = {
                                IconButton(onClick = { }) {
                                        Icon(
                                                imageVector = Icons.Filled.ArrowBack,
                                                contentDescription = "arrowback"
                                        )
                                }
                        },
                        actions = {
                                IconButton(onClick = {
                                        val settingsIntent = Intent(Settings.ACTION_SETTINGS)
                                        mContext.startActivity(settingsIntent)
                                }) {
                                        Icon(
                                                imageVector = Icons.Filled.Build,
                                                contentDescription = "settings"
                                        )
                                }
                        },
                        backgroundColor = blu
                )


                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                        contentAlignment = Alignment.Center) {

                        Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "",
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(),
                                contentScale = ContentScale.Crop
                        )
                }

                Spacer(modifier = Modifier.height(20.dp))
                val context = LocalContext.current

                androidx.compose.material3.Button(
                        onClick = {
                                context.startActivity(
                                        Intent(
                                                context,
                                                ServiceActivity::class.java
                                        )
                                )
                        },
                        colors = ButtonDefaults.buttonColors(blu),
                        shape = RectangleShape
                )
                {
                        androidx.compose.material3.Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "",
                                tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        androidx.compose.material3.Text(
                                text = "MORE SERVICES",
                                color = Color.White
                        )

                }

                androidx.compose.material3.Button(
                        onClick = {
                                context.startActivity(
                                        Intent(
                                                context,
                                                AdminLoginActivity::class.java
                                        )
                                )
                        },
                        colors = ButtonDefaults.buttonColors(blu),
                        shape = RectangleShape
                )
                {
                        androidx.compose.material3.Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "",
                                tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        androidx.compose.material3.Text(
                                text = "ADMIN",
                                color = Color.White
                        )

                }




        }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
        HomeScreen(rememberNavController())

}

