package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

data class ArtWork(
    val id: Int,
    @DrawableRes val image: Int,
    val title: String,
    val author: String,
)

val artWorkList = listOf(
    ArtWork(
        id = 1,
        image = R.drawable.andrew_romanov_unsplash,
        title = "Photos on Bed",
        author = "Andrew Romanov",
    ),
    ArtWork(
        id = 2,
        image = R.drawable.phil_lev_unsplash,
        title = "Urban Art",
        author = "Phil Lev",
    ),
    ArtWork(
        id = 3,
        image = R.drawable.dmitry_dreyer_unsplash,
        title = "Foodable Art",
        author = "Dmitry Dreyer",
    ),
    ArtWork(
        id = 4,
        image = R.drawable.thebugadi_unsplash,
        title = "Grand Tiger",
        author = "The Bugadi",
    ),
    ArtWork(
        id = 5,
        image = R.drawable.winston_tjia_unsplash,
        title = "Red Panda",
        author = "Winston Tjia",
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artId:Int by remember { mutableStateOf(0)}

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Surface(
                Modifier
                    .border(4.dp, Color.LightGray)
                    .padding(30.dp)
                    .weight(2f)
            ) {
                Image(
                    painter = painterResource(id = artWorkList[artId].image),
                    contentDescription = null,
                )
            }
            Surface(
                elevation = 8.dp,
                modifier = Modifier
                    .wrapContentSize()
                    .weight(1f)
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text(
                        text = artWorkList[artId].title,
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.h4,
                    )
                    Text(
                        text = "${artWorkList[artId].author}(2022)",
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier.weight(1f)
            ) {
                Button(
                    onClick = { if (artId > 1) artId-- else artId = 4 },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Previous")
                }

                Button(
                    onClick = {
                        if (artId < artWorkList.size - 1) artId++ else artId = 0
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Next")
                }

            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}