package com.abanapps.weatherapp.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abanapps.colors.backgroundGradientOne
import com.abanapps.colors.backgroundGradientTwo
import com.abanapps.weatherapp.kmp.presentation.App
import com.abanapps.weatherapp.kmp.presentation.utils.customFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Rawalpindi",
                            fontFamily = customFont(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "ic_down",
                            tint = Color.White
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = "ic_location",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "ic_notification",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                windowInsets = WindowInsets(0.dp)
            )

        },
        modifier = Modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(
                    backgroundGradientTwo,
                    backgroundGradientOne,
                )
            )
        ),
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 14.dp, vertical = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {


            Spacer(modifier = Modifier.weight(.5f))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(180.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF7FC3F3)),
                    shape = RoundedCornerShape(8.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            "Today September 12 2025",
                            color = Color.White,
                            fontFamily = customFont(),
                            fontSize = 20.sp
                        )

                        Box(modifier = Modifier) {

                            Text(
                                "29 ",
                                fontSize = 26.sp,
                                color = Color.White,
                                fontFamily = customFont()
                            )
                            Text(
                                "°",
                                modifier = Modifier.align(Alignment.TopEnd),
                                fontFamily = customFont(),
                                fontSize = 18.sp,
                                color = Color.White
                            )

                        }

                        Text(
                            "Cloudy",
                            color = Color.White,
                            fontFamily = customFont(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )


                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.ic_wind),
                                contentDescription = "ic_wind",
                                modifier = Modifier.size(28.dp)
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            Text(
                                "Wind",
                                fontFamily = customFont(),
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.size(14.dp))

                            Spacer(
                                modifier = Modifier
                                    .width(2.dp)
                                    .padding(vertical = 7.dp)
                                    .background(Color.White)
                                    .fillMaxHeight()

                            )

                            Spacer(modifier = Modifier.size(14.dp))

                            Text(
                                "10 km/h",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = customFont(),
                                color = Color.White,
                                fontSize = 17.sp
                            )

                        }

                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.ic_humidity),
                                contentDescription = "ic_wind",
                                modifier = Modifier.size(28.dp)
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            Text(
                                "Hum",
                                fontFamily = customFont(),
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.size(14.dp))

                            Spacer(
                                modifier = Modifier
                                    .width(2.dp)
                                    .padding(vertical = 7.dp)
                                    .background(Color.White)
                                    .fillMaxHeight()

                            )

                            Spacer(modifier = Modifier.size(14.dp))

                            Text(
                                "54 %",
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = customFont(),
                                color = Color.White,
                                fontSize = 17.sp
                            )

                        }


                    }


                }

            }

            Spacer(modifier = Modifier.weight(1f))

        }


    }

}


