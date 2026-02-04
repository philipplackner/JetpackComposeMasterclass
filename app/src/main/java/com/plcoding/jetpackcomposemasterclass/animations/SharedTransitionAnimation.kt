@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.plcoding.jetpackcomposemasterclass.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.jetpackcomposemasterclass.R
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun SharedTransitionAnimation(modifier: Modifier = Modifier) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    SharedTransitionLayout(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                this@Column.AnimatedVisibility(
                    visible = !isExpanded
                ) {
                    RowListItem(
                        onClick = {
                            isExpanded = !isExpanded
                        },
                        animatedVisibilityScope = this,
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState("item-layout"),
                                animatedVisibilityScope = this
                            )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                this@Column.AnimatedVisibility(
                    visible = isExpanded
                ) {
                    ColumnListItem(
                        onClick = {
                            isExpanded = !isExpanded
                        },
                        animatedVisibilityScope = this,
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState("item-layout"),
                                animatedVisibilityScope = this
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun SharedTransitionScope.RowListItem(
    onClick: () -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .padding(16.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.kermit),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .sharedElement(
                    sharedContentState = rememberSharedContentState("image"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "List item",
                fontSize = 20.sp,
                modifier = Modifier
                    .sharedElement(
                        sharedContentState = rememberSharedContentState("title"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            )
            Text(
                text = "This is the list item description",
                fontSize = 14.sp,
                modifier = Modifier
                    .sharedElement(
                        sharedContentState = rememberSharedContentState("description"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
            )
        }
    }
}

@Composable
fun SharedTransitionScope.ColumnListItem(
    onClick: () -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.kermit),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .sharedElement(
                    sharedContentState = rememberSharedContentState("image"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
        )
        Text(
            text = "List item",
            fontSize = 20.sp,
            modifier = Modifier
                .sharedElement(
                    sharedContentState = rememberSharedContentState("title"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
        )
        Text(
            text = "This is the list item description",
            fontSize = 14.sp,
            modifier = Modifier
                .sharedElement(
                    sharedContentState = rememberSharedContentState("description"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun SharedTransitionAnimationPreview() {
    JetpackComposeMasterclassTheme {
        SharedTransitionAnimation()
    }
}