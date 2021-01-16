
@[TOC](Jetpack Compose - RadioButton)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍

> 表示两个状态的组件，包含已选中和未选中状态

在XML中RadioButton一般需要配合RadioGroup来实现单选功能。但是在Compose中，完全没有了RadioGroup的概念，因为你整个视图是数据驱动的，所以只要保证数据是你想要的即可，无论是单选还是多选，都可以实现。

而且需要注意一点，这个RadioButton就是一个Button，不会像XML中的还有text属性，Compose中的就是一个单独的按钮，剩下的布局你可以自己定义，我们下文看代码实现。
## 1、属性一览
【目前基于alpha10版本】该函数如下：
```
@Composable fun RadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    colors: RadioButtonColors = RadioButtonDefaults.colors()
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
selected: Boolean | 按钮的选中状态
onClick: () -> Unit |  单击RadioButton的回调
modifier: Modifier = Modifier | 应用于布局的修饰符
enabled: Boolean = true | 控制RadioButton的启用状态。如果为false，则此按钮将不可选择，并以禁用的UI状态显示
interactionState: InteractionState = remember { InteractionState() } | 自定义按钮显示的不同状态
colors: RadioButtonColors = RadioButtonDefaults.colors() |  RadioButton在不同状态下的颜色

## 2、使用示例
我们直接定义一排单选按钮，首先定义了一些按钮项的显示文本内容，然后根据这些文本循环设置RadioButton，并组合Text控件。然后我们定义了选中状态seletedTag的默认值为Null，然后单击某个按钮时，设置为相应的值，代码如下：
```
@Composable
fun RadioButtonDemo() {
    val tags = arrayListOf("Java", "Kotlin", "XML", "Compose", "JetPack")
    var selectedTag = remember { mutableStateOf("Null") }

    Row() {
        tags.forEach {
            Row {
                RadioButton(
                    selected = it == selectedTag.value,
                    onClick = {
                        selectedTag.value = it
                    }
                )

                Text(text = it)
            }

            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}
```

所以实现效果如下所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210116213823511.gif#pic_center)


## 3、版本更新
- 暂无

## 4、未解决问题
由于RadioButton是完全交由数据状态来处理的，所以我们可以很方便的设置为单选或者多选 的情况，这个大家可以自己尝试下，上面的代码仅仅只是示例代码。