package com.example.justcompose.custom

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.justcompose.R

val defaultSizeImage = 108.dp


@Composable
fun BlendModeImage(blendMode: BlendMode = DrawScope.DefaultBlendMode) {
    val destination = ImageBitmap.imageResource(id = R.drawable.canvas_dst)
    val source = ImageBitmap.imageResource(id = R.drawable.canvas_src)

    Canvas(
        modifier = androidx.compose.ui.Modifier
            .size(defaultSizeImage)
    ) {
        drawImage(
            image = destination,
        )

        drawImage(
            image = source,
            blendMode = blendMode
        )
    }
}
//
//@Preview
//@Composable
//fun ClearImage() {
//    BlendModeImage(BlendMode.Clear)
//}
//
//@Preview
//@Composable
//fun SrcImage() {
//    BlendModeImage(BlendMode.Src)
//}
//
//@Preview
//@Composable
//fun DstImage() {
//    BlendModeImage(BlendMode.Dst)
//}
//
//@Preview
//@Composable
//fun SrcOverImage() {
//    BlendModeImage(BlendMode.SrcOver)
//}
//
//@Preview
//@Composable
//fun DstOverImage() {
//    BlendModeImage(BlendMode.DstOver)
//}
//
//@Preview
//@Composable
//fun SrcInImage() {
//    BlendModeImage(BlendMode.SrcIn)
//}
//
//@Preview
//@Composable
//fun DstInImage() {
//    BlendModeImage(BlendMode.DstIn)
//}
//
//@Preview
//@Composable
//fun SrcOutImage() {
//    BlendModeImage(BlendMode.SrcOut)
//}
//
//@Preview
//@Composable
//fun DstOutImage() {
//    BlendModeImage(BlendMode.DstOut)
//}
//
//@Preview
//@Composable
//fun SrcAtopImage() {
//    BlendModeImage(BlendMode.SrcAtop)
//}
//
//@Preview
//@Composable
//fun DstAtopImage() {
//    BlendModeImage(BlendMode.DstAtop)
//}
//
//@Preview
//@Composable
//fun XorImage() {
//    BlendModeImage(BlendMode.Xor)
//}
//
//@Preview
//@Composable
//fun PlusImage() {
//    BlendModeImage(BlendMode.Plus)
//}
//
//@Preview
//@Composable
//fun ModulateImage() {
//    BlendModeImage(BlendMode.Modulate)
//}
//
//
//@Preview
//@Composable
//fun ScreenImage() {
//    BlendModeImage(BlendMode.Screen)
//}
//
//@Preview
//@Composable
//fun OverlayImage() {
//    BlendModeImage(BlendMode.Overlay)
//}
//
//@Preview
//@Composable
//fun DarkenImage() {
//    BlendModeImage(BlendMode.Darken)
//}
//
//@Preview
//@Composable
//fun LightenImage() {
//    BlendModeImage(BlendMode.Lighten)
//}
//
//@Preview
//@Composable
//fun ColorDodgeImage() {
//    BlendModeImage(BlendMode.ColorDodge)
//}
//
//@Preview
//@Composable
//fun ColorBurnImage() {
//    BlendModeImage(BlendMode.ColorBurn)
//}

@Preview
@Composable
fun HardlightImage() {
    BlendModeImage(BlendMode.Hardlight)
}

@Preview
@Composable
fun SoftlightImage() {
    BlendModeImage(BlendMode.Softlight)
}

@Preview
@Composable
fun DifferenceImage() {
    BlendModeImage(BlendMode.Difference)
}

@Preview
@Composable
fun ExclusionImage() {
    BlendModeImage(BlendMode.Exclusion)
}

@Preview
@Composable
fun HueImage() {
    BlendModeImage(BlendMode.Hue)
}

@Preview
@Composable
fun SaturationImage() {
    BlendModeImage(BlendMode.Saturation)
}

@Preview
@Composable
fun ColorImage() {
    BlendModeImage(BlendMode.Color)
}

@Preview
@Composable
fun LuminosityImage() {
    BlendModeImage(BlendMode.Luminosity)
}