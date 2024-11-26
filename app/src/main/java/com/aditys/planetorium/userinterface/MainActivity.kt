package com.aditys.planetorium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditys.planetorium.ui.theme.PlanetoriumTheme
import com.aditys.planetorium.userinterface.PlanetListScreen
import com.aditys.planetorium.userinterface.PlanetNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetoriumTheme {
                PlanetNavHost()
            }
        }
    }
}

