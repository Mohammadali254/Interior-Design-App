package com.example.interiordesigns.ui.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.interiordesigns.R


val CabinRegular = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Bold)
)

val SourGummyRegular = FontFamily(
    Font(R.font.sourgummy_expanded_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = CabinRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    displaySmall = TextStyle(
        fontFamily = CabinRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = CabinRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SourGummyRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)



