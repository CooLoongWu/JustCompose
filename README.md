@[TOC](Jetpack Compose - Text)

## 1、属性一览
首先直接看下官网给的两种方法，[链接在这里](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary#text)：
```
@Composable fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Inherit,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Inherit,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Inherit,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = AmbientTextStyle.current
): Unit

```

```

@Composable fun Text(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Inherit,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Inherit,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Inherit,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = AmbientTextStyle.current
): Unit
```
这两种方式的区别就在于text参数，一个是String类型，一个是AnnotatedString类型。

- text: String
	普通的字符串；
- text: AnnotatedString
	带有不同属性的字符串，例如可以在一串字符中设置某些字符的颜色、字体、大小等属性；
- modifier: Modifier = Modifier
	这是一个很重要的属性Modifier（修饰符），关于修饰符的问题我们在布局中再仔细学习，这里学习控件就先简单的使用它的宽高以及margin和padding属性即可。
- color: Color = Color.Unspecified
	字体的颜色
- fontSize: TextUnit = TextUnit.Inherit
	绘制文本时使用的字形大小。请参见TextStyle.fontSize。
- fontStyle: FontStyle? = null
	绘制字母时使用的字体变体（例如，斜体）。请参见TextStyle.fontStyle。
- fontWeight: FontWeight? = null
	绘制文本时要使用的字体粗细（例如FontWeight.Bold）。
- fontFamily: FontFamily? = null
	呈现文本时要使用的字体系列。请参见TextStyle.fontFamily。
- letterSpacing: TextUnit = TextUnit.Inherit
	每个字母之间添加的空间量。请参见TextStyle.letterSpacing。
- textDecoration: TextDecoration? = null
	要在文字上绘制的装饰（例如下划线）。请参见TextStyle.textDecoration。
- textAlign: TextAlign? = null
	文本在段落中的对齐方式。请参见TextStyle.textAlign。
- lineHeight: TextUnit = TextUnit.Inherit
	以TextUnit为单位的段落的行高，例如SP或EM。请参见TextStyle.lineHeight。
- overflow: TextOverflow = TextOverflow.Clip
	视觉溢出应的处理方式，例如尾部显示...或者中间显示...。
- softWrap: Boolean = true
	文本是否应在换行符处中断。如果为false，则文本的宽度会在水平方向上无限延伸，且textAlign属性失效，可能会出现异常情况。
- maxLines: Int = Int.MAX_VALUE
	文本可跨越的可选最大行数，必要时可以换行。如果文本超过给定的行数，则会根据textAlign和softWrap属性截断文本。它的值必须大于零。
- onTextLayout: (TextLayoutResult) -> Unit = {}
	计算新的文本布局时执行的回调。
- style: TextStyle = AmbientTextStyle.current
	文本的样式配置，例如颜色，字体，行高等。也就是说上面属性中的color,fontSize等一些属性也可以在这里进行声明。具体包含的属性可以参考TextStyle类。

## 2、使用示例

接下来请看一段示例代码，该代码使用的是带AnnotatedString属性的Text()，如下所示：
```

@Composable

@Composable
fun TextDemo(startString: String, endString: String) {
    val annotatedStringBuilder = AnnotatedString.Builder(startString)
    annotatedStringBuilder.pushStyle(
            SpanStyle(
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
            )
    )
    annotatedStringBuilder.append("【可以】")
    annotatedStringBuilder.pop()
    annotatedStringBuilder.append(endString)
    val annotatedString = annotatedStringBuilder.toAnnotatedString()

    Text(
            text = annotatedString,
//            color = Color.Red,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = TextStyle(
                    color = Color.White,
                    background = Color.DarkGray
            ),
            modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .wrapContentSize(align = Alignment.CenterEnd)
                    .drawOpacity(1f)
                    .clickable(onClick = {
                        Log.e("点击了全文本", "点击事件")
                    })
                    .background(color = Color.Yellow)
    )
}

@Preview
@Composable
fun previewTextDemo() {
    TextDemo(startString = "你", endString = "的")
}
```

在上述代码中，我们给Text设置了【深灰背景】【16号白色字体】，然后AnnotatedString中我们添加了一个【24号红色斜体】的文本，最后在修饰符属性中我们设置了固定的宽高，以及【居中尾部对齐】方式，并且设置了【黄色背景】。

渲染结果如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201201193233191.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)

仔细看下文本的背景仅会绘制在文本所占长度的区域，Modifier修饰符设置的背景也仅仅绘制在文本的区域，但是比文本区域稍微大了一些，而不是设置的200*100的宽度。虽然渲染图上只有左侧有黄色背景，但运行到手机上其实左右两侧都有一点黄色区域的。

关于Modifier我们到布局的时候再仔细研究，目前仅用一些基础属性来示例好了。

## 3、未解决问题
给整个Text设置点击事件的话是可以在Modifier中的clickable()方法设置的，请参考上文代码示例。
但是目前笔者还没有找到单独给上文中的红色字体设置点击事件的API，如果各位有发现请不吝赐教。

