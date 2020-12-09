@[TOC](Jetpack Compose - Switch)

## 1、属性一览
【目前基于alpha08版本的属性】首先直接看下属性，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#switch)：
```
@Composable fun Switch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    colors: SwitchColors = SwitchConstants.defaultColors()
): Unit
```
这些属性都跟之前Button的属性相同，这里不再详解了，直接看使用示例。

## 2、使用示例
类似按钮一样他们都有一个是否选中的状态，所以都需要```val checkedState = remember { mutableStateOf(true) }```来记录状态：
```
@Composable
fun SwitchDemo() {
    val checkedState = remember { mutableStateOf(true) }

    Switch(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}
```
代码运行效果如下，效果是系统提供的默认效果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201209205622668.gif#pic_center)


## 3、版本更新
- 暂无

## 4、未解决问题
目前还不清楚如何处理自定义的动效问题，如果是简单自定义颜色的话自定义colors参数即可，修改SwitchConstants.defaultColors()相关属性即可。