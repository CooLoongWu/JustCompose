
@[TOC](Jetpack Compose - LazyVerticalGrid)

> Compose系列文章，请点原文阅读。[**原文，是时候学习Compose了！**](https://blog.csdn.net/u010976213/article/details/110393920)

## 0、介绍

> 可以实现网格列表布局。（注意此API暂时还不稳定，有可能更改！）

在alpha 10的版本中，官方提供了该API，目前基于alpha 11版本进行演示。
## 1、属性一览
【目前基于alpha 11版本】请看该函数：
```
@Composable fun LazyVerticalGrid(
    cells: GridCells,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyGridScope.() -> Unit
): Unit
```


属性参数含义：

参数 | 含义
:----- |:-----
modifier: Modifier = Modifier | 应用于布局的修饰符
cells: GridCells | 一个描述单元格如何构成列的类，有关更多信息，请参见GridCells doc。例如：GridCells.Fixed(2)，表示均分屏幕宽的的两列表格。
contentPadding: PaddingValues = PaddingValues(0.dp） |  在整个的内容周围指定的填充距离
content: LazyGridScope.() -> Unit | 表格布局的每项子级布局

## 2、使用示例
因为该API还处于试验模式，所以注意注解：@ExperimentalFoundationApi，代码如下：
```
@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridDemo() {
    val listData = (0..4).toList()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(listData) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(
                        color = when {
                            it % 2 == 0 -> {
                                myBlue
                            }
                            else -> {
                                myRed
                            }
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "列表项：$it"
                )
            }
        }
    }
}
```
预览效果如下所示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210202201927256.png#pic_center)

## 3、版本更新
- 暂无

## 4、未解决问题
暂无，目前该API还处于试验模式，暂时不做过多研究，后期需要了解功能如下：
- 将某一item项填充满整个宽度，而不进行均分处理
- 类似原来RecyclerView中的ItemDecoration相关处理