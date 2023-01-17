package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroItem(superHero: Hero) {

    var showDescription by remember { mutableStateOf(false) }

    Surface(Modifier
        .clip(shape = RoundedCornerShape(16.dp))
        .clickable { showDescription = !showDescription }) {
        Column {
            Row(
                modifier = Modifier
                    .height(120.dp)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Text(
                        text = stringResource(superHero.nameRes),
                        style = MaterialTheme.typography.h3
                    )
                    Text(
                        text = stringResource(superHero.descriptionRes),
                        style = MaterialTheme.typography.body1
                    )
                }
                Image(
                    painter = painterResource(superHero.imageRes),
                    contentDescription = stringResource(superHero.descriptionRes),
                    modifier = Modifier
                        .heightIn(min = 40.dp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            AnimatedVisibility(visible = showDescription){
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = stringResource(R.string.randomText),
                    maxLines = 4,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Composable
fun SuperHeroList(modifier: Modifier = Modifier,list: List<Hero> = HeroesRepository.heroes) {

    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) { hero ->
            SuperHeroItem(superHero = hero)
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .height(52.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun SuperHeroesApp() {
    Scaffold(
        topBar = { TopBar() }
    ) {
       SuperHeroList(modifier = Modifier.padding(it))
    }
}

@Preview
@Composable
fun SuperHeroItemPrev() {
    SuperheroesTheme {
        SuperHeroItem(superHero = HeroesRepository.heroes[1])
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SuperHeroListPrev() {
    SuperheroesTheme {
        SuperHeroesApp()
    }
}