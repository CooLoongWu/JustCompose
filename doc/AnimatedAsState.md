
@[TOC](Jetpack Compose - animateXxxAsState)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
根据官网对所有相关的animateXxxAsState()函数做了一个简单的总结。
> Fire-and-forget animation function（自主制导的动画函数？）。对于不同的参数类型（例如Float，Color，Offset等），此Composable函数将重载。**更改提供的targetValue时，动画将自动运行。** 如果targetValue发生更改时，如果已经有一个进行中的动画，则正在进行的动画将调整航向以朝新的目标值进行动画处理。

> (Fire-and-Forget)泛指武器在发射之后，就不再接受任何外界指挥、管制或者是射控系统的资料，能够自行更新坐标或者是目标的讯息。

从介绍中的 **更改提供的targetValue时，动画将自动运行**。 我们可以看出这有点类似于View时代的 ***值动画***，更改值后视图做对应的变化。但是使用Compose更加的简单、方便、高效。

## 1、属性一览
【目前基于beta 01版本】我们先来看下animateDpAsState()函数，根据函数名我们可以知道该函数会根据你设置的Dp值来自动执行动画：
```
@Composable fun animateDpAsState(
    targetValue: Dp,
    animationSpec: AnimationSpec<Dp> = dpDefaultSpring,
    finishedListener: (Dp) -> Unit = null
): State<Dp>
```

属性参数含义：

参数 | 含义
:----- |:-----
targetValue: Dp | 动画的目标值
animationSpec: AnimationSpec<Dp> = dpDefaultSpring | 用于随着时间更改值的动画。默认情况下将使用物理动画
finishedListener: (Dp) -> Unit = null | 可选的动画结束事件监听器

## 2、使用示例
首选我们来看一个场景，屏幕上有一个Box，我们想点击该Box时更改它的宽度Dp属性，代码如下：
```kotlin
@Composable
fun AnimatedDpAsState() {
    val big = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(
                if (big.value) {
                    300.dp
                } else {
                    120.dp
                }
            )
            .background(color = myBlue)
            .clickable {
                big.value = !big.value
            }
    )
}
```
点击效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210309211009689.gif#pic_center)

在上面的示例中，变化是有点生硬的，宽度从120.dp突变到了300.dp。接下来使用animateDpAsState()函数来给其添加渐变的动画属性，直接看代码：
```kotlin
@Composable
fun AnimatedDpAsState() {

    val big = remember { mutableStateOf(false) }

	//主要看这里
    val width: Dp by animateDpAsState(
        if (big.value) {
            300.dp
        } else {
            120.dp
        }
    )

    Box(
        modifier = Modifier
            .height(50.dp)
            .width(width)
            .background(color = myBlue)
            .clickable {
                big.value = !big.value
            }
    )
}
```
在上面代码中我们依旧根据记录的big的值来进行宽度的变化，默认是120.dp，当big的值变化时，width的值会从120.dp渐变到300.dp，相应的Compose函数会根据width的值响应式的自动改变UI，效果如下所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210309211308311.gif#pic_center)
好像可以了，但是动画的速度太快了，我想让动画的执行时间更长一些，那么就需要查看第二个参数了```animationSpec: AnimationSpec<Dp>```，改参数规定了动画的执行规范，实现了AnimationSpec接口的有：
- FloatSpringSpec
- FloatTweenSpec
- InfiniteRepeatableSpec
- KeyframesSpec
- RepeatableSpec
- SnapSpec
- SpringSpec
- TweenSpec
	使用给定的持续时间、延迟和缓和曲线（类似于插值器）创建一个TweenSpec【渐变规范】。

我们先看下最后一个实现类TweenSpec，Compose还提供了一个直接可用的顶层函数```tween()```：
```
@Stable
fun <T> tween(
    durationMillis: Int = DefaultDurationMillis,
    delayMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): TweenSpec<T> = TweenSpec(durationMillis, delayMillis, easing)
```
该函数默认使用FastOutSlowInEasing的插值器，我们直接给animateDpAsState()函数添加animationSpec 参数，如下所示：
```kotlin
animationSpec = tween(durationMillis = 2000)
```
设置了动画的持续时间为2秒，看下执行效果吧：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210309211227108.gif#pic_center)


OK，这就是animateDpAsState()函数，是不是很简单的就实现了渐变的效果。

Compose还提供了类似的一系列函数，如下：
- **animateDpAsState**
	更改Dp的值，例如：
	```Modifier.width()、height()、offset()```等；
	（所以平移动画可以使用该函数来实现了）
- **animateFloatAsState**
	更改Float值，例如：
	```Modifier.alpha()、rotate()、scale()```、
	```Color(red: Float, green: Float, blue: Float, alpha: Float = 1f, colorSpace:  ColorSpace = ColorSpaces.Srgb)```等；
	（所以旋转、缩放、渐变动画都可以使用该函数来实现了）
- **animateIntAsState**
- **animateIntOffsetAsState**
- **animateIntSizeAsState**
- **animateOffsetAsState**
- **animateRectAsState**
- **animateSizeAsState**
- **animateValueAsState**
	可以自定义更改任何值类型的动画，这就让我们可以不局限于以上所提供的函数了，大胆发挥你的脑洞吧。



## 3、版本更新
- 暂无

## 4、未解决问题
目前只考虑到了我们平常最常用的平移、渐变、缩放、旋转的相关动画，后续自定义视图的时候还会有其他问题暴露出来，例如动画导致的视图树结构更改等，后续自定义的文章遇到问题我们再仔细探究。