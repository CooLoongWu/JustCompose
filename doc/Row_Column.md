
@[TOC](Jetpack Compose - Row、Column)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
首先大致了解下这两个布局：
- Row ：水平布局，官方介绍如下
>可以组合的布局，会将其子级 **横向** 进行放置。
>如果需要 竖向 进行放置，请参考Column。
>如果需要子级可以 横向滚动 ，请参考ScrollableRow。
>如果需要只展示当前可见项 的 横向滚动列表请参考 LazyRow。

- Column
> 可以组合的布局，会将其子级 **竖向** 进行放置。
> 如果需要 横向 进行放置，请参考Row。
>如果需要子级可以 横向滚动 ，请参考ScrollableColumn。
>如果需要只展示当前可见项 的 横向滚动列表请参考 LazyColumn。

所以根据官方介绍我们可以明确知道，Row和Column就是我们之前的LinearLayout，只不过官方细分了，直接分出来两个布局。而且这两个布局没有滚动效果，当内容过长的时候会超出屏幕而无法看到内容项。

再多说一点，其实要想实现ScrollView的效果，就需要使用ScrollableXXX布局。要想实现RecyclerView的效果，就需要使用LazyXXX布局。


## 1、属性一览
【目前基于alpha08版本】请看Row布局支持的函数：
```
@Composable inline fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: RowScope.() -> Unit
): Unit
```

属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
horizontalArrangement: Arrangement.Horizontal = Arrangement.Start | 布局子级的 水平 放置方式，默认从布局开始往布局结束方向放置
verticalAlignment: Alignment.Vertical = Alignment.Top | 布局子级的 垂直 对其方式，默认从布局顶部对齐

再来看下Column布局的函数：
```
@Composable inline fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: ColumnScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
verticalArrangement: Arrangement.Vertical = Arrangement.Top | 布局子级的 竖直 放置方式，默认从布局顶部往布局底部方向放置
horizontalAlignment: Alignment.Horizontal = Alignment.Start | 布局子级的 水平直 对其方式，默认从布局开始对齐

总结来说就是：
	水平布局从横向开始往结束方向进行布局，然后其子级默认顶部对齐；
	竖直布局从顶部开始往底部进行布局，然后其子级默认开始方向对其（为什么是Start和End而不是Left和Right，因为国际化的问题，我们国家的阅读方式是从左到右，但是有的国家却是从右到左，所以Left和Right这个概念就不适合了，因此需要使用Start和End概念）


## 2、使用示例
这两个布局属性基本类似，所以我们只使用Row布局来进行演示，我们在Row布局中，放置了两个简单的Box，布局，第一个是宽高200的红色框，第二个是宽高100的黄色框，代码如下：
```
@Composable
fun RowDemo() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Red)
        )
        Box(
            Modifier
                .width(100.dp)
                .height(100.dp)
                .background(Color.Yellow)
        )
    }
}
```

实现效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201212164416572.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)
然后设置Row的竖直方向对齐方式为竖直居中对齐： ```verticalAlignment = Alignment.CenterVertically```，显示效果如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201212164715840.png#pic_center)
然后设置Row的水平布局方向为从 **结束到开始** 进行布局：
```horizontalArrangement = Arrangement.End```，再来看显示效果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201212164933963.png#pic_center)从之前的左侧贴着屏幕，到现在的右侧贴着屏幕。

还剩下一个重要的概念-  **权重** ，什么意思呢，还拿上文的红黄框做讲解，Row的布局我们定义它是填充整个屏幕的，红黄框是横向排列的，如果我们不指定红黄框的宽度，而是指定红黄框所占的比重是1:1，那么横向上他们将各占Row布局宽度的一半，也就是说各占屏幕的一半，代码如下所示：
```
@Composable
fun RowDemo() {
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            Modifier
                .height(200.dp)
                .weight(1f)
                .background(Color.Red)
        )
        Box(
            Modifier
                .height(100.dp)
                .weight(1f)
                .background(Color.Yellow)
        )
    }
}
```
效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201212170212225.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)




## 3、版本更新
- 暂无

## 4、未解决问题
关于水平竖直的布局基本使用方式也就这些了，剩下的基本就是宽度或者高度超出屏幕的问题，需要使用ScrollableRow或者ScrollableColumn布局了，这个我们下文讲解。