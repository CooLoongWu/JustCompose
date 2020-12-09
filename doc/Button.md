@[TOC](Jetpack Compose - Button)
关于Button官方给出了很多种样式，有Button、TextButton、OutlinedButton、IconButton、IconToggleButton等，还有一个RadioButton我们会单独开文章去讲解。
## 1、Button

### 1.1、属性一览
我们先来看下 **Button** 的属性，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#button)：
```
@Composable fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    elevation: ButtonElevation? = ButtonConstants.defaultElevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonConstants.defaultButtonColors(),
    contentPadding: PaddingValues = ButtonConstants.DefaultContentPadding,
    content: RowScope.() -> Unit
): Unit
```

- onClick: () -> Unit
	单击按钮的事件回调，如果不提供该回调，那么按钮将变为禁用状态；
- modifier: Modifier = Modifier
	修饰符
- enabled: Boolean = true
	控制按钮的启用状态。如果为false，则该按钮将不可单击；
- interactionState: InteractionState = remember { InteractionState() }
	表示交互的状态信息，也就是相当于我们之前给按钮设置的各种selector，来实现普通、点击效果等，下文代码详解；
- elevation: ButtonElevation? = ButtonConstants.defaultElevation()
	按钮的阴影大小效果，设置为null不显示阴影效果，一般我们开发中应该也不会使用这种阴影效果。
- shape: Shape = MaterialTheme.shapes.small
	定义按钮的形状及阴影等效果；
- border: BorderStroke? = null
	设置按钮的边框（目前alpha07版本的设置border后效果并不好，按钮四个角落还会显示出来部分按钮默认的背景色）；
- colors: ButtonColors = ButtonConstants.defaultButtonColors()
	用于在不同状态下设置按钮的背景色以及内容色；
- contentPadding: PaddingValues = ButtonConstants.DefaultContentPadding
	容器和控件之间的距离值
- content: RowScope.() -> Unit
	关于这个参数官方文档居然没有讲解，这个是按钮的内容，什么意思呢？你想想看按钮包含文本信息对吧，也可能包含图标信息吧，所以这个参数就是让你组合你需要的控件的，注意它是横向的。

### 1.2、使用示例
首先显示一个最简单的Button代码如下，该按钮应用的都是默认配置项：
```
@Composable
fun ButtonDemo() {
    Button(
        onClick = { },
    ) {
        Text(
            text = "这是一个按钮",
        )
    }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201208194048339.png#pic_center)
这就是一个组合了一个简单文本的按钮，平常我们开发的时候需要的都是有点击效果的啊，还有圆角啊各种的，下面就一起来解决。
首先根据上文的属性，我们需要知道按钮当前的状态，是默认状态还是点击状态，对的，就是InteractionState()这个东西，目前只有默认、Dragged和Pressed几种状态。具体用法请看下文代码```val interactionState = remember { InteractionState() }```，目前官方写法是这样的，但是不清楚api是否还会有变更。我们拿到这个状态后需要“枚举”这些状态值，根据不同的状态设置不同的文本，文本颜色，按钮颜色等。所以我们新建了一个data类来记录这些属性不同状态下按钮的各种值。
data类如下：
```
data class ButtonState(var text: String, var textColor: Color, var buttonColor: Color)
```
然后在枚举这些值的时候，我们创建相应的按钮状态对象，下面是kotlin的解构用法，仅为示例效果，大家可以采用其他方式实现。

给按钮设置颜色的时候需要设置解构出来的按钮颜色值，给文本也设置解构出来的文本和文本颜色。
最后我们再给按钮添加一个圆角的修饰符属性，代码如下所示：
```
@Composable
fun ButtonDemo() {

    val interactionState = remember { InteractionState() }

    val (text, textColor, buttonColor) = when {
        Interaction.Pressed in interactionState -> ButtonState("Just Pressed", Color.Red, Color.Black)
        else -> ButtonState( "Just Button", Color.White, Color.Red)
    }

    Button(
        onClick = { },
        interactionState = interactionState,
        elevation = null,
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = buttonColor,
            disabledBackgroundColor = Color.Gray,
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(50))
    ) {
        Text(
            text = text,
            color = textColor
        )
    }
}
```
上面代码中我们去除了按钮的阴影效果，然后实现的点击效果如下，默认红底白字，点击时变为黑底红字                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201208200319838.gif#pic_center)

## 2、TextButton
### 2.1、属性一览
```
@Composable inline fun TextButton(
    noinline onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonConstants.defaultTextButtonColors(),
    contentPadding: PaddingValues = ButtonConstants.DefaultTextContentPadding,
    noinline content: RowScope.() -> Unit
): Unit
```
属性基本都类同于Button的属性，他的content参数是RowScope类型的，表示可以横向组合各种控件。这里不再具体详解了，直接看代码好了。

### 2.2、使用示例
最基础的文本按钮代码如下：
```
@Composable
fun TextButtonDemo() {
    TextButton(onClick = {}) {
        Text("Text Button")
    }
}
```
然后默认效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201209110624666.gif#pic_center)
默认带了水波纹效果，如果你想定制它的点击文字效果以及去掉水波纹效果，参考Button的示例应该可以很轻松解决吧，交给大家去实践了。

## 3、OutlinedButton
### 3.1、属性一览
```
@Composable inline fun OutlinedButton(
    noinline onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = ButtonConstants.defaultOutlinedBorder,
    colors: ButtonColors = ButtonConstants.defaultOutlinedButtonColors(),
    contentPadding: PaddingValues = ButtonConstants.DefaultContentPadding,
    noinline content: RowScope.() -> Unit
): Unit
```
其实OutlinedButton就是继承自Button的一个按钮，border的属性默认设置为了```border: BorderStroke? = ButtonConstants.defaultOutlinedBorder```。
### 3.2、使用示例
我们直接更改默认的border属性，然后将按钮的背景色设置为透明，代码如下：
```
@Composable
fun OutlinedButtonDemo() {
    OutlinedButton(
        onClick = {},
        border = BorderStroke(2.dp, Color.Red),
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = Color.Transparent
        )
    ) {
        Text(
            text = "Outlined Button",
            color = Color.Red
        )
    }
}
```
这样直接在AS中的预览样式如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020120911245137.png#pic_center)
好了，现在大家嚷嚷着要圆角属性了，直接给OutlinedButton的shape属性设置就可以了```shape = RoundedCornerShape(50),```，然后效果就是：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201209112739645.png#pic_center)
简直棒棒，剩下的点击效果不用再写了吧，加油！

## 4、IconButton
### 4.1、属性一览：
相比Button还是少了很多属性的：
```
@Composable fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    content: () -> Unit
): Unit
```
- onClick: () -> Unit
	点击回调；
- modifier: Modifier = Modifier
	修饰符；
- enabled: Boolean = true
	是否被禁用；
- interactionState: InteractionState = remember { InteractionState() }
	同上文Button中相关属性；
- content: () -> Unit
	要在IconButton内部绘制的内容（图标）。通常是一个图标。

### 4.2、使用示例
其实我一开始使用的时候我看它名字觉得可能是可以在按钮的左侧添加一个Icon图标的特殊按钮，然而事实并不是这样，官方文档是这么写的：
> IconButton是可单击的图标，用于表示操作。 IconButton的整体最小触摸目标大小为48 x 48dp，以满足辅助功能准则。内容位于IconButton内部。

最后来了一句内容位于IconButton的内部，什么意思呢，来看下面的代码：
```
@Composable
fun IconButtonDemo() {
    IconButton(
        onClick = {},
    ) {
        Icon(Icons.Filled.Favorite)
        Text(text = "这是一个按钮")
    }
}
```
然后预览效果是这样的：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201208205233594.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
所以这个IconButton你就只用来展示单个可点击的图标就好了，如果需要做 **按钮中包含图标和文字的效果** 建议直接使用Button然后在其content中组合这两个控件即可。

关于这点你可以直接看下IconButton的源码，因为content()是一个Box布局，所以他会一层层盖在上面，关于布局我们下一章讲解，这里不多做解释啦。


## 5、IconToggleButton
官方描述为：具有两个状态的IconButton，我觉得是那种点赞和取消点赞的图标，并不是那种开关类型的控件，因为关于开关有Switch。
### 5.1、属性一览
@Composable fun IconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionState: InteractionState = remember { InteractionState() },
    content: () -> Unit
): Unit

属性同样不多，我们只介绍一个特殊的参数：
- onCheckedChange: (Boolean) -> Unit
	选择此图标时要调用的回调；

### 5.2、使用示例
这就很简单了，主要在于需要一个状态，但是这个状态却不是普通的布尔值，重点是这个```val checkedState = remember { mutableStateOf(true) }```，这就表示这个状态是可以被观察和记录的，只要更新，Compose组件就会进行相应的变化：
```
@Composable
fun IconToggleButtonDemo() {

    val checkedState = remember { mutableStateOf(true) }

    IconToggleButton(
        checked = checkedState.value,
        onCheckedChange = {
            Log.e("Button", "点击了：$it")
            checkedState.value = it
        },
    ) {
        Icon(
            asset = Icons.Filled.Favorite,
            tint = if (checkedState.value) {
                Color.Red
            } else {
                Color.Gray
            }
        )
    }
}
```
上述代码运行后就可以看到默认状态是红色的喜欢效果，点击后切换为灰色的喜欢效果，如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201209104414399.gif#pic_center)


## 未解决问题
目前到现在基本的点击效果都没有问题了，唯一剩下的就是一个按钮的禁用状态问题，这个按钮禁用到可用状态一般是外部事件变化后，按钮监听到才会进行相应的变化，所以我们后面会根据布局组合其他控件一起来处理禁用、可用状态。

