package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.firebasestorage.navigation.ROUT_HOME
import com.example.firebasestorage.navigation.ROUT_SIGNUP
import com.example.firebasestorage.ui.theme.FirebasestorageTheme

class LocationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            googleMap()
        }
    }
}

@Composable
fun googleMap(){

    val mContext= LocalContext.current

    Column (modifier = Modifier.fillMaxSize()){

        //TopAppBar
        TopAppBar(title = { androidx.compose.material.Text(text = "Location") },
            navigationIcon = {
                IconButton(onClick = {
                        mContext.startActivity(Intent(mContext, ROUT_HOME::class.java))
                }) {
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
            backgroundColor = Color.Green)

        //WebView

        val mUrl="https://maps.google.com/maps"
        AndroidView(factory = {
            WebView(it).apply {
                settings.javaScriptEnabled=true
                layoutParams=ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient= WebViewClient()
                loadUrl(mUrl)
            }
        })

    }

}


@Preview(showBackground = true)
@Composable
fun googleMapPreview(){
    googleMap()

}
