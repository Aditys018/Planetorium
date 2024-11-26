package com.aditys.planetorium.userinterface

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aditys.planetorium.R
import kotlinx.coroutines.delay


@Composable
fun PlanetListScreen(navController: NavController) {
    val planets = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    val selectedPlanet = remember { mutableStateOf<String?>(null) }

    val planetImages = mapOf(
        "Mercury" to R.drawable.mercury_image,
        "Venus" to R.drawable.venus_image,
        "Earth" to R.drawable.earth_image,
        "Mars" to R.drawable.mars_image,
        "Jupiter" to R.drawable.jupiter_image,
        "Saturn" to R.drawable.saturn_image,
        "Uranus" to R.drawable.uranus_image,
        "Neptune" to R.drawable.neptune_image
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010)),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp, top = 40.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "PLANETS",
                    color = Color(0xFFE5734F),
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            planets.forEach { planet ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            selectedPlanet.value = planet

                        }
                        .let {
                            if (planet == selectedPlanet.value) {
                                it
                                    .background(Color.Transparent)
                                    .border(0.5.dp, Color(0xFFE5734F), shape = CircleShape)
                                    .padding(8.dp)
                            } else {
                                it
                            }
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = planet,
                        color = Color(0xFFE5734F),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = if (planet == selectedPlanet.value) 30.sp else 18.sp
                        )
                    )

                    selectedPlanet.value?.let { selected ->
                        if (planet == selected) {
                            planetImages[planet]?.let { imageRes ->
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = "$planet image",
                                    modifier = Modifier
                                        .size(120.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    selectedPlanet.value?.let { planet ->
        LaunchedEffect(planet) {
            delay(1000)
            navController.navigate("planetDetail/$planet")
        }
    }
}
