package com.example.firebasestorage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.ui.theme.Blue
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import com.example.firebasestorage.ui.theme.blu

class ServiceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    services()

            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun services(){

    val mContext = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()){

        TopAppBar(title = { Text(text = "LAUNDRY SERVICES", fontWeight = FontWeight.ExtraBold, color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(blu),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription ="" ,
                        tint = Color.White)

                }



            },
            actions = {
                IconButton(onClick = {  val shareIntent= Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "https://qinetralaundry.com/")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share")) }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { val settingsIntent= Intent(Settings.ACTION_SETTINGS)
                    mContext.startActivity(settingsIntent) }) {
                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "",
                        tint = Color.White
                    )


                }
            }

        )

        Spacer(modifier = Modifier.height(5.dp))

        //Vertical scroll
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())) {}

        //Home icon
        val context = LocalContext.current
        Button(
            onClick = {(Intent(context, HomeScreen::class.java)) },
            colors = ButtonDefaults.buttonColors(Blue),
            shape = CutCornerShape(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "",
                tint = Color.White
            )

            Text(text = "HOME", color = Color.White)
        }


        //create a row
        Row(modifier = Modifier
            .padding(start = 10.dp)
            .horizontalScroll(rememberScrollState())) {
            Column {
                Card(
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Household",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(
                    text = "Household Laundry",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(
                    text = "Ksh150/Kilogram",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(
                        onClick = {
                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                        },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            tint = Color.White
                        )

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }

            Spacer(modifier = Modifier.width(50.dp))

            //2nd Column
            Column {
                Card(
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Commercial",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(
                    text = "Commercial Laundry",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(
                    text = "Ksh200/Kilogram",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(
                        onClick = {
                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                        },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            tint = Color.White
                        )

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        Text(text = "Dry Cleaning Services",
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(blu)
                .height(45.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )


        Spacer(modifier = Modifier.height(5.dp))

        Row(modifier = Modifier
            .padding(start = 10.dp)
            .horizontalScroll(rememberScrollState())) {
            Column {
                Card(modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.suit ),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)

                        Text(text = "SUITS",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(text = "Suits",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(text = "Ksh700/suit",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(onClick = {  val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ShoppingCart ,
                            contentDescription = "",
                            tint = Color.White)

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }

            Spacer(modifier = Modifier.width(50.dp))

            //2nd Column
            Column {
                Card(modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.duvet ),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)

                        Text(text = "DUVETS",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(text = "Duvet",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(text = "Ksh900",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(onClick = {  val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ShoppingCart ,
                            contentDescription = "",
                            tint = Color.White)

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }

            Spacer(modifier = Modifier.width(50.dp))

            //3rd Column
            Spacer(modifier = Modifier.width(50.dp))

            Column {
                Card(modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.dress ),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)

                        Text(text = "DRESS",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(text = "Dress",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(text = "Ksh600",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(onClick = {  val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ShoppingCart ,
                            contentDescription = "",
                            tint = Color.White)

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }

            Spacer(modifier = Modifier.width(50.dp))

            //4th column
            Column {
                Card(modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)){
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.shirt ),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)

                        Text(text = "SHIRT",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )


                    }

                }

                Text(text = "Shirts",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                Text(text = "Ksh200",
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Row {
                    Button(onClick = {  val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                    },
                        colors = ButtonDefaults.buttonColors(Blue),
                        shape = CutCornerShape(5.dp)
                    ) {
                        Icon(imageVector = Icons.Default.ShoppingCart ,
                            contentDescription = "",
                            tint = Color.White)

                        Text(text = "PAY", color = Color.White)
                    }
                }

            }

        }
    }

}

class HomeScreen {

}


@Preview(showBackground = true)
@Composable
fun servicesPreview() {

    services()

}
