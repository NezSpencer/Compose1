package com.nezspencer.compose1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nezspencer.compose1.ui.theme.yellow
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.window.DialogProperties

val dialogState = mutableStateOf(false)
val homeItems = mutableListOf<String>()

@ExperimentalFoundationApi
@Composable
fun HomeScreen(onNewTaskAdded: (String) -> Unit) {
    Scaffold(
        topBar = { AppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { dialogState.value = true }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add_item),
                    contentDescription = null
                )
            }
        },

        ) {
        if (dialogState.value) {
            AddTaskDialog(
                onClose = { /*TODO*/ },
                onTextEdited = { }, onNewTaskAdded)
        }

        LazyVerticalGrid(
            contentPadding = PaddingValues(bottom = 16.dp),
            cells = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(homeItems) { item ->
                HomeTaskCard(item = item)
            }
        }
    }
}

@Composable
fun HomeTaskCard(item: String) {
    Card(modifier = Modifier.height(200.dp).fillMaxWidth().padding(8.dp)) {
        Text(
            text = item,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.wrapContentSize(align = Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AppBar() {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = yellow)
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

@Composable
fun AddTaskDialog(
    onClose: () -> Unit,
    onTextEdited: (String) -> Unit,
    onSaveClicked: (String) -> Unit
) {
    Dialog(onDismissRequest = {

        onClose()
        dialogState.value = false
    }, properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Add Task",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = textState.value,
                    onValueChange = { textFieldValue ->
                        textState.value = textFieldValue
                        onTextEdited(textFieldValue.text)
                    },
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    if (textState.value.text.isNotBlank()) {
                        onSaveClicked(textState.value.text)
                        dialogState.value = false
                    }
                }) {
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

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen({})
}

@Preview
@Composable
fun PreviewTaskDialog() {
    AddTaskDialog({}, {}, {})
}