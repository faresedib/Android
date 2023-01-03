package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


data class ArtItem(
    val author: String,
    @DrawableRes val img: Int,
    val title: String,
    val year: Int,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

val listItems = listOf(
    ArtItem("Bretch Corbel", R.drawable.abstraction, "Abstraction", 2022),
    ArtItem("Devon Beard", R.drawable.flower, "City Black&White", 2021),
    ArtItem("Khiva", R.drawable.khiva, "Asian Temple", 2022),
    ArtItem("Mailchimp", R.drawable.fruits, "Laptop Work", 2022),
    ArtItem("Marek Piwnicki", R.drawable.exposition, "Beautiful flower", 2022)
)

@Composable
fun ArtSpaceApp() {

    var currentItem by rememberSaveable { mutableStateOf(0) }
    val artItem = listItems[currentItem]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(artItem.img),
            contentDescription = null,
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
                .heightIn(max = 500.dp)
                .clip(shape = RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )

        TitleArtistYear(artItem.title, artItem.author, artItem.year, Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .weight(1f)
        ) {
            ElevatedButton(
                onClick = {
                    if (currentItem >= 1) currentItem-- else currentItem = 4
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = "Previous")
            }
            ElevatedButton(
                onClick = {
                    if (currentItem <= 3) currentItem++ else currentItem = 0
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Text(text = "Next")
            }
        }

    }
}

@Composable
fun TitleArtistYear(title: String, artist: String, year: Int, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = artist + " (${year})",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
        