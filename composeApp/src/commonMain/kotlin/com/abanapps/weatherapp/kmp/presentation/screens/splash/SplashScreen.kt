package com.abanapps.weatherapp.kmp.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.abanapps.colors.backgroundGradientOne
import com.abanapps.colors.backgroundGradientTwo
import com.abanapps.colors.buttonColor
import com.abanapps.weatherapp.kmp.presentation.navGraph.Routes
import com.abanapps.weatherapp.kmp.presentation.utils.customFontPoppins
import org.jetbrains.compose.resources.painterResource
import weatherappkmp.composeapp.generated.resources.Res
import weatherappkmp.composeapp.generated.resources.logo

@Composable
fun SplashScreen(navController: NavController,modifier: Modifier = Modifier,) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            backgroundGradientTwo,
                            backgroundGradientOne,
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(.5f))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Image(
                    painter = painterResource(Res.drawable.logo), contentDescription = "logo",
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.CenterHorizontally),
                )

                Column {
                    Text(
                        text = "Weather",
                        fontFamily = customFontPoppins(),
                        fontSize = 52.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        "ForeCast", fontFamily = customFontPoppins(),
                        fontSize = 52.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }


                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    ElevatedButton(
                        onClick = {
                            navController.navigate(Routes.HomeScreen)
                        },
                        colors = ButtonDefaults.buttonColors(buttonColor),
                        shape = CircleShape,
                        modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 12.dp)
                    ) {

                        Text("Let's Go", fontFamily = customFontPoppins(), fontSize = 22.sp)

                    }
                }

            }

            Spacer(modifier = Modifier.weight(.5f))


        }




}