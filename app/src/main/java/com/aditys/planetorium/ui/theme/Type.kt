package com.aditys.planetorium.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aditys.planetorium.R

// Define Montserrat FontFamily (use correct font file names)
val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_regular), // Replace with your actual font file name
    Font(R.font.montserrat_extralight)     // Add more weights if needed

)

// Define your custom typography styles with Montserrat
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MontserratFontFamily,  // Apply Montserrat here
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = MontserratFontFamily,  // Apply Montserrat here
        fontWeight = FontWeight.Bold,  // You can customize the weight here
        fontSize = 30.sp
    ),
    // Add more text styles if needed (title, label, etc.)
)
