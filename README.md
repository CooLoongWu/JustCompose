@[TOC](是时候拥抱Compose了！！！)

## 前言
Android上**View.java**的存在已经有十多年之久了，代码量也达到了惊人的**3万**行。而且其他很多的常用控件例如TextView、ImageView等又都直接或者间接继承自View，都说**组合优于继承**，所以针对View的这个设计，现在看来已经是落伍了。

去年（2019）年的时候，在AndroidDevSummit上，Google推出了**Compose**，当时眼前一亮，觉得Android上的UI开发要有一个全新的明天了。时隔一年，目前Compose已经从dev版本到了目前的alpha07版本。至于Compose是什么，有什么优点，其实在Google之前的各种视频中都有讲解了这里不再赘述，官网介绍请移步[Jetpack Compose](https://developer.android.google.cn/jetpack/compose)，官方文档请移步[Compose 文档](https://developer.android.google.cn/reference/kotlin/androidx/compose/material/package-summary)。

接下来的内容是基于Compose alpha07的一些东西，后面会根据相应的版本进行相关内容的更新。同时还需要声明一下，上文文档连接给的是**androidx.compose.material**的。为什么？因为Google在后面的一些更新中，将很多控件都从**foundation**包中移到了**material**包。也就是说我们后面的控件等内容的讲解都需要基于androidx.compose.material中的相关控件。

## 计划任务
跟最初学习View的时候一样，我们需要一个控件一个控件的去学习了解，先了解他的属性然后了解他的用法。
下面的任务列表是先基于xml中的控件名，然后对照Compose中的控件名展示出来的，目前还不完整，因为我也还在一步步的熟悉中，所以会根据进度慢慢的补充上来，有超链接的是已经更新完了的，请选择性阅读。
#### 1、控件
- [**TextView --> Text**](https://blog.csdn.net/u010976213/article/details/110397036)
- [**EditText --> TextField、OutlinedTextField**](https://blog.csdn.net/u010976213/article/details/110677986)
- [**ImageView --> Image**](https://blog.csdn.net/u010976213/article/details/110495456)
- Button->Button(多种)
- 待补充

#### 2、布局
- LinearLayout ->Row、Column
- ConstraintLayout->ConstraintLayout
- 待补充


#### 3、动画
- 待补充