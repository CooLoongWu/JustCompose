
@[TOC](Jetpack Compose - Box)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍
针对Box布局，官方介绍如下：
> 可以和内容组合的布局，Box会根据传入的限制（我理解为：Box的Modifier修饰符属性以及content包含的属性）自行调整大小以适应内容。
> 如果需要指定content的对齐方式，请使用Alignment。
> 如果Box中包含多个布局子级时，这些子级将按照组成顺序 “堆叠” 起来（所以，这就类似FrameLayout布局了）。

## 1、属性一览
【目前基于alpha08版本的属性】首先请看Box的两个函数：
```
@Composable fun Box(modifier: Modifier): Unit
```

```
@Composable inline fun Box(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    content: BoxScope.() -> Unit
): Unit
```
属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
contentAlignment: Alignment = Alignment.TopStart | Box中内容的默认对齐方式
content: BoxScope.() -> Unit | Box中的内容

## 2、使用示例
我们首先声明一个 360*200 背景为红色的Box，然后定义该Box中内容的对齐属性为 ```contentAlignment = Alignment.Center```**居中对齐** ，然后我们在Box中定义它的内容为另一个Box1，Box1的背景为黑色，宽高属性为 ```fillMaxSize```，这个属性意思是“全部填充父容器”，它有一个默认参数表示所占父容器的百分比，所以fillMaxSize(0.5f) 的意思就是：内容Box1的宽高是父Box宽高的一半。Box2的就不具体解释了，代码如下：
```
@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        //子Box1
        Box(
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(color = Color.Black)
        )

        //子Box2
        Box(
            modifier = Modifier
                .fillMaxSize(0.2f)
                .background(color = Color.White)
        )
    }
}
```

所以实现效果如下所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201211185335333.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTA5NzYyMTM=,size_16,color_FFFFFF,t_70#pic_center)


## 3、版本更新
- 暂无
## 4、未解决问题
其实在之前的项目中使用FrameLayout的情况就很少，FrameLayout布局的局限性在Box布局中也会有，比如按照百分比布局控件，所以我们后面需要使用更强大的ConstraintLayout。布局简单的情况使用Box布局就可以啦，后面遇到Box布局的小技巧再继续完善文档。
