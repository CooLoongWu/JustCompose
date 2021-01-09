
@[TOC](Jetpack Compose - TopAppBar、BottomAppBar)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
关于AppBar其实就是XML中的androidx.appcompat.widget.Toolbar，关于这个控件可能我们大家用的不会很多，一般都是自己自定义的，这篇文章简单来学习下Compose中的方案。
- TopAppBar
> TopAppBar显示与当前屏幕有关的信息和操作，位于屏幕的顶部。一般包含标题，导航图标和其他的更多操作等。

- BottomAppBar
> BottomAppBar也是显示与当前屏幕有关的信息和操作，但是其位于屏幕的底部。

## 1、属性一览
【目前基于alpha09版本】

#### 1.1、TopAppBar
该控件有两个函数：
```
@Composable fun TopAppBar(
    title: () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: () -> Unit = null,
    actions: RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = TopAppBarElevation
): Unit
```


属性参数含义：

参数 | 含义
:----- |:-----
title: () -> Unit | 显示在TopAppBar中心的标题
navigationIcon: () -> Unit = null | 导航图标显示在TopAppBar的开头。通常应为IconButton或IconToggleButton
actions: RowScope.() -> Unit = {} | 其他行为，例如设置、更多等
backgroundColor: Color = MaterialTheme.colors.primarySurface | TopAppBar的背景颜色
contentColor: Color = contentColorFor(backgroundColor) | 子级内容的颜色，默认和TopAppBar的颜色相同
elevation: Dp = TopAppBarElevation | 标题栏的阴影效果，设置为0则没有阴影


第二个函数：
```
@Composable fun TopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = TopAppBarElevation,
    content: RowScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
backgroundColor: Color = MaterialTheme.colors.primarySurface | TopAppBar的背景颜色
contentColor: Color = contentColorFor(backgroundColor) | 子级内容的颜色，默认和TopAppBar的颜色相同
elevation: Dp = TopAppBarElevation | 标题栏的阴影效果，设置为0则没有阴影
content: RowScope.() -> Unit | 该TopAppBar的内容。默认横向布局，子级内容将水平放置

该函数跟第一个函数相比，我们可以更方便的自定义布局内容。该函数跟BottomAppBar的函数类似，所以针对该函数的效果，请参考下方的BottomAppBar的效果。

#### 1.2、 BottomAppBar
该控件只有一个函数，如下所示（关于他的第三个参数，其实是涉及到FloatingActionButton这个控件的，我们到这个控件的时候再讲解改参数）：
```
@Composable fun BottomAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    cutoutShape: Shape? = null,
    elevation: Dp = BottomAppBarElevation,
    content: RowScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
backgroundColor: Color = MaterialTheme.colors.primarySurface | TopAppBar的背景颜色
contentColor: Color = contentColorFor(backgroundColor) | 子级内容的颜色，默认和BottomAppBar的颜色相同
cutoutShape: Shape? = null | 将添加到BottomAppBar中的切口的形状-当在Scaffold中一起使用BottomAppBar和FloatingActionButton时，该形状通常应与FloatingActionButton中使用的形状相同。此形状将在所有侧面上偏移绘制。如果为null，则将没有切口。
elevation: Dp = BottomAppBarElevation |
content: RowScope.() -> Unit | 该BottomAppBar的内容。默认横向布局，子级内容将水平放置
## 2、使用示例
#### 2.1、 TopAppBar
我们使用第一个函数进行演示，我们定义了标题内容，以及返回按钮，然后在右侧添加了两个用于其他操作的IconButton，代码如下：
```
@Composable
fun TopAppBarDemo() {
    TopAppBar(
        title = { Text("这是标题") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.ArrowBack)
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Share)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Settings)
            }
        }
    )
}
```
预览效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210109224731109.png#pic_center)


#### 2.2、 BottomAppBar
我们直接声明一个底部标题栏，然后水平放置文本和一个操作按钮，Spacer相当于把去除Text和IconButtom的区域全部填充满了，代码如下所示：
```
@Composable
fun BottomAppBarDemo() {
    BottomAppBar {
        Text(text = "底部标题栏")

        Spacer(Modifier.weight(1f, true))

        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite)
        }
    }
}
```
效果图如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021010923033378.png#pic_center)


## 3、版本更新
- 暂无

## 4、未解决问题
该控件不知道大家用的多不多，其实一般情况下我们都是自己结合App的特色统一自定义的标题栏，官方的这个目前就不多做研究了。