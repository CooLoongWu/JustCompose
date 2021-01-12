
@[TOC](Jetpack Compose - TabRow、ScrollableTabRow)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
#### 0.1、TabRow
> TabRow包含一行Tab，并在当前选定的Tab下方显示一个指示器。 TabRow将其Tab在整行中均匀分布，每个选项卡占用相等的空间。

#### 0.2、ScrollableTabRow
> ScrollableTabRow包含一行Tab，并在当前选定的选项卡下方显示一个指示器。 ScrollableTabRow将其Tab从起始位置开始放置，并允许滚动到屏幕外放置的Tab。

#### 0.3、Tab
> 通常用于TabRow内部，一般是使用文本或图标表示。
## 1、属性一览
【目前基于alpha09版本】
#### 1.1、TabRow：
```
@Composable fun TabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    indicator: (tabPositions: List<TabPosition>) -> Unit = { tabPositions ->
        TabDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
        )
    },
    divider: () -> Unit = {
        TabDefaults.Divider()
    },
    tabs: () -> Unit
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
selectedTabIndex: Int | 当前所选Tab的索引
backgroundColor: Color = MaterialTheme.colors.primarySurface | TabRow的背景颜色
contentColor: Color = contentColorFor(backgroundColor) | 内容子级的颜色
indicator: (tabPositions: List<TabPosition>) -> Unit = { tabPositions -> TabDefaults.Indicator( Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]) ) } | 代表当前选择哪个Tab的指示器。默认情况下，它是一个TabDefaults.Indicator，使用TabDefaults.tabIndicatorOffset修饰符为其位置设置动画
divider: () -> Unit = { TabDefaults.Divider() } | 显示在TabRow底部的分隔线
tabs: () -> Unit | 此TabRow中的选项卡。通常包含多个选项卡。将测量此lambda中的每个元素，并将其均匀地放置在TabRow上，每个元素占据相等的空间。

#### 1.2、ScrollableTabRow
```
@Composable fun ScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    edgePadding: Dp = TabDefaults.ScrollableTabRowPadding,
    indicator: (tabPositions: List<TabPosition>) -> Unit = { tabPositions ->
        TabDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
        )
    },
    divider: () -> Unit = {
        TabDefaults.Divider()
    },
    tabs: () -> Unit
): Unit
```
该函数和上面函数参数类似，这里只介绍一个不同的参数：

参数 | 含义
:----- |:-----
edgePadding: Dp = TabDefaults.ScrollableTabRowPadding | ScrollableTabRow的开始和结束边缘与其内部选项卡之间的距离（默认是有52dp的一个padding）


#### 1.3、Tab
关于tab有两个函数，如下：
```
@Composable fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: () -> Unit = emptyContent(),
    icon: () -> Unit = emptyContent(),
    interactionState: InteractionState = remember { InteractionState() },
    selectedContentColor: Color = AmbientContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
): Unit
```

```
@Composable fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionState: InteractionState = remember { InteractionState() },
    selectedContentColor: Color = AmbientContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium),
    content: ColumnScope.() -> Unit
): Unit
```
参数 | 含义
:----- |:-----
selected: Boolean | 该Tab是否被选中
onClick: () -> Unit | 点击该Tab时候的回调事件
modifier: Modifier = Modifier | 应用于该Tab的修饰符
text: () -> Unit = emptyContent() | 显示在该Tab中的文本
icon: () -> Unit = emptyContent() | 显示在该Tab中的图标
interactionState: InteractionState = remember { InteractionState() } | 该Tab的交互状态
selectedContentColor: Color = AmbientContentColor.current | 选中该Tab时内容的颜色，以及水波纹的颜色
unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium) | 未选中该Tab时内容的颜色

当我们需要自定义Tab的时候可以使用第二个函数，自定义参数如下：
参数 | 含义
:----- |:-----
content: ColumnScope.() -> Unit| 自定义Tab的内容，默认是纵向布局

## 2、使用示例
我们直接对比这两个函数来使用，在TabRow中我们定义了3个Tab，第三个Tab的内容很长，在ScrollableTabRow中我们定义了5个Tab，第五个Tab的内容很长，代码如下：
```

@Composable
fun TabRowDemo() {
    var state = remember { mutableStateOf(0) }
    val titles = listOf("标签1", "标签2", "这是很长的标签3")

    Column {
        TabRow(selectedTabIndex = state.value) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state.value == index,
                    onClick = { state.value = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "第${state.value + 1}个标签被选中了",
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun ScrollableTabRowDemo() {
    var state = remember { mutableStateOf(0) }
    val titles = listOf("标签1", "标签2", "标签3", "标签4", "这是很长的标签5")
    Column {
        ScrollableTabRow(
            selectedTabIndex = state.value,
            modifier = Modifier.wrapContentWidth(),
            edgePadding = 16.dp
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state.value == index,
                    onClick = { state.value = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "第${state.value + 1}个标签被选中了",
            style = MaterialTheme.typography.body1
        )
    }
}
```

所以实现效果如下所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210113003945330.gif#pic_center)

## 3、版本更新
- 暂无

## 4、未解决问题
目前TabRow的基本使用就是这样了，关于自定义的内容我们稍后再讲，现在还没有ViewPager的相关信息，很期待在Compose中ViewPager将会以什么样的方式登场。