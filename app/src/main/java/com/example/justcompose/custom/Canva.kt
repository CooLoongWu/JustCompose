package com.example.justcompose.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R
import com.example.justcompose.ui.myBlue
import com.example.justcompose.ui.myGray
import com.example.justcompose.ui.myRed

//@Preview
//@Composable
//fun CanvasDemoPreview() {
//    CanvasDemo()
//}

@Composable
fun DrawArcDemo() {
    Row() {
        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawArc(
                color = myRed,
                startAngle = 0f,
                sweepAngle = 270f,
                useCenter = true
            )
        })

        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawArc(
                color = myRed,
                startAngle = 0f,
                sweepAngle = 270f,
                useCenter = false
            )
        })

        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawArc(
                color = myRed,
                startAngle = -90f,
                sweepAngle = 90f,
                useCenter = false
            )
        })
    }
}

@Preview
@Composable
fun DrawArcDemoPreview() {
    DrawArcDemo()
}


@Composable
fun DrawCircleDemo() {
    Row() {
        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawCircle(
                color = myRed,
                radius = 160f,
                style = Fill
            )
        })

        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawCircle(
                color = myRed,
                radius = 160f,
                style = Stroke(width = 10f)
            )
        })
    }
}

@Preview
@Composable
fun DrawCircleDemoPreview() {
    DrawCircleDemo()
}

@Composable
fun DrawImageDemo() {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.like)

    Canvas(modifier = Modifier.size(200.dp), onDraw = {
        drawImage(
            image = imageBitmap
        )
    })
}

@Preview
@Composable
fun DrawImageDemoPreview() {
    DrawImageDemo()
}

@Composable
fun DrawLineDemo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier
            .width(200.dp)
            .height(50.dp), onDraw = {
            drawLine(
                color = myRed,
                start = Offset(0f, 0f),
                end = Offset(400f, 0f),
                strokeWidth = 40f
            )
        })

        Canvas(modifier = Modifier
            .width(200.dp)
            .height(50.dp), onDraw = {
            drawLine(
                color = myRed,
                start = Offset(0f, 0f),
                end = Offset(400f, 0f),
                strokeWidth = 40f,
                cap = StrokeCap.Round
            )
        })
    }
}

@Preview
@Composable
fun DrawLineDemoPreview() {
    DrawLineDemo()
}

@Composable
fun DrawOvalDemo() {

    Row() {
        Canvas(modifier = Modifier.size(200.dp), onDraw = {
            drawOval(
                color = myRed,
                size = Size(size.width, size.height * 0.5f),
                topLeft = Offset(0f, size.height / 4)
            )
        })

//        Canvas(modifier = Modifier.size(200.dp), onDraw = {
//            drawOval(
//                color = myRed,
//                size = Size(size.width * 0.5f, size.height * 0.5f)
//            )
//        })
//
//        Canvas(modifier = Modifier.size(200.dp), onDraw = {
//            drawOval(
//                color = myRed,
//                size = Size(size.width * 0.2f, size.height)
//            )
//        })
    }
}

@Preview
@Composable
fun DrawOvalDemoPreview() {
    DrawOvalDemo()
}

@Composable
fun DrawPathDemo() {
    Canvas(modifier = Modifier.size(200.dp), onDraw = {

        val myPath = Path()
        myPath.lineTo(size.width / 2, size.height / 2)
        myPath.lineTo(0f, size.height)
        myPath.close()

        drawPath(
            path = myPath,
            color = myRed,
//            style = Stroke(width = 20f)
        )
    })
}

@Preview
@Composable
fun DrawPathDemoPreview() {
    DrawPathDemo()
}

@Composable
fun DrawPointsDemo() {
    Canvas(modifier = Modifier.size(200.dp), onDraw = {
        val myPoints = arrayListOf(
            Offset(size.width / 3, size.height / 2),
            Offset(size.width / 3 * 2, size.height / 2),
        )

        drawPoints(
            color = myRed,
            points = myPoints,
            pointMode = PointMode.Points,
            strokeWidth = 40f,
            cap = StrokeCap.Round
        )
    })
}

@Composable
fun DrawReactDemo() {
    Canvas(modifier = Modifier.size(200.dp), onDraw = {
        drawRoundRect(
            color = myRed,
            cornerRadius = CornerRadius(80f, 80f),
            style = Stroke(width = 80f),
            topLeft = Offset(40f, 40f),
            size = Size(size.width - 40 * 2f, size.height - 40 * 2f)
        )
    })
}

@Preview
@Composable
fun DrawReactDemoPreview() {
    DrawReactDemo()
}

@Preview
@Composable
fun DrawPointsDemoPreview() {
    DrawPointsDemo()
}


@Composable
fun CanvasDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {

            val myPath = Path()
            myPath.lineTo(100f, 0f)
            myPath.lineTo(100f, 100f)
//            myPath.lineTo(0f, 100f)
//            myPath.close()

            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {

//                    drawIntoCanvas {
//
//                    }

                    drawPath(
                        color = myBlue,
                        path = myPath,

                        )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {

            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {

                    val myPoints = arrayListOf(
                        Offset(100f, 60f),
                        Offset(100f, 100f),
                        Offset(100f, 140f),
                        Offset(100f, 180f),
                    )

                    drawPoints(
                        color = myBlue,
                        points = myPoints,
                        pointMode = PointMode.Points,
                        strokeWidth = 20f,
                        cap = StrokeCap.Round
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(
                modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawCircle(
                        color = myBlue,
                        radius = 200f,
                        style = Fill,
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawArc(
                        color = myBlue,
                        startAngle = 0f,
                        sweepAngle = 90f,
                        size = Size(200f, 200f),
                        useCenter = false
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawOval(
                        color = myBlue,
                        size = Size(400f, 200f)
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawLine(
                        color = myBlue,
                        start = Offset(0f, 0f),
                        end = Offset(200f, 0f),
                        strokeWidth = 50f,
                        cap = StrokeCap.Square
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawRect(
                        color = myBlue,
                        size = Size(width = 100f, height = 100f)
                    )
                })
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(myGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize(),
                onDraw = {
                    drawRoundRect(
                        color = myBlue,
                        size = Size(width = 100f, height = 100f),
                        style = Stroke(width = 20f),
                        cornerRadius = CornerRadius(20f)
                    )
                })
        }


    }

}