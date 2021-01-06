
@[TOC](Jetpack Compose - DropdownMenu)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍

> 一个下拉菜单。菜单具有一个**切换按钮**，它是生成菜单的元素。例如一个图标，点击该图标可以触发菜单。 DropdownMenu的内容可以是DropdownMenuItems，也可以是自定义内容。

## 1、属性一览
【目前基于alpha09版本】函数如下：
```
@Composable fun DropdownMenu(
    toggle: () -> Unit,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    toggleModifier: Modifier = Modifier,
    dropdownOffset: Position = Position(0.dp, 0.dp),
    dropdownModifier: Modifier = Modifier,
    dropdownContent: ColumnScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
toggle: () -> Unit | 生成菜单的元素
expanded: Boolean | 菜单当前是打开还是关闭状态
onDismissRequest: () -> Unit | 在菜单被关闭时调用
toggleModifier: Modifier = Modifier | 应用于菜单开关按钮的修饰符
dropdownOffset: Position = Position(0.dp, 0.dp) | 要添加到菜单的偏移量，默认0.dp
dropdownModifier: Modifier = Modifier | 应用于菜单内容的修饰符

菜单的内容是一个个的菜单项，来看下菜单项的函数：
```
@Composable fun DropdownMenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    content: () -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
onClick: () -> Unit | 单击菜单项时调用
modifier: Modifier = Modifier | 应用于菜单项的修饰符
enabled: Boolean = true | 控制菜单项的启用状态-如果为false，则菜单项将不可单击，并且onClick将不会被调用
interactionState: InteractionState = remember { InteractionState() } | 表示该菜单项存在不同的状态，例如"加入黑名单"和“移除黑名单”这种状态


## 2、使用示例
首先根据说明我们需要一个开关来触发下拉菜单，例如比标题栏右侧的更多按钮，我们简单使用一个IconButton，通过该Button来触发菜单，代码如下：
```
@Composable
fun DropdownMenuDemo() {
    var expanded = remember { mutableStateOf(false) }

    val iconButton = @Composable {
        IconButton(onClick = { expanded.value = true }) {
            Icon(Icons.Default.MoreVert)
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        toggle = iconButton,
    ) {
        DropdownMenuItem(onClick = { }) {
            Text("分享")
        }
        DropdownMenuItem(onClick = { }) {
            Text("举报")
        }
        DropdownMenuItem(onClick = { }) {
            Text("关注")
        }
    }
}
```
实现效果如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210106212142991.gif#pic_center)


## 3、版本更新
- 暂无

## 4、未解决问题
暂无，关于菜单的使用一般也就是这些了，如果想自定义每个菜单项也是可以的，DropdownMenu的内容规定是一个列属性的布局，所以你可以随意定制你的内容。