package me.pegbeer.commons.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.pegbeer.commons.ui.ext.adjustBrightness

@Composable
fun GradientOutlinedTextField(
    modifier: Modifier = Modifier,
    from:Color = kiwiGreen,
    until:Color = texas,
    outlineWidth:Dp = 1.dp,
    textColor:Color = endo,
    backgroundColor:Color = gunMetal,
    placeholder:String = "Placeholder",
    boxShape:Shape = RoundedCornerShape(5.dp)
){
    var text by rememberSaveable { mutableStateOf("") }

    val infiniteTransition = rememberInfiniteTransition(label = "Transition")
    val color1 by infiniteTransition.animateColor(
        initialValue = from,
        targetValue = from.adjustBrightness(true),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "From Color"
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = until,
        targetValue = until.adjustBrightness(false),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "Until Color"
    )


    BasicTextField(value = text, onValueChange = {
        text = it
    },
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(color = backgroundColor, shape = boxShape)
            .border(
                width = outlineWidth,
                brush = Brush.horizontalGradient(colors = listOf(color1,color2)),
                shape = boxShape
            ),
        decorationBox = { innerTextField ->
            Row (
                modifier = Modifier
                    .padding(16.dp,4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                if(text.isEmpty()){
                    Text(placeholder, color = textColor)
                }
                innerTextField()
            }
        }
    )
}

@Preview
@Composable
fun PreviewGradientOutlinedTextField(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        GradientOutlinedTextField()
    }
}