
@[TOC](Jetpack Compose - LazyRow、LazyColumn)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
前面我们学习了可以滚动的视图ScrollableRow、ScrollableColumn，当内容过长时可以使其子级进行滚动展示。但是如果遇到超长列表的情况，滚动视图就不可用了，因为滚动视图没有缓存机制，当列表过长的时候，很容易造成内存溢出的情况。
所以这篇文章大就一起来看下Compose给出的解决方案-LazyRow、LazyColumn，官方介绍如下：
- LazyRow
> 仅组成和放置 **当前可见项** 的水平滚动列表。它允许您放置不同类型的子级内容。例如，您可以使用LazyListScope.item添加单个项目，然后使用LazyListScope.items或者LazyListScope.itemsIndexed添加项目列表，后者有当前列表项的索引值。


- LzayColumn
> 仅组成和放置 **当前可见项** 的竖直滚动列表。它允许您放置不同类型的子级内容。例如，您可以使用LazyListScope.item添加单个项目，然后使用LazyListScope.items或者LazyListScope.itemsIndexed添加项目列表，后者有当前列表项的索引值。

也就是说我们可以使用LazyListScope.item来单独添加列表的**头**和**尾**的内容，或者是添加不同类型的子级内容。
## 1、属性一览
【目前基于alpha08版本】

- LazyRow布局的函数如下：
```
@Composable fun LazyRow(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: LazyListScope.() -> Unit
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
state: LazyListState = rememberLazyListState() | 用于控制或观察列表状态的状态对象
contentPadding: PaddingValues = PaddingValues(0.dp) | 子级内容边界和LazyRow边界的 距离
verticalAlignment: Alignment.Vertical = Alignment.Top | 布局子级的 垂直 对其方式，默认从布局顶部对齐（同Row相关参数的含义）
content: LazyListScope.() -> Unit | 描述内容的代码块。您可以使用LazyListScope.item方法来添加单个项目，或者使用LazyListScope.items、LazyListScope.itemsIndexed的方法来添加项目列表。

- LazyColumn的函数如下;
```
@Composable fun LazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: LazyListScope.() -> Unit
): Unit
```
所有参数都同之前的Row和Column的类似，这里不再赘述。

- LazyRowFor、LazyRowForIndexed、LazyColumn、LazyColumnForIndexed

这四个函数都分别继承自LazyRow和LazyColumn，但是他们的功能更加单一，无法使用LazyListScope.item来添加单个项目，只能使用LazyItemScope.(T)来添加列表内容，具体使用方法请见下文。


## 2、使用示例
横向和竖向的功能类似，这里我们使用 LazyRow 来进行展示，使用```item```方法添加蓝色的头部和尾部，使用```items```方法添加列表内容（itemsIndexed会包含列表项的索引值，请根据情况使用），列表项根据索引使用不同的背景色，代码如下：
```
@Composable
fun LazyRowDemo() {

    val listData = (0..9).toList()
    LazyRow(content = {

        //头部内容
        item {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "头部")
            }
        }

        //列表内容
        items(listData) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        if (it % 2 == 0) {
                            Color.Red
                        } else {
                            Color.Yellow
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "列表项：$it")
            }
        }

        //尾部内容
        item {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "尾部")
            }
        }
    })
}
```
实现效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201213170622874.gif#pic_center)
至于其他的四个布局都是继承自LazyRow或者LazyColumn的，而且其内容没有区分item和items、itemsIndexed等属性了，只有单一的items和itemsIndexed属性，方便更加纯粹的实现一个简单列表，这里就不做示例了。
## 3、版本更新
- 暂无

## 4、未解决问题
其实到目前的情况，一个基本的RecyclerView我们已经可以实现了，而且没有Adapter的概念，直接声明你的列表项是什么样子的就可以了，真的是超级简单。
但是在项目实际的使用中，我们可能需要下拉刷新，上拉加载等效果，这个我们后文继续研究，目前仅做了静态的列表展示。
接下的文章我们将结合Jetpack ViewModel、LiveData等来实现一个简单的直播间页面（当然不会有视频预览的画面，就用图片做背景来代替吧，哈哈哈）。