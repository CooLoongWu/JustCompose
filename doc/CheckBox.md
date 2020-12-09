@[TOC](Jetpack Compose - CheckBox)

## 1、属性一览
【目前基于alpha08版本的属性】首先直接看下属性，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#checkbox)：
```
@Composable fun Checkbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    colors: CheckboxColors = CheckboxConstants.defaultColors()
): Unit
```
这些属性都类同于Button的属性，不做过多详解：


## 2、使用示例
```
@Composable
fun CheckBoxDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
        }
    )
}
```
运行效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201209211459893.gif#pic_center)
和前面Switch一样都是默认提供的样式。

## 3、版本更新
- 暂无更新

## 4、未解决问题
不清楚如何使用自定义的图片，和Switch一样，color属性中只能自定义颜色。所以如果想使用自定义的图片资源是不是暂时只能使用**IconButton**这种形式了呢？期待官方后面的更新。