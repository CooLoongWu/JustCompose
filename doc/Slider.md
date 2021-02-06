
@[TOC](Jetpack Compose - Slider)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍

> 拖动条，默认包含了一个滑块和一个滑动轨道。其允许用户在一个数值范围内进行选择。

## 1、属性一览
【目前基于alpha 11版本】请看该函数：
```
@Composable fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeEnd: () -> Unit = {},
    interactionState: InteractionState = remember { InteractionState() },
    thumbColor: Color = MaterialTheme.colors.primary,
    activeTrackColor: Color = MaterialTheme.colors.primary,
    inactiveTrackColor: Color = activeTrackColor.copy(alpha = InactiveTrackColorAlpha),
    activeTickColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = TickColorAlpha),
    inactiveTickColor: Color = activeTrackColor.copy(alpha = TickColorAlpha)
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
value: Float | 滑块的当前值，如果设置的值超过滑块可选值范围，则会强制为可选范围
onValueChange: (Float) -> Unit | 滑动滑块时候的回调当前的值
valueRange: ClosedFloatingPointRange<Float> = 0f..1f | 滑块可选值的范围，默认0-1f
steps: Int = 0 | 该值代表将拖动条均分为几等份。如果为0，那么是连续的值。如果是大于0，那么可选值范围会是指定的离散值（请见下文示例相关）
onValueChangeEnd: () -> Unit = {} | 滑块值更改结束时候的回调。注意该回调不是用来更新滑块的进度的，而是用户通过拖动或者点击滑块完成选择新的数值后才有的回调
interactionState: InteractionState = remember { InteractionState() } | 自定义滑块的属性相关，可以参见Button自定义的相关内容
thumbColor: Color = MaterialTheme.colors.primary | 拖动条的滑块的颜色
inactiveTrackColor: Color = activeTrackColor.copy(alpha = InactiveTrackColorAlpha) | 拖动条默认轨道的背景色
activeTrackColor: Color = MaterialTheme.colors.primary | 拖动条拖动滑块后激活部分轨道的颜色（请见下文示例）
inactiveTickColor: Color = activeTrackColor.copy(alpha = TickColorAlpha) | 设置了steps属性后的离散值默认颜色（请见下文示例）
activeTickColor: Color = MaterialTheme.colors.onPrimary.copy(alpha = TickColorAlpha) | 设置了steps属性后的激活的离散值的颜色（请见下文示例）

## 2、使用示例
我们先来看下一个极简的拖动条，代码如下：
```kotlin
@Composable
fun SliderDemo() {
    val progress = remember { mutableStateOf(0f) }

    Slider(
        value = progress.value,
        onValueChange = {
            progress.value = it
        },
    )
}
```
实现效果如下所示，所有的颜色是基于默认的主题色：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210206161521600.gif#pic_center)
现在我们先设置下如下三个属性，分别是红、灰、蓝：
```kotlin
thumbColor = myRed,
inactiveTrackColor = myGray,
activeTrackColor = myBlue,
```
请自行体会，对照上述属性：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210206161837648.gif#pic_center)
OK，现在继续设置下steps属性，还有另外两个可以自定义的颜色值：

```kotlin
steps = 10,
inactiveTickColor = myYellow,
activeTickColor = Color.White
```
效果如下所示，请自行对照属性理解：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210206162549422.gif#pic_center)

## 3、版本更新
- 暂无

## 4、未解决问题
以上只是实现了基本的拖动条功能，但是实际使用中UI设计可能完全不同，我们可以根据interactionState、自定义视图等的功能去实现，具体使用我们在自定义视图篇章中统一去处理。