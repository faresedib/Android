package com.example.lemonade

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {

    var currentStep by remember { mutableStateOf(1) }
    Surface {

        when (currentStep) {
            1 -> {
                ComposeImageAndText(
                    imageRes = R.drawable.lemon_tree,
                    text = stringResource(id = R.string.lemon_tree_content_description),
                    nav = { currentStep++ }
                )
            }

            2 -> {
                ComposeImageAndText(
                    imageRes = R.drawable.lemon_squeeze,
                    text = stringResource(id = R.string.lemon_content_description),
                    nav = { currentStep++ }
                )
            }

            3 -> {
                ComposeImageAndText(
                    imageRes = R.drawable.lemon_drink,
                    text = stringResource(id = R.string.glass_lemonade_content_description),
                    nav = { currentStep++ }
                )
            }

            else -> {
                ComposeImageAndText(
                    imageRes = R.drawable.lemon_restart,
                    text = stringResource(id = R.string.empty_glass_content_description),
                    nav = { currentStep = 1 }
                )
            }
        }

    }
}

@Composable
fun ComposeImageAndText(imageRes: Int, text: String, nav: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = text, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color(105, 205, 216))
                .clickable(onClick = nav)
        )
    }

}

@Preview()
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonPreview() {
    ComposeImageAndText(
        imageRes = R.drawable.lemon_squeeze,
        text = stringResource(id = R.string.lemon_content_description),

        )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GlassPreview() {
    ComposeImageAndText(
        imageRes = R.drawable.lemon_drink,
        text = stringResource(id = R.string.glass_lemonade_content_description),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GlassEmptyPreview() {
    ComposeImageAndText(
        imageRes = R.drawable.lemon_restart,
        text = stringResource(id = R.string.empty_glass_content_description)
    )
}
*/
