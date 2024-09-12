package me.pegbeer.commons.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    outlineColor:Color = gunMetal,
    outlineWidth: Dp = 1.dp,
    textColor:Color = gunMetal,
    backgroundColor:Color = mintCream,
    placeholder:String = "Placeholder",
    boxShape:Shape = RoundedCornerShape(5.dp)
){
    var text by rememberSaveable { mutableStateOf("") }

    BasicTextField(value = text, onValueChange = {
        text = it
    },
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(color = backgroundColor, shape = boxShape)
            .border(outlineWidth, outlineColor, boxShape),
        decorationBox = { innerTextField ->
            Row (
                modifier = Modifier
                    .padding(16.dp,4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                if(text.isEmpty()){
                    Text(placeholder)
                }
                innerTextField()
            }
        }
    )
}

@Preview
@Composable
fun PreviewOutlinedTextField(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        OutlinedTextField()
    }
}