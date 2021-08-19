package com.nezspencer.compose1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@ExperimentalFoundationApi
@Composable
fun Dashboard(
    modifier: Modifier,
    navController: NavHostController,
    onNewTaskAdded: (title: String, description: String) -> Unit
) {
    if (dialogState.value) {
        AddTaskDialog(
            onClose = { /*TODO*/ },
            onTextEdited = { }, onNewTaskAdded
        )
    }

    if (homeItems.isEmpty()) {
        Text(
            text = stringResource(id = R.string.prompt_empty_tasks_message),
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(200.dp)
                .background(color = MaterialTheme.colors.background),
            textAlign = TextAlign.Center
        )
    } else {
        LazyVerticalGrid(
            contentPadding = PaddingValues(bottom = 16.dp),
            cells = GridCells.Fixed(2),
            modifier = modifier.fillMaxWidth()
        ) {
            items(homeItems) { item ->
                HomeTaskCard(task = item, navController)
            }
        }
    }
}

@Composable
fun HomeTaskCard(task: Task, navController: NavController) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(AppDestination.DETAIL.route) }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp).fillMaxWidth())
            Text(
                text = task.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.wrapContentSize(align = Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AddTaskDialog(
    onClose: () -> Unit,
    onTextEdited: (String) -> Unit,
    onSaveClicked: (title: String, description: String) -> Unit
) {
    Dialog(onDismissRequest = {

        onClose()
        dialogState.value = false
    }, properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)) {
        val titleFieldState = remember { mutableStateOf(TextFieldValue()) }
        val descriptionState = remember { mutableStateOf(TextFieldValue()) }
        val buttonState = remember { mutableStateOf(false) }
        Surface(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.title_add_task),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = stringResource(id = R.string.label_title))
                TextField(
                    value = titleFieldState.value,
                    onValueChange = { state ->
                        titleFieldState.value = state
                        buttonState.value = state.text.isNotBlank() && descriptionState.value.text.isNotBlank()
                    },
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Description")
                TextField(
                    value = descriptionState.value,
                    onValueChange = { state ->
                        descriptionState.value = state
                        buttonState.value = state.text.isNotBlank() && titleFieldState.value.text.isNotBlank()

                    },
                    singleLine = false
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(onClick = {
                    if (titleFieldState.value.text.isNotBlank()) {
                        onSaveClicked(titleFieldState.value.text, descriptionState.value.text)
                        dialogState.value = false
                    }
                }, modifier = Modifier.padding(8.dp), enabled = buttonState.value) {
                    Text(
                        text = "Save",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}