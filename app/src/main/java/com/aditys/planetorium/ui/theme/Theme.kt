package com.aditys.planetorium.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define a custom dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF6F00), // Orange primary
    secondary = Color(0xFFBB86FC), // Purple secondary
    background = Color(0xFF121212), // Dark background
    surface = Color(0xFF1E1E1E), // Dark surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color(0xFFE0E0E0), // Light gray on dark background
    onSurface = Color(0xFFE0E0E0) // Light gray on surface
)

// Define Typography (using the default unless customized)
private val PlanetTypography = Typography()

@Composable
fun PlanetoriumTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PlanetTypography,
        content = content
    )
}
