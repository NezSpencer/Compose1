package com.nezspencer.compose1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.nezspencer.compose1.ui.theme.Purple700

val dialogState = mutableStateOf(false)
val homeItems = mutableListOf<String>()

@ExperimentalFoundationApi
@Composable
fun TodoApp(
    navController: NavHostController = rememberNavController(),
    onNewTaskAdded: (String) -> Unit
) {
    ProvideWindowInsets {
        Scaffold(
            topBar = { AppBar() },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { dialogState.value = true },
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_item),
                        contentDescription = null
                    )
                }
            },

            ) {
            NavGraph(
                navController = navController,
                startDestination = AppDestination.HOME,
                modifier = Modifier.padding(it),
                onNewTaskAdded = onNewTaskAdded
            )
        }
    }
}

@Composable
fun AppBar() {
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = Purple700,
        shape = MaterialTheme.shapes.medium.copy(CornerSize(0.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    TodoApp(rememberNavController(), {})
}

@Preview
@Composable
fun PreviewTaskDialog() {
    AddTaskDialog({}, {}, {})
}