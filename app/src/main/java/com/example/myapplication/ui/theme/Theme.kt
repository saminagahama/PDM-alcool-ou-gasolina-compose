package com.example.myapplication.ui.theme

import android.app.Activity
import android.graphics.fonts.FontFamily
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.R


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF67697C),
    secondary = Color(0xFF67697C),
    tertiary = Color(0xFF67697C),
    background = Color(0xFF1B1E3C),
    surface = Color(0xFF424242),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFD1D2E9),
    secondary = Color(0xFFD1D2E9),
    tertiary = Color(0xFFD1D2E9),
    background = Color(0xFFD1D2E9),
    surface = Color(0xFFD1D2E9),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)



@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val darkTheme = isSystemInDarkTheme()
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

