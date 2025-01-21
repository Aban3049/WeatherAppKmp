package com.abanapps.weatherapp.kmp.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import weatherappkmp.composeapp.generated.resources.Overpass_Black
import weatherappkmp.composeapp.generated.resources.Overpass_Bold
import weatherappkmp.composeapp.generated.resources.Overpass_Medium
import weatherappkmp.composeapp.generated.resources.Overpass_Regular
import weatherappkmp.composeapp.generated.resources.Overpass_SemiBold
import weatherappkmp.composeapp.generated.resources.Poppins_ExtraBold
import weatherappkmp.composeapp.generated.resources.Res

@Composable
fun customFont(): FontFamily {
    return FontFamily(
        Font(Res.font.Overpass_Bold, FontWeight.Bold),
        Font(Res.font.Overpass_Black, FontWeight.Black),
        Font(Res.font.Overpass_Medium, FontWeight.Medium),
        Font(Res.font.Overpass_Regular, FontWeight.Normal),
        Font(Res.font.Overpass_SemiBold, FontWeight.SemiBold),
    )
}

@Composable
fun customFontPoppins(): FontFamily {
    return FontFamily(
        Font(Res.font.Poppins_ExtraBold, FontWeight.ExtraBold),
    )
}