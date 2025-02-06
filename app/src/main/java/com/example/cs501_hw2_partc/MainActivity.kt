package com.example.cs501_hw2_partc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs501_hw2_partc.ui.theme.CS501_HW2_PartCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501_HW2_PartCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MusicPlayerUI(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun MusicPlayerUI(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.album_cover),
                contentDescription = "Album Cover",
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Bohemian Rhapsody",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Queen",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MusicControlButton(icon = Icons.AutoMirrored.Filled.ArrowBack, description = "Previous")
                Spacer(modifier = Modifier.width(16.dp))
                MusicControlButton(icon = Icons.Filled.PlayArrow, description = "Play")
                Spacer(modifier = Modifier.width(16.dp))
                MusicControlButton(icon = Icons.AutoMirrored.Filled.ArrowForward, description = "Next")
            }
        }
    }
}

@Composable
fun MusicControlButton(icon: androidx.compose.ui.graphics.vector.ImageVector, description: String) {
    Button(
        onClick = { },
        shape = CircleShape,
        modifier = Modifier.size(60.dp)
    ) {
        Icon(imageVector = icon, contentDescription = description)
    }
}

@Preview(showBackground = true)
@Composable
fun MusicPlayerPreview() {
    CS501_HW2_PartCTheme {
        MusicPlayerUI()
    }
}