package com.example.justcompose.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.ui.myBlue
import com.example.justcompose.ui.myPink


//android.graphics
//国外地址
//https://developer.android.com/reference/android/graphics/PorterDuff.Mode.html

//国内地址
//https://developer.android.google.cn/reference/android/graphics/PorterDuff.Mode


//Compose
//https://developer.android.google.cn/reference/kotlin/androidx/compose/ui/graphics/BlendMode


//参考文章
//https://blog.csdn.net/qq_31370269/article/details/77525068
//https://blog.csdn.net/u013085697/article/details/52096703

val defaultSizeDraw = 108.dp

@Composable
fun BlendModeShape(blendMode: BlendMode) {
    Canvas(
        modifier = Modifier
            .size(defaultSizeDraw)
    ) {

        val radius = size.width / 3

        drawCircle(
            color = myPink,
            radius = radius,
            center = Offset(radius, radius),
        )

        drawRect(
            color = myBlue,
            topLeft = Offset(radius, radius),
            size = Size(radius * 2, radius * 2),
            blendMode = blendMode
        )

    }
}
//
//@Preview
//@Composable
//fun Clear() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//
//        val radius = size.width / 3
//
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.Clear
//        )
//
//    }
//}
//
//@Preview()
//@Composable
//fun Src() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.Src
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun Dst() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.Dst
//        )
//    }
//}
//
//
//@Preview()
//@Composable
//fun SrcOver() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.SrcOver
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun DstOver() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.DstOver
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun SrcIn() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.SrcIn
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun DstIn() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.DstIn
//        )
//    }
//}
//
//
//@Preview()
//@Composable
//fun SrcOut() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.SrcOut
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun DstOut() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.DstOut
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun SrcAtop() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.SrcAtop
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun DstAtop() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.DstAtop
//        )
//    }
//}
//
//@Preview()
//@Composable
//fun Xor() {
//    Canvas(
//        modifier = Modifier
//            .size(defaultSizeDraw)
//    ) {
//        val radius = size.width / 3
//        drawCircle(
//            color = myPink,
//            radius = radius,
//            center = Offset(radius, radius),
//        )
//
//        drawRect(
//            color = myBlue,
//            topLeft = Offset(radius, radius),
//            size = Size(radius * 2, radius * 2),
//            blendMode = BlendMode.Xor
//        )
//    }
//}
//
//@Preview
//@Composable
//fun Plus() {
//    BlendModeShape(blendMode = BlendMode.Plus)
//}
//
//@Preview
//@Composable
//fun Modulate() {
//    BlendModeShape(blendMode = BlendMode.Modulate)
//}
//
//@Preview()
//@Composable
//fun Screen() {
//    BlendModeShape(blendMode = BlendMode.Screen)
//}
//
//@Preview()
//@Composable
//fun Overlay() {
//    BlendModeShape(blendMode = BlendMode.Overlay)
//}
//
//@Preview()
//@Composable
//fun Darken() {
//    BlendModeShape(blendMode = BlendMode.Darken)
//}
//
//
//@Preview()
//@Composable
//fun Lighten() {
//    BlendModeShape(blendMode = BlendMode.Lighten)
//}
//
//@Preview()
//@Composable
//fun ColorDodge() {
//    BlendModeShape(blendMode = BlendMode.ColorDodge)
//}
//
//@Preview()
//@Composable
//fun ColorBurn() {
//    BlendModeShape(blendMode = BlendMode.ColorBurn)
//}

@Preview()
@Composable
fun Hardlight() {
    BlendModeShape(blendMode = BlendMode.Hardlight)
}


@Preview()
@Composable
fun Softlight() {
    BlendModeShape(blendMode = BlendMode.Softlight)
}

@Preview()
@Composable
fun Difference() {
    BlendModeShape(blendMode = BlendMode.Difference)
}


@Preview()
@Composable
fun Exclusion() {
    BlendModeShape(blendMode = BlendMode.Exclusion)
}

@Preview()
@Composable
fun Multiply() {
    BlendModeShape(blendMode = BlendMode.Multiply)
}

@Preview()
@Composable
fun Hue() {
    BlendModeShape(blendMode = BlendMode.Hue)
}


@Preview()
@Composable
fun Saturation() {
    BlendModeShape(blendMode = BlendMode.Saturation)
}

@Preview()
@Composable
fun Color() {
    BlendModeShape(blendMode = BlendMode.Color)
}


@Preview()
@Composable
fun Luminosity() {
    BlendModeShape(blendMode = BlendMode.Luminosity)
}



