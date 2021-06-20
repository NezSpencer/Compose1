package com.nezspencer.compose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nezspencer.compose1.ui.theme.Compose1Theme

val list = mutableListOf(
    "Stretch",
    "Leave the bed and sit somewhere calm",
    "List three(3) things you're happy about",
    "List two(2) things you're sad about",
    "List three(3) things you're anxious/hopeful to happen",
    "List three(3) fears/things you dont want to happen",
    "Meditate/Pray",
    "What one(1) major task should be done today?",
    "What 2 other things should be done today after the major task has been done?",
    "Exercise for 30 mins",
    "dudididjjaj",
    "dudididjjaj",
    "dudididjjaj",
    "dudididjjaj"
)

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //HomeToDo(todos = list)
                    HomeScreen {
                        homeItems.add(it)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name")
}

@Composable
fun NewStory() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
                style = typography.h6,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Text(text = "Davenport, California", style = typography.body1)
            Text(text = "December, 2018", style = typography.body2)
        }
    }
}

@Composable
fun HomeToDo(todos: List<String>) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        val sectionMargin = dimensionResource(id = R.dimen.section_margin)
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "<<< Morning Checklist >>>",
                style = typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(sectionMargin))
            LazyColumn {
                items(todos) { item ->
                    TaskItem(item)
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.intra_view_margin)))
                }
            }
        }
    }
}

@Composable
fun TaskItem(item: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .fillMaxHeight()
            )
            Text(text = item, modifier = Modifier.padding(dimensionResource(id = R.dimen.intra_view_margin)))
        }
    }
}

@Preview
@Composable
fun PreviewNewStory() {
    NewStory()
}

@Preview
@Composable
fun PreviewTodoList() {
    HomeToDo(todos = list)
}