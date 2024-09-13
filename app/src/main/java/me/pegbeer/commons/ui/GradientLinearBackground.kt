package me.pegbeer.commons.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.pegbeer.commons.ui.ext.adjustBrightness

@Composable
fun GradientLinearBackground(from:Color,until:Color,modifier: Modifier = Modifier,content: @Composable () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "Transition")
    val color1 by infiniteTransition.animateColor(
        initialValue = from,
        targetValue = from.adjustBrightness(true),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "First Color"
    )
    val color2 by infiniteTransition.animateColor(
        initialValue = until,
        targetValue = until.adjustBrightness(false),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Second Color"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(color1, color2)
                )
            )
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewNeonLavaLampBackground() {
    GradientLinearBackground(Color(0xFF8000ff),Color(0xFF043C6E)){
        Text(text = "Lorem Ipsum")
    }
}