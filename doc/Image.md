@[TOC](Jetpack Compose - Image)

注意：当前是alpha07版本的Compose，Image控件是在foundation包中的。material包中没有。
## 1、属性一览
首先直接看下官网给的方法，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/foundation/package-summary#image)：
```
@Composable inline fun Image(
    asset: ImageAsset,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
): Unit
```

```
@Composable inline fun Image(
    asset: VectorAsset,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
): Unit
```

```
@Composable fun Image(
    painter: Painter,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
): Unit
```
这三种方法区别在第一个参数：

- asset: ImageAsset
	使用的是图片资源，我们可以使用 ImageResources.kt中的imageResource(@DrawableRes id: Int): ImageAsset 方法来加载，但是该方法可能会被废弃，因为Google可能更提倡异步加载的方案，见同类中的loadImageResource方法；

- asset: VectorAsset,
	使用的是矢量资源，我们可以使用VectorResources.kt中的vectorResource(@DrawableRes id: Int): VectorAsset方法来加载，但是该方法可能会被废弃，因为Google可能更提倡异步加载的方案，见同类中的loadVectorResource方法；

- painter: Painter
	这个可能就涉及到了画笔画布的类似操作，目前还不清楚如何使用；

- modifier: Modifier = Modifier
	这个时候Modifier的作用就出来了，我们可以给图片设置裁剪形状，设置边框等操作

- alignment: Alignment = Alignment.Center
	对齐方式

- contentScale: ContentScale = ContentScale.Fit
	如果设置的边界大小和图片资源的大小不同，那么就使用该参数来确定要使用的缩放比例，类同于ImageView中的ScaleType属性了。

- alpha: Float = DefaultAlpha
	不透明度

- colorFilter: ColorFilter? = null
	将某种颜色应用到图片上





## 2、使用示例
我们将400*200的一张图片放到drawable目录下，然后下文代码中使用它：
```
@Composable
fun ImageDemo() {
    Image(
            asset = imageResource(id = R.drawable.demo),
    )
}
```
最简单的代码如上所示，此时图片会全部展示在页面上：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201202205219510.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
然后我们设置下修饰符相关的属性，设置其宽高为100，然后剧中裁剪，代码吐下所示：
```
@Composable
fun ImageDemo() {
    Image(
            asset = imageResource(id = R.drawable.demo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
    )
}
```
结果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201202205509544.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
像一些圆角或者圆形图片的设置，就可以在修饰符中进行配置了，直接看代码：
```
@Composable
fun ImageDemo() {
    Image(
            asset = imageResource(id = R.drawable.demo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(50)
                    )
    )
}
```
首先clip属性中我们给该图片指定了圆角的形状，圆角百分比50，也就是圆形了。
然后在border属性中我们给这个图片指定了一个宽度2dp，颜色为白色的，也是圆形的边框。
所以效果图如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201202210016892.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)


## 3、未解决问题
上面的代码基本可以解决大部分图片使用的问题了，但是有一个很重要的问题就是如何加载网络图片，并且处理好缓存等相关问题。
在上面中提到的一些API中，有注释写着Google推荐使用异步加载的方式，那么有没有可能直接提供出图片加载的框架呢，或许其他第三方的图片框架已经跃跃欲试开始适配Compose了呢？
