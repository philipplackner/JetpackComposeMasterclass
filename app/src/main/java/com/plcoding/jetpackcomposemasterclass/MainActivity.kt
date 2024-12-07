@file:OptIn(ExperimentalComposeUiApi::class)

package com.plcoding.jetpackcomposemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.TriangleShape
import com.plcoding.jetpackcomposemasterclass.composition_locals.LocalShape
import com.plcoding.jetpackcomposemasterclass.internals.snapshots
import com.plcoding.jetpackcomposemasterclass.performance.DeferredStateReads
import com.plcoding.jetpackcomposemasterclass.performance.KeysCustomLayout
import com.plcoding.jetpackcomposemasterclass.performance.LazyListPerformance
import com.plcoding.jetpackcomposemasterclass.performance.MovableContent
import com.plcoding.jetpackcomposemasterclass.performance.OverdrawDemo
import com.plcoding.jetpackcomposemasterclass.performance.main_safety.BitmapCompressor
import com.plcoding.jetpackcomposemasterclass.performance.main_safety.PhotoPickerScreen
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        snapshots()
        setContent {
            JetpackComposeMasterclassTheme {
                CompositionLocalProvider(LocalShape provides TriangleShape) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .semantics {
                                testTagsAsResourceId = true
                            },
                    ) { innerPadding ->
                        LazyListPerformance(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeMasterclassTheme {
        Greeting("Android")
    }
}