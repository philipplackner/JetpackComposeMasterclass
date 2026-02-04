package com.plcoding.jetpackcomposemasterclass.performance

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun LazyListPerformance(modifier: Modifier = Modifier) {
    var myList by remember {
        mutableStateOf(
            (1..100).map {
                MyListItem(
                    id = it,
                    title = "List item $it",
                    description = "Description $it"
                )
            }
        )
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val highestVal = myList.maxOf { it.id }
                    myList = listOf(MyListItem(
                        id = highestVal + 1,
                        title = "List item ${highestVal + 1}",
                        description = "Description ${highestVal + 1}",
                    )) + myList
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add item"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(
                items = myList,
                key = { it.id }
            ) { item ->
                ListItem(
                    headlineContent = {
                        Text(item.title)
                    },
                    supportingContent = {
                        Text(item.description)
                    },
                    trailingContent = {
                        IconButton(
                            onClick = {
                                myList -= item
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                tint = Color.Red,
                                contentDescription = "Delete"
                            )
                        }
                    }
                )
            }
        }
    }
}

data class MyListItem(
    val id: Int,
    val title: String,
    val description: String
)

@Preview(
    showBackground = true
)
@Composable
private fun LazyListPerformancePreview() {
    JetpackComposeMasterclassTheme {
        LazyListPerformance()
    }
}