@[TOC](Jetpack Compose - Icon)

## 1、属性一览
首先直接看下官网给的Icon的三种方法，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#icon)：
```
@Composable fun Icon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = AmbientContentColor.current.copy(alpha = AmbientContentAlpha.current)
): Unit
```

```
@Composable fun Icon(
    bitmap: ImageBitmap,
    modifier: Modifier = Modifier,
    tint: Color = AmbientContentColor.current
): Unit
```

```
@Composable fun Icon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = AmbientContentColor.current.copy(alpha = AmbientContentAlpha.current)
): Unit
```

这三种方式的区别就在于 第一个参数，可以是 ImageVector，ImageBitmap，Painter类型：

- imageVector: ImageVector
		可以使用imageResource(id = R.drawable.xxx)来加载图片。也可以使用 androidx.compose.material.icons 包下的Icons中提供的资源，例如：
- bitmap: ImageBitmap
	应用bitmap资源【PS：但是我目前在alpha07的包中居然没有找到ImageBitmap的相关类】；
- painter: Painter
	暂时还不清楚如何使用；
- modifier: Modifier = Modifier
	修饰符
- tint: Color = AmbientContentColor.current.copy(alpha = AmbientContentAlpha.current)
	应用于Icon的色调。**如果提供了Color.Unspecified，则不会应用任何色调**。




## 2、使用示例

接下来请看一段示例代码，该代码使用的是androidx.compose.material.icons.Icons中提供的资源，如下所示：
```
@Composable
fun IconDemo() {
    Icon(
        asset = Icons.Outlined.Face,
    )
}
```
上述代码中我们直接设置了一张“人脸”的图标，AS中预览如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020120718524934.png#pic_center)
当添加tint属性 ```tint = Color.White```后，图标就会变成白色的样式，这里不再示例。

接下来我们添加自己的图片资源文件，资源图片如下所示：![在这里插入图片描述](https://img-blog.csdnimg.cn/20201207185705138.png#pic_center)

```
@Composable
fun IconDemo() {
    Icon(
        asset = imageResource(id = R.drawable.fire)
    )
}
```
此时预览的效果是黑乎乎的一团：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201207185822531.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
因为默认的tint模式是 **AmbientContentColor.current** ，我们需要去掉它默认的着色模式，所以需要将tint的属性设置为Color.Unspecified，此时图片的显示效果就正常了：
```
@Composable
fun IconDemo() {
    Icon(
        asset = imageResource(id = R.drawable.fire),
        tint = Color.Unspecified
    )
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201207190128555.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)

## 3、未解决问题
该控件暂时也没有其他的问题，关于Painter的目前还不清楚如何使用，等研究到了再继续完善文档。

