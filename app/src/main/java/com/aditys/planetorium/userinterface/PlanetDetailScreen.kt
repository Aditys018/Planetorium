package com.aditys.planetorium.userinterface

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aditys.planetorium.R
import com.aditys.planetorium.userinterface.DetailRow



data class PlanetDetails(
    val radius: String,
    val distanceFromSun: String,
    val moons: String,
    val gravity: String,
    val tiltOfAxis: String,
    val lengthOfYear: String,
    val lengthOfDay: String,
    val temperature: String
)


val planetDetailsMap = mapOf(
    "mercury" to PlanetDetails(
        radius = "6,371 km",
        distanceFromSun = "149.6 M.km",
        moons = "1 (Moon)",
        gravity = "9.8 m/s²",
        tiltOfAxis = "23.5°",
        lengthOfYear = "365.25 days",
        lengthOfDay = "24 hours",
        temperature = "Average 15°C"
    ),
    "venus" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "earth" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "mars" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "jupiter" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "saturn" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "uranus" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    ),
    "neptune" to PlanetDetails(
        radius = "3,390 km",
        distanceFromSun = "227.9 M.km",
        moons = "2 (Phobos, Deimos)",
        gravity = "3.7 m/s²",
        tiltOfAxis = "25.2°",
        lengthOfYear = "687 days",
        lengthOfDay = "24.6 hours",
        temperature = "Average -63°C"
    )

)



@Composable
fun PlanetDetailScreen(planetName: String) {
    val planetDetails = planetDetailsMap[planetName.lowercase()]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Canvas(
            modifier = Modifier
                .size(10000.dp)
                .offset(x = -90.dp, y = -200.dp)
        ) {
            val width = 1700f
            val height = 1900f

            drawArc(
                color = Color(0xFFE5734F),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = true,
                size = androidx.compose.ui.geometry.Size(width, height)
            )
        }

        val planetImage: Painter = when (planetName.lowercase()) {
            "mercury" -> painterResource(R.drawable.mercury_image)
            "venus" -> painterResource(R.drawable.venus_image)
            "earth" -> painterResource(R.drawable.earth_image)
            "mars" -> painterResource(R.drawable.mars_image)
            "jupiter" -> painterResource(R.drawable.jupiter_image)
            "saturn" -> painterResource(R.drawable.saturn_image)
            "uranus" -> painterResource(R.drawable.uranus_image)
            "neptune" -> painterResource(R.drawable.neptune_image)
            else -> painterResource(R.drawable.mars_image)
        }


        Text(
            text = planetName,
            color = Color.Black,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp)
                .offset(y = 50.dp)
        )


        Image(
            painter = planetImage,
            contentDescription = "$planetName image",
            modifier = Modifier
                .size(590.dp)
                .align(Alignment.TopCenter)
                .padding(top = 8.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 540.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            planetDetails?.let { details ->
                DetailRow(label = "Radius: ", value = details.radius)
                DetailRow(label = "Distance from Sun: ", value = details.distanceFromSun)
                DetailRow(label = "Moons: ", value = details.moons)
                DetailRow(label = "Gravity: ", value = details.gravity)
                DetailRow(label = "Tilt of Axis: ", value = details.tiltOfAxis)
                DetailRow(label = "Length of Year: ", value = details.lengthOfYear)
                DetailRow(label = "Temperature: ", value = details.temperature)
            } ?: Text(
                text = "No data available for $planetName",
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp, end = 16.dp, start = 320.dp)
                .align(Alignment.BottomEnd)
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .wrapContentSize()
            ) {
                items(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                    ) {

                        Image(
                            painter = planetImage,
                            contentDescription = "Planet $index",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )


                        if (index == 0) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Black, Color.Transparent),
                                            startY = 0f,
                                            endY = 250f
                                        )
                                    )
                            )
                        }
                        if (index == 4) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, Color.Black),
                                            startY = 50f,
                                            endY = 250f
                                        )
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}
