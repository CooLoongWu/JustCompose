
@[TOC](Jetpack Compose - Scaffold、SnackBar)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
> 脚手架实现了Material设计的页面基本结构。该组件通过确保其适当的布局策略从而将其他的多个组件组合在一起构成页面。

其实也就是说该组件提供了组合各个组件的API，包括标题栏、底部栏、SnackBar（类似吐司功能）、浮动按钮、抽屉组件、剩余内容布局等，让我们可以快速定义一个基本的页面结构。

接下来通过其参数我们可以很简单的理解这个函数的作用，同时也将SnackBar结合进去。

## 1、属性一览
【目前基于alpha 11版本】函数如下：
```
@Composable fun Scaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: () -> Unit = emptyContent(),
    bottomBar: () -> Unit = emptyContent(),
    snackbarHost: (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    floatingActionButton: () -> Unit = emptyContent(),
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: ColumnScope.() -> Unit = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    bodyContent: (PaddingValues) -> Unit
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
scaffoldState: ScaffoldState = rememberScaffoldState() | 该脚手架的状态。例如控制抽屉的打开与否，组件的尺寸等
topBar: () -> Unit = emptyContent() | 屏幕顶部的标题栏
bottomBar: () -> Unit = emptyContent() | 屏幕底部的标题栏
snackbarHost: (SnackbarHostState) -> Unit = { SnackbarHost(it) } | 用来展示SnackBar的一个组件
floatingActionButton: () -> Unit = emptyContent() | 悬浮按钮
floatingActionButtonPosition: FabPosition = FabPosition.End | 悬浮按钮在屏幕上的位置
isFloatingActionButtonDocked: Boolean = false | 如果存在BottomBar，那么是否与BottomBar重叠一般的高度
drawerContent: ColumnScope.() -> Unit = null | 抽屉组件中的内容
drawerGesturesEnabled: Boolean = true | 是否允许手势控制抽屉的打开和关闭
drawerShape: Shape = MaterialTheme.shapes.large | 抽屉组件的形状
drawerElevation: Dp = DrawerDefaults.Elevation | 抽屉组件的阴影高度
drawerBackgroundColor: Color = MaterialTheme.colors.surface | 抽屉组件的背景色
drawerContentColor: Color = contentColorFor(drawerBackgroundColor) |  抽屉组件内容的背景色
drawerScrimColor: Color = DrawerDefaults.scrimColor | 抽屉组件打开时屏幕剩余部分的遮盖颜色
backgroundColor: Color = MaterialTheme.colors.background | 脚手架组件的背景色
contentColor: Color = contentColorFor(backgroundColor) | 脚手架组件内容的背景色
bodyContent: (PaddingValues) -> Unit | 脚手架中的组件
## 2、使用示例
我们使用Scaffold可以很方便的实现包含抽屉布局的UI，代码如下：
```kotlin
@Composable
fun ScaffoldDemo() {

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "抽屉组件中内容")
            }

        },

        //标题栏区域
        topBar = {
            TopAppBar(
                title = { Text(text = "脚手架示例") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scaffoldState.drawerState.open()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        },

        //悬浮按钮
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("悬浮按钮") },
                onClick = { }
            )
        },
        floatingActionButtonPosition = FabPosition.End,

        //屏幕内容区域
        bodyContent = {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "屏幕内容区域")
            }
        },
    )
}
```
实现效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210209220524406.gif#pic_center)
一个很简单的侧滑抽屉的功能就完成了。
接下来我们使用下SnackBar的功能，添加如下相关的参数，然后我们在点击悬浮按钮的时候添加点击事件，如下所示：
```kotlin
val scope = rememberCoroutineScope()

//悬浮按钮
floatingActionButton = {
    ExtendedFloatingActionButton(
        text = { Text("悬浮按钮") },
        onClick = {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("点击了悬浮按钮")
            }
        }
    )
},
```
SnackBar显示效果如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210209220639877.gif#pic_center)
当然了如果你想自定义SnackBar显示的外观也可以通过snackbarHost参数来定义，如下我们定义了一个红色背景，白色内容，切角边框的SnackBar：
```kotlin
snackbarHost = {
    SnackbarHost(it) { data ->
        Snackbar(
            snackbarData = data,
            backgroundColor = myRed,
            contentColor = Color.White,
            shape = CutCornerShape(10.dp)
        )
    }
},
```
显示效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210209233431890.gif#pic_center)

## 3、版本更新
- 暂无

## 4、未解决问题
暂无。关于Scaffold官方还有另外两种实现：BackdropScaffold和BottomSheetScaffold，具体使用上没有什么大的问题，和Scaffold类似，大家可以自定运行查看相关效果，如果是自己平常开发中需要的，那么直接使用即可。