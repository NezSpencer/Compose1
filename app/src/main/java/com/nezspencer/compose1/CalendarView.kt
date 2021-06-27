package com.nezspencer.compose1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun CalendarView(modifier: Modifier) {
    val daysInWeek =
        listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
    Column(modifier = modifier.fillMaxSize()) {
        CalendarHeader(daysInWeek)
        CalendarBody()
    }
}

@Composable
fun CalendarHeader(daysInWeek: List<String>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (day in daysInWeek) {
            Text(
                text = day,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
                    .background(color = Color.White),
                style = MaterialTheme.typography.body1
            )
            //Spacer(modifier = Modifier.width(1.dp).requiredHeight(IntrinsicSize.Max).background(color = Color.White))
        }
    }
}

@Composable
fun CalendarBody() {
    val calendar = Calendar.getInstance()
    calendar[Calendar.DAY_OF_MONTH] = calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
    val numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]
    var counter = 1
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        while (counter <= numberOfDaysInMonth) {
            Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
                for (i in 1..7) {
                    val text = if ((counter == 1 && dayOfWeek != i) || counter > numberOfDaysInMonth) "" else counter.toString()
                    Text(text = text, modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                    )
                    if (counter != 1 || dayOfWeek == i) {
                        counter++
                    }
                }
            }
        }
    }
}