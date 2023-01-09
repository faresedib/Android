package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
private fun ComposeQuadrants() {
    Column {
        Row(Modifier.weight(1f)) {
            QuadrantComposable(
                backg = Color.Green,
                title = "Text Composable",
                descript = "Displays text and follows Material Design guidelines",
                Modifier.weight(1f)
            )

            QuadrantComposable(
                backg = Color.Yellow,
                title = "Image Composable",
                descript = "Creates a composable that lays out and draws a given Painter class object.",
                Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            QuadrantComposable(
                backg = Color.Cyan,
                title = "Row Composable",
                descript = "A layout composable that places its children in a horizontal sequence.",
                Modifier.weight(1f)
            )

            QuadrantComposable(
                backg = Color.LightGray,
                title = "Colum Composable",
                descript = "A layout composable that places its children in a vertical sequence.",
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun QuadrantComposable(
    backg: Color, title: String, descript: String, modifier: Modifier
) {

    Column(
        modifier = modifier
            .background(backg)
            .padding(16.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = descript,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrants()
    }
}