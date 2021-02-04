
@[TOC](Jetpack Compose - Modifier入门篇)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍

> 一个 **有序的**、**不可变的**修饰元素集合，用于添加装饰或者行为到Compose UI元素。例如background、padding 、点击事件等。或者给Text设置单行、给Button设置各种点击状态等行为。

我们先拿XML中的FrameLayout做下对比，如下，我们在xml文件中定义了一个 ***宽度填充满父容器，高度200dp，背景为黑色，内容边距为16dp的*** FrameLayout：
```xml
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:background="#000000"
        android:padding="16dp" >
		<-- 可配置子级元素 -->
	</FrameLayout>
```
那么在Compose中如何实现这样的UI呢？直接来看结果，了解下Modifier是如何配合Composable函数实现的：
```kotlin
@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Black)
            .padding(16.dp),
    ) {
    	//可配置子级元素
    }
}
```
首先我们需要定义一个使用```@Composable```注解的函数BoxDemo()，在该函数中使用Compose提供的Box()函数，来实现类似XML中的FrameLayout效果。Box()函数有一个Modifier参数，我们设置下Modifier的各种属性，例如宽度填充满父容器，可以使用```.fillMaxWidth()```；高度200dp，可以使用```.height(200.dp)```;背景为黑色，可以使用```.background(Color.Black)```；边距16dp，可以使用```.padding(16.dp)```；这样通过给Box()设置相关的修饰符，我们就可以实现所需的显示效果；

Modifier基本的使用就类似上文一样，设置或者组合不同的属性给UI函数即可。注意官方的描述中**有序的**一词，在使用的过程中属性定义的顺序确实会影响到UI的显示效果。我们在下文示例中再详细描述，接下来一起看下Modifier可配置的属性吧。
## 1、属性一览
【目前基于alpha 11版本】Modifier可配置的属性太多了，而且分布在好几个包中，如有遗漏请自行查看[Compose Modifier相关文档](https://developer.android.google.cn/reference/kotlin/androidx/compose/ui/Modifier)：
### 1.1、androidx.compose.foundation.layout包
- ```Modifier.width(width: Dp)```
	设置自身的宽度，单位dp；
- ```Modifier.widthIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified)```
	设置自身的最小和最大宽度（当子级元素超过自身时，子级元素超出部分依旧可见）；
- ```Modifier.fillMaxWidth(fraction: Float = 1f)```
	默认横向填充满父容器的宽度，参数可以控制宽度的比例。例如0.5就是当前元素占父元素宽度的一半；
- ```Modifier.wrapContentWidth(align: Alignment.Horizontal = Alignment.CenterHorizontally, unbounded: Boolean = false)```
	根据**子级**元素的宽度来确定自身的宽度，如果自身设置了最小宽度的话则会被忽略。当unbounded参数为true的时候，自身设置了最大宽度的话也会被忽略；
- ```Modifier.preferredWidth(width: Dp)```
	设置自身的首选宽度，单位dp；
- ```Modifier.preferredWidth(intrinsicSize: IntrinsicSize)```
	设置自身的首选宽度为与子级元素的最小或最大宽度相同（还在实验阶段）；
- ```Modifier.preferredWidthIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified)```
	设置自身的首选最小和最大宽度；

-----
以上就是宽度的相关属性，那么类似的，高度属性如下所示（就不再具体说明啦）：
- ```Modifier.height(height: Dp)```
- ```Modifier.heightIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified)```
- ```Modifier.fillMaxHeight(fraction: Float = 1f)```
- ```Modifier.wrapContentHeight(align: Alignment.Vertical = Alignment.CenterVertically, unbounded: Boolean = false)```
- ```Modifier.preferredHeight(intrinsicSize: IntrinsicSize)```
- ```Modifier.preferredHeight(height: Dp)```
- ```Modifier.preferredHeightIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified)```
-----
OK，宽高分别的属性定义都有了，假如我想同时控制宽高的属性呢？有！请看size相关函数：
- ```Modifier.size(size: Dp)```
- ```Modifier.size(width: Dp, height: Dp)```
- ```Modifier.sizeIn(minWidth: Dp = Dp.Unspecified, minHeight: Dp = Dp.Unspecified, maxWidth: Dp = Dp.Unspecified, maxHeight: Dp = Dp.Unspecified)```
- ```Modifier.fillMaxSize(fraction: Float = 1f)```
- ```Modifier.wrapContentSize(align: Alignment = Alignment.Center, unbounded: Boolean = false)```
- ```Modifier.preferredSize(size: Dp)```
- ```Modifier.preferredSize(width: Dp, height: Dp)```
- ```Modifier.preferredSizeIn(minWidth: Dp = Dp.Unspecified, minHeight: Dp = Dp.Unspecified, maxWidth: Dp = Dp.Unspecified, maxHeight: Dp = Dp.Unspecified)```
-----
接下来到了设置填充（padding）的时间了：
- ```Modifier.padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp)```
	分别在四个方向上设置填充；
- ```Modifier.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp)```
	分别在横向和纵向上设置填充；
- ```Modifier.padding(all: Dp)```
	统一设置所有方向上的填充；
- ```Modifier.padding(padding: PaddingValues)```
	根据参数PaddingValues来设置填充，PaddingValues参数可以理解为以上三种方式的封装；
- ```Modifier.absolutePadding(left: Dp = 0.dp, top: Dp = 0.dp, right: Dp = 0.dp, bottom: Dp = 0.dp)```
	不处理国际化问题，按照绝对的上下左右方向设置填充；

以下两个是针对有Text情况下的填充，因为有BaseLine等相关属性（不了解Baseline的可以先百度搜索下：TextView Baseline先进行阅读），阅读类App对该属性要求可能比较严格，平常开发中貌似几乎没有使用过类似属性。下面简单说下这几个函数（以博主本人的语言功底应该是描述不清楚的，所以后文我们会根据示例实际演示下）：
- ```Modifier.paddingFromBaseline(top: Dp = Dp.Unspecified, bottom: Dp = Dp.Unspecified)```
- ```Modifier.paddingFromBaseline(top: TextUnit = TextUnit.Unspecified, bottom: TextUnit = TextUnit.Unspecified)```

 当子级元素有Baseline属性时，例如子级元素有Text，那么 .paddingFromBaseline(top = 50.dp) 表示文本 **第一行** Baseline的位置距离父级 ***顶部*** 为50dp， .paddingFromBaseline(bottom= 50.dp) 表示文本 **最后一行** Baseline的位置距离父级 ***底部*** 为50dp。请看下文示例2.1 。 （在API28，XML中TextView提供了  android:firstBaselineToTopHeight="" 属性，对应这个就可以很好理解了）

上文面只是讲解了单位为dp情况下的内容，当单位为TextUnit的时候道理类似，只是Text可以设置为16.sp或者16.em。

- ```Modifier.paddingFrom(alignmentLine: AlignmentLine, before: Dp = Dp.Unspecified, after: Dp = Dp.Unspecified)```
- ```Modifier.paddingFrom(alignmentLine: AlignmentLine, before: TextUnit = TextUnit.Unspecified, after: TextUnit = TextUnit.Unspecified)```
- ```Modifier.relativePaddingFrom(alignmentLine: AlignmentLine, before: Dp = Dp.Unspecified, after: Dp = Dp.Unspecified)```
 以上几个函数暂时还未研究，待续。
-----
接下来是margin的时间，啊？翻遍了文档，没有margin属性，是不是官方不建议我们使用margin这种方式了呢？可能是建议我们使用padding或者Spacer()函数来实现？那我们来看下offset，乍一看好像能实现类似的margin属性，但是实际情况不是这么用的，应该是让我们在做动画的时候使用该函数：
 - ```Modifier.offset(x: Dp = 0.dp, y: Dp = 0.dp)```
	水平和竖直方向上的偏移，单位dp，值可以为正也可以为负，无需考虑国际化的问题。
- ```Modifier.offset(offset: Density.() -> IntOffset)```
	偏移，单位px，可以结合动画进行元素的偏移处理；
-  ~~```Modifier.offsetPx(x: State<Float> = mutableStateOf(0f), y: State<Float> = mutableStateOf(0f))```~~
	带有状态的偏移量【已废弃】，请使用上一个函数；
- ```Modifier.absoluteOffset(x: Dp = 0.dp, y: Dp = 0.dp)```
- ```Modifier.absoluteOffset(offset: Density.() -> IntOffset)```
- ~~```Modifier.absoluteOffsetPx(x: State<Float> = mutableStateOf(0f), y: State<Float> = mutableStateOf(0f))```~~
	不考虑国际化情况下的偏移，使用绝对方向

-----
- ```Modifier.aspectRatio(ratio: Float, matchHeightConstraintsFirst: Boolean = false)```
	按照宽高比例进行设置，例如以下代码可以绘制出宽度为80dp，高度为40dp的一个Box（该函数还有待研究，绝不会这么简单）：
	```kotlin
	 Box(
                modifier = Modifier
                    .width(80.dp)
                    .aspectRatio(ratio = 2f, matchHeightConstraintsFirst = false),
            )
	```

androidx.compose.foundation.layout包中的修饰符属性我们先研究这么多，下一个包！

### 1.2、androidx.compose.ui.draw包
- ```Modifier.alpha(alpha: Float)```
	不透明度，范围从0-1；
- ```Modifier.clip(shape: Shape)```
	裁剪为相应的形状，例如shape = RoundedCornerShape(20) 表示裁剪为20%圆角的矩形。这个时候需要注意了，如果你结合background()函数，那么有必要注意下顺序，必须clip()在前，background()在后。否则的话背景色不会被裁切。
- ```Modifier.clipToBounds()```
	暂时还不清楚作用；
- ~~```Modifier.drawOpacity(opacity: Float)```~~
	不透明度，已废弃，请使用alpha函数
- ~~```Modifier.drawShadow(elevation: Dp, shape: Shape = RectangleShape, clip: Boolean = elevation > 0.dp)```~~
	绘制阴影效果，已废弃，请使用shadow函数
- ```Modifier.shadow(elevation: Dp, shape: Shape = RectangleShape, clip: Boolean = elevation > 0.dp)```
	绘制阴影效果
- ```Modifier.rotate(degrees: Float)```
	设置视图围绕其中心旋转的角度；
- ```Modifier.scale(scaleX: Float, scaleY: Float)```
- ```Modifier.scale(scale: Float)```
	设置视图的缩放比例；

### 1.3、androidx.compose.foundation包
背景边框相关
- ```Modifier.background(color: Color, shape: Shape = RectangleShape)```
	设置背景色；
- ```Modifier.background(brush: Brush, shape: Shape = RectangleShape, alpha: Float = 1.0f)```
	使用Brush来设置背景色，例如常见的渐变色效果，见下文2.2示例；
- ```Modifier.border(border: BorderStroke, shape: Shape = RectangleShape)```
	绘制指定形状的边框，渐变色效果使用该函数可以实现；
- ```Modifier.border(width: Dp, color: Color, shape: Shape = RectangleShape)```
	绘制指定宽度、颜色、形状的边框；
- ```Modifier.border(width: Dp, brush: Brush, shape: Shape)```
	绘制指定宽度、brush、形状的边框，渐变色效果可以使用该函数实现；

-----
点击事件相关

- ```Modifier.clickable(enabled: Boolean = true, onClickLabel: String? = null, role: Role? = null, onLongClickLabel: String? = null, onLongClick: () -> Unit = null, onDoubleClick: () -> Unit = null, onClick: () -> Unit)```
- ```Modifier.clickable(enabled: Boolean = true, interactionState: InteractionState, indication: Indication?, onClickLabel: String? = null, role: Role? = null, onLongClickLabel: String? = null, onLongClick: () -> Unit = null, onDoubleClick: () -> Unit = null, onClick: () -> Unit)```
	可以看到，启用状态enabled、响应状态interactionState、单击、双击、长按事件都可以在此处处理。具体使用请查看系列文章的Button相关。

-----
滚动相关

在alpha11版本之前，滚动视图是ScrollableRow、ScrollableColumn实现的。在alpha 11版本，Modifier中添加了如下两个函数，在Row或者Column中，我们使用这两个函数就可以在子级元素过宽、过长情况下开启滚动模式了。
- ```Modifier.horizontalScroll(state: ScrollState, enabled: Boolean = true, reverseScrolling: Boolean = false)```
- ```Modifier.verticalScroll(state: ScrollState, enabled: Boolean = true, reverseScrolling: Boolean = false)```
具体使用示例请查看系列文章之[【Jetpack Compose - Row、Column】](https://blog.csdn.net/u010976213/article/details/111064923)；
## 2、使用示例

### 2.1、paddingFromBaseline
首先我们实现如下布局，蓝色Box中所有子级元素居中处理，所以红色分割线是居中线，我们下文需要参考该线进行理解。绿色Box中按照默认布局方式分别添加了黄色Box和白色Text两个元素。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210204180534742.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
全部代码如下所示：
```kotlin
@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .width(400.dp)
            .height(120.dp)
            .background(myBlue),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color = myGreen)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = myYellow),
            )

            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Compose",
                color = Color.White
            )
        }

        //水平分割线
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = myRed)
        )
    }
}
```
当我们给绿色Box添加```.paddingFromBaseline(top = 50.dp)```属性后，可以看到UI显示效果为：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210204181055196.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
文本：绿色Box的宽高为100dp，设置该属性后，表示Text的Baseline位置需要位于高度为50dp处，也就是在红线标志的位置，所以文本整体的摆放如上所示。

黄色Box：可以看到黄色Box并不是从绿色Box的50dp处开始摆放的，而是从Text顶部开始摆放。怎么理解？假如Text的Baseline到Text顶部的距离是10dp，那么目前博主也就是理解为```.paddingFromBaseline(top = 50.dp) ```等于 ```.padding(top = (50-10).dp)```（如果此处有疑问请一定及时告知博主，唯恐误导各位同学）。

当我们保留上述属性，但是去掉Text元素的时候，显示效果又如下所示，此时我们不妨理解为，没有Baseline属性的元素时，```.paddingFromBaseline(top = 50.dp) ```等于 ```.padding(top = 50.dp)```：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210204185144219.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
### 2.2、background
如何实现渐变色的效果呢，使用Brush，直接看代码：
```kotlin
@Composable
fun GradientBox() {
    val colorList = arrayListOf(Color(0xFF25BC6B), Color(0xFFFFCA1C))
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .background(
                brush = Brush.horizontalGradient(colorList),
                shape = RoundedCornerShape(50)
            )
    )
}
```
如下所示，还有shape指定的圆角效果哦：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021020420105464.png#pic_center)

## 3、版本更新
- 暂无

## 4、未解决问题
关于Modifier其实还有很多特殊情况我们可能都没有遇到，本文只是重点列出了博主在实际开发中遇到的一些基础问题，后续遇到其他情况欢迎各位一起探讨。

到进阶篇的话我们会涉及到动画、自定义视图、手势等相关内容，一起努力吧！！！