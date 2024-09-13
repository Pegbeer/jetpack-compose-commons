package me.pegbeer.commons.ui.ext

import androidx.compose.ui.graphics.Color

fun Color.adjustBrightness(darker: Boolean = true, factor: Float = 0.8f): Color {
    val scale = if (darker) factor else 1 / factor
    return Color(
        red = (this.red * scale).coerceIn(0f, 1f),
        green = (this.green * scale).coerceIn(0f, 1f),
        blue = (this.blue * scale).coerceIn(0f, 1f),
        alpha = this.alpha
    )
}