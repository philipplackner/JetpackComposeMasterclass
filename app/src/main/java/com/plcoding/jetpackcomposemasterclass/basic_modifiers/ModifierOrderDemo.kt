package com.plcoding.jetpackcomposemasterclass.basic_modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun BasicModifierDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Red)
            .padding(16.dp)
            .clip(CircleShape)
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello world")
    }
}

@Preview
@Composable
private fun ModifierOrderDemo() {
    JetpackComposeMasterclassTheme {
        BasicModifierDemo()
    }
}