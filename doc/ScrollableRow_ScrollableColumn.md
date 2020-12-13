
@[TOC](Jetpack Compose - ScrollableRow、ScrollableColumn)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
前面文章我们学习了Row和Column，当子级的内容超过Row和Column的宽高时，子级内容无法全部展示出来，布局会出现异常。
所以针对这种情况，官方给出了ScrollableRow、ScrollableColumn的布局方案，来看下官方的介绍。

- ScrollableRow
> 当所有子级的 **宽度** 大于 其 **宽度** 时，超过其宽度的子级内容会被裁剪，不可见，其可以以**横向滚动**的方式展现全部子级内容。

- ScrollableColumn
> 当所有子级的 **高度** 大于 其 **高度** 时，超过其高度的子级内容会被裁剪，不可见，但其可以以**纵向滚动**的方式展现全部子级内容。

所以这么看来，这两个就是我们之前的ScrollView，只不过细分为了横向和纵向两个布局。

## 1、属性一览
【目前基于alpha08版本】
- ScrollableRow布局的函数：
```
@Composable fun ScrollableRow(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0f),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: RowScope.() -> Unit
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
scrollState: ScrollState = rememberScrollState(0f) | 滚动状态，例如当前偏移量和最大偏移量
horizontalArrangement: Arrangement.Horizontal = Arrangement.Start | 布局子级的 水平 放置方式，默认从布局开始往布局结束方向放置（同Row相关参数的含义）
verticalAlignment: Alignment.Vertical = Alignment.Top |  布局子级的 垂直 对其方式，默认从布局顶部对齐（同Row相关参数的含义）
reverseScrollDirection: Boolean = false | 反转滚动方向，如果为true，则ScrollState.value = 0表示向右；如果为false，则ScrollState.value = 0表示左侧
isScrollEnabled: Boolean = true | 用来启用或禁用**触摸滚动**的参数。如果有ScrollState参数，则仍可以调用ScrollState.smoothScrollTo及其他相关方法。
contentPadding: PaddingValues = PaddingValues(0.dp) | 子级内容边界和ScrollableRow边界的距离（注意不是子级内容之间的距离，切勿混淆）

- ScrollableColumn
```
@Composable fun ScrollableColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0f),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: ColumnScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
scrollState: ScrollState = rememberScrollState(0f) | 滚动状态，例如当前偏移量和最大偏移量
verticalArrangement: Arrangement.Vertical = Arrangement.Top | 布局子级的 竖直 放置方式，默认从布局顶部往布局底部方向放置（同Column相关参数的含义）
horizontalAlignment: Alignment.Horizontal = Alignment.Start | 布局子级的 水平直 对其方式，默认从布局开始对齐（同Row相关参数的含义）

剩下的参数意思都一样了，不再赘述，请看下文示例。
## 2、使用示例
因为这两个布局也很类似，我们只以ScrollableRow来进行示例，首先声明了一个数组，然后根据该数组的索引创建红黄相间的Box，代码如下：
```
@Composable
fun ScrollableRowDemo() {

    val list = arrayOf(0, 1, 2, 3, 4)

    ScrollableRow {
        repeat(list.count()) {
            Box(
                Modifier
                    .height(100.dp)
                    .width(150.dp)
                    .background(
                        if (it % 2 == 0) {
                            Color.Yellow
                        } else {
                            Color.Red
                        }
                    )
            )
        }
    }
}
```

所以实现效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201213144632424.gif#pic_center)
**注意：**
ScrollableXXX布局中不可直接嵌套其它ScrollableXXX或者LazyXXXFor视图，否则会报如下错误：
```java.lang.IllegalStateException: Nesting scrollable in the same direction layouts like ScrollableRow and LazyRowFor is not allowed. If you want to add a header before the list of items please take a look on LazyRow component which has a DSL api which allows to first add a fixed element via item() function and then the list of items via items().```

所以，如果你想在列表之前添加一个视图，请使用LazyRow，它许先通过item()函数添加一个固定的元素，然后通过 items()添加项目列表。这就是类似之前的RecyclerView的内容了，我们下一章讲解。

## 3、版本更新
- 暂无

## 4、未解决问题
关于ScrollView基本也就是使用它的滚动属性，一般是个人主页高度过高的时候可能使用到，或者其他情况，请根据场景使用。
