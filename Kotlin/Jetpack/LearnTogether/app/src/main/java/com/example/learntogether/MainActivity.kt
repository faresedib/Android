package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeTogether()
                }
            }
        }
    }

    @Composable
    private fun ComposeTogether() {
        Column {
            ImageTogetherApp()
            TextTogetherApp()
        }
    }

    @Composable
    fun TextTogetherApp() {
        Column {
            Text(
                text = getString(R.string.compose_tutorial_title),
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = getString(R.string.compose_tutorial_body1),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify
            )

            Text(
                text = getString(R.string.compose_tutorial_body2),
                Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }

    @Composable
    fun ImageTogetherApp() {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            Modifier.fillMaxWidth()
        )
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        LearnTogetherTheme {
            ComposeTogether()
        }
    }
}