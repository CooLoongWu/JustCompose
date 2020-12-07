@[TOC](Jetpack Compose - TextField)

## 1、属性一览
关于输入框，官方提供了两种类型，TextField和OutlinedTextFiedl。
先看下两种输入框最简单的效果，上面是普通的TextField效果，跟之前的EditText默认效果一致，第二种是OutlinedTextField效果，带有一个边框：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201205111818579.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)



首先看下TextField的两个函数，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#textfield)：
```
@Composable fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AmbientTextStyle.current,
    label: () -> Unit = null,
    placeholder: () -> Unit = null,
    leadingIcon: () -> Unit = null,
    trailingIcon: () -> Unit = null,
    isErrorValue: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> },
    onTextInputStarted: (SoftwareKeyboardController) -> Unit = {},
    interactionState: InteractionState = remember { InteractionState() },
    activeColor: Color = MaterialTheme.colors.primary,
    inactiveColor: Color = MaterialTheme.colors.onSurface,
    errorColor: Color = MaterialTheme.colors.error,
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha),
    shape: Shape = MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize)
): Unit
```

```
@Composable fun TextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AmbientTextStyle.current,
    label: () -> Unit = null,
    placeholder: () -> Unit = null,
    leadingIcon: () -> Unit = null,
    trailingIcon: () -> Unit = null,
    isErrorValue: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> },
    onTextInputStarted: (SoftwareKeyboardController) -> Unit = {},
    interactionState: InteractionState = remember { InteractionState() },
    activeColor: Color = MaterialTheme.colors.primary,
    inactiveColor: Color = MaterialTheme.colors.onSurface,
    errorColor: Color = MaterialTheme.colors.error,
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha),
    shape: Shape = MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize)
): Unit
```

接着是OutlinedTextField的两个函数，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#outlinedtextfield)：
```
@Composable fun OutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AmbientTextStyle.current,
    label: () -> Unit = null,
    placeholder: () -> Unit = null,
    leadingIcon: () -> Unit = null,
    trailingIcon: () -> Unit = null,
    isErrorValue: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> },
    onTextInputStarted: (SoftwareKeyboardController) -> Unit = {},
    interactionState: InteractionState = remember { InteractionState() },
    activeColor: Color = MaterialTheme.colors.primary,
    inactiveColor: Color = MaterialTheme.colors.onSurface,
    errorColor: Color = MaterialTheme.colors.error
): Unit
```

```
@Composable fun OutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AmbientTextStyle.current,
    label: () -> Unit = null,
    placeholder: () -> Unit = null,
    leadingIcon: () -> Unit = null,
    trailingIcon: () -> Unit = null,
    isErrorValue: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> },
    onTextInputStarted: (SoftwareKeyboardController) -> Unit = {},
    interactionState: InteractionState = remember { InteractionState() },
    activeColor: Color = MaterialTheme.colors.primary,
    inactiveColor: Color = MaterialTheme.colors.onSurface,
    errorColor: Color = MaterialTheme.colors.error
): Unit
```
- value: String
	输入框中要显示的文本；
- value: TextFieldValue
	输入框中要显示的文本，包含了输入框编辑状态的信息，这个功能很强大，可以用来更新文本，光标等，然后还可以从其他位置直接观察到这些值的变化。也就是相当于双向绑定的意思；
- onValueChange: (TextFieldValue) -> Unit
	输入服务更新TextFieldValue中的值时触发的回调，更新后的TextFieldValue值作为回调参数；
- modifier: Modifier = Modifier
	修饰符
- textStyle: TextStyle = AmbientTextStyle.current
	应用于输入框的样式，默认样式为AmbientTextStyle.current
- label: () -> Unit = null
	显示在文本字段内的可选标签，类似于占位符，但是是输入框**没有获得焦点**时候的占位符。下文代码中用实例讲解下会很好理解；
- placeholder: () -> Unit = null
	当输入框**获得焦点**的时候，要展示的占位符，文本样式默认为Text的Typography.subtitle1
- leadingIcon: () -> Unit = null
- trailingIcon: () -> Unit = null
	输入框前后要展示的图标；
- isErrorValue: Boolean = false
	表示输入框中的内容是否处于失败的状态，如果为true，则label，Icon等会相应的展示错误的显示状态；
- visualTransformation: VisualTransformation = VisualTransformation.None
	转换输入值的视觉表示。例如，您可以使用androidx.compose.ui.text.input.PasswordVisualTransformation创建密码文本字段，也就是输入的密码字符串会转换为 **······** 显示。默认情况下，不应用任何视觉转换；
- keyboardOptions: KeyboardOptions = KeyboardOptions.Default
	包含配置的软件键盘选项，例如KeyboardType和ImeAction。
- singleLine: Boolean = false
	当设置为true时，此文本字段将变为单个水平滚动文本字段，而不是多行。
- maxLines: Int = Int.MAX_VALUE
	以最大可见行数表示的最大高度，该值需要等于或大于1。如果将singleLine设置为true，则将忽略此参数，而将maxLines设置为1。
- onImeActionPerformed: (ImeAction, SoftwareKeyboardController?) -> Unit = { _, _ -> }
	输入服务执行ImeAction时触发。请注意，发出的IME操作可能与您通过KeyboardOptions.imeAction字段指定的操作不同。回调还公开了SoftwareKeyboardController实例作为可用于请求隐藏软件键盘的参数；
- onTextInputStarted: (SoftwareKeyboardController) -> Unit = {}
	建立与平台的文本输入服务（例如Android上的软件键盘）的连接时要调用的回调。可用于请求显示或隐藏软件键盘；
- interactionState: InteractionState = remember { InteractionState() }
	暂时不清楚用法
- activeColor: Color = MaterialTheme.colors.primary
	输入框处于焦点时的标签，底部指示符和光标的颜色；
- inactiveColor: Color = MaterialTheme.colors.onSurface
	输入框处于焦点时的输入文本或占位符的颜色，输入框不处于焦点时的标签和底部指示符的颜色；
- errorColor: Color = MaterialTheme.colors.error
	将isErrorValue设置为true时使用的标签，底部指示器，光标和尾随图标的颜色；
- backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha)
	输入框的背景色；
- shape: Shape = MaterialTheme.shapes.small.copy(bottomLeft = ZeroCornerSize, bottomRight = ZeroCornerSize)
	输入框的形状；



## 2、使用示例
接下来请看一段示例代码，一个最简单的TextField如下，注意我们使用的是 （value: String）这个参数，直接写入了“你好”：
```
@Composable
fun TextFieldDemo() {
    TextField(
        value = "你好",
        onValueChange = {
			Log.e("TextFieldDemo", "输入内容更新：$it")
        },
    )
}
```
该代码创建出来的就是一个最基本的然而 **并不可用** TextField，为什么说它不可用，因为你输入任何东西的时候，这个TextField中的内容并不会更新。所以这就跟我们之前用的EditText不同了，TextField要求我们自行处理内容更新的问题，所以这就需要我们使用到 **（value: TextFieldValue）** 这个参数了，代码如下所示：
```

@Composable
fun TextFieldDemo() {

    var text by savedInstanceState { "" }

    TextField(
            value = text,
            onValueChange = {
                Log.e("TextFieldDemo", "输入内容更新：$it")
                text = it
            },
    )
}
```
此时再运行代码，在输入框中输入任何东西，输入框中的内容就会更改了。

接下来我们再来看lable和placeholder的使用以及区别，直接看代码：
```
@Composable
fun TextFieldDemo() {

    var text by savedInstanceState { "" }

    TextField(
            value = text,
            onValueChange = {
                Log.e("TextFieldDemo", "输入内容更新：$it")
                text = it
            },
            label = {
                Text("这是标签")
            },
            placeholder = {
                Text("请输入内容")
            },
            modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun OutlinedTextFieldDemo() {
    var text by savedInstanceState { "" }

    OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text("这是标签")
            },
            placeholder = {
                Text("请输入内容")
            },
            modifier = Modifier.padding(8.dp)
    )
}
```
label和placeholder都是使用的Text控件，所以你可以直接定义Text的各种属性，这就是**组合**的魅力吧，代码中仅为最简单的示例，效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020120716371453.gif#pic_center)
lable的使用取决于设计图了，我们常用的一般是输入框前面和后面的图标，请看如下代码：
```
@Composable
fun TextFieldDemo() {

    var text by savedInstanceState { "" }

    TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = {
                Text("请输入内容")
            },
            modifier = Modifier.padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(asset = Icons.Filled.Lock)
            },
            trailingIcon = {
                Icon(
                        asset = Icons.Filled.Delete,
                        modifier = Modifier
                                .clickable(
                                        onClick = {
                                            text = ""
                                        }
                                )
                )
            },
    )
}
```
在上面的代码中，我们给输入框设置了 **密码样式** ，也就是说输入的字符串会转换为点，然后添加了其实的Icon图标为图标库中的锁的样式（关于Icon我们下面文章也会继续实践），结尾的图标为删除图标，点击后会将 text 设置为 “” 空字符串，效果如下所示：
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20201207165600234.gif#pic_center)
如果你需要实时监测输入内容以及展示错误的状态，可以配合onValueChange 、isErrorValue并组合其他控件来实现，这个就先不展示了吧，如果有需要的可以留言，我进行补充。
## 3、未解决问题
这个控件应该没有其他的需求了吧，以上内容基本涵盖了开发中的大多数案例，暂时没有想到其他的问题需要解决了，如果各位有疑问请留言，我会继续探索。

