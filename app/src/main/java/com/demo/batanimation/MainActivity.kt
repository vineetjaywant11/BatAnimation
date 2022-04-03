package com.demo.batanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.batanimation.ui.theme.BatAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.White) {
                    BatAnimation()
                }
            }
        }
    }
}

@Composable
fun BatAnimation() {


    var rotatedState by remember {
        mutableStateOf(false)
    }

    val rotate by animateFloatAsState(
        targetValue = if (rotatedState) 90f else 0f
    )

    var colorBody by remember {
        mutableStateOf(Color.Black)
    }

    var colorSkin by remember {
        mutableStateOf(Color(0xFFcdbaa3))
    }

    var colorEyes by remember {
        mutableStateOf(Color.White)
    }

    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color.White)
                .clickable {
                    rotatedState = !rotatedState
                    colorBody = if (rotatedState) Color(0xFF28a9e1) else Color.Black
                    colorEyes = if (rotatedState) Color(0xFF28a9e1) else Color.White
                    colorSkin = if (rotatedState) Color(0xFF28a9e1) else Color(0xFFcdbaa3)
                },
        ) {
            Canvas(modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = rotate
                }) {

                //cover-4 black
                drawCircle(
                    brush = SolidColor(colorBody),
                    radius = 320f,
                    style = Fill,
                    center = Offset(x = 430f, y = 520f),
                )

                //cover-4 white
                drawCircle(
                    brush = SolidColor(Color.White),
                    radius = 400f,
                    style = Fill,
                    center = Offset(x = 250f, y = 600f),
                )

                //cover-3 black
                drawCircle(
                    brush = SolidColor(colorBody),
                    radius = 250f,
                    style = Fill,
                    center = Offset(x = 400f, y = 450f),
                )

                //cover-3 white
                drawCircle(
                    brush = SolidColor(Color.White),
                    radius = 350f,
                    style = Fill,
                    center = Offset(x = 180f, y = 500f),
                )

                //cover-2 black
                drawCircle(
                    brush = SolidColor(colorBody),
                    radius = 250f,
                    style = Fill,
                    center = Offset(x = 330f, y = 450f),
                )

                //cover-2 white
                drawCircle(
                    brush = SolidColor(Color.White),
                    radius = 350f,
                    style = Fill,
                    center = Offset(x = 85f, y = 480f),
                )

                //cover-1 black
                drawCircle(
                    brush = SolidColor(colorBody),
                    radius = 250f,
                    style = Fill,
                    center = Offset(x = 250f, y = 410f)
                )

                //cover-1 white
                drawCircle(
                    brush = SolidColor(Color.White),
                    radius = 350f,
                    style = Fill,
                    center = Offset(x = 70f, y = 300f),
                )

                //ear-1 black
                drawArc(
                    brush = SolidColor(colorBody),
                    startAngle = -90f,
                    sweepAngle = 90f,
                    useCenter = true,
                    style = Fill,
                    size = Size(180f, 300f),
                    topLeft = Offset(x = 200f, y = 170f),
                )

                //ear-1 white
                drawArc(
                    brush = SolidColor(Color.White),
                    startAngle = -90f,
                    sweepAngle = 90f,
                    useCenter = true,
                    style = Fill,
                    size = Size(180f, 300f),
                    topLeft = Offset(x = 155f, y = 150f),
                )

                //ear-2 black
                drawArc(
                    brush = SolidColor(colorBody),
                    startAngle = -90f,
                    sweepAngle = 90f,
                    useCenter = true,
                    style = Fill,
                    size = Size(180f, 300f),
                    topLeft = Offset(x = 170f, y = 200f),
                )

                //ear-2 white
                drawArc(
                    brush = SolidColor(Color.White),
                    startAngle = -90f,
                    sweepAngle = 180f,
                    useCenter = true,
                    style = Fill,
                    size = Size(180f, 300f),
                    topLeft = Offset(x = 125f, y = 180f),
                )

                //head-1
                drawCircle(
                    brush = SolidColor(colorBody),
                    radius = 120f,
                    style = Fill,
                    center = Offset(x = 400f, y = 320f),
                )

                //head-2
                drawArc(
                    brush = SolidColor(colorSkin),
                    startAngle = 94.5f,
                    sweepAngle = 50f,
                    useCenter = true,
                    style = Fill,
                    size = Size(240f, 240f),
                    topLeft = Offset(x = 280f, y = 200f),
                )

                //mouth
                drawLine(
                    color = colorBody,
                    start = Offset(x = 330f, y = 418f),
                    end = Offset(x = 350f, y = 395f),
                    strokeWidth = 1.5f
                )

                //eye
                drawArc(
                    brush = SolidColor(colorEyes),
                    startAngle = -35f,
                    sweepAngle = 180f,
                    useCenter = true,
                    style = Fill,
                    size = Size(15f, 18f),
                    topLeft = Offset(x = 300f, y = 340f),
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BatAnimationTheme {
        BatAnimation()
    }
}