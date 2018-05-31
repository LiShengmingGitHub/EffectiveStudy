# 单例模式从浅入深分析
###### singleton
本文想按照如下思路来对单例模式做彻底的分析
1. 什么是单例模式？
2. 应用场景有哪些？
3. 单例模式常见的实现方式？
4. 你所提的单例模式能保证在反射的情况下还是单例吗？
5. 你所提的单例模式能保证在反序列化的情况下还是单例吗？

**正文**
*** 
## 1.什么是单例模式？
单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。

分析定义，单例模式核心特征归结如下：
1) 保证系统内至多有一个实例；
2) 能够自行初始化；
3) 单例类必须给所有其他对象提供这一实例。
### 2.常见的应用场景有哪些？
- 日志类
- 线程池
- 打印机
### 3.单例模式的常见实现
- 饿汉模式，[代码示例](code-section/lsm/study/design/model/singleton/HungryManSingleton.java)
- 懒汉模式，[懒汉模式1示例](code-section/lsm/study/design/model/singleton/LazyManSingleton1.java) [懒汉模式2示例](code-section/lsm/study/design/model/singleton/LazyManSingleton2.java)

饿汉模式缺点：类加载的时候就初始化了，浪费了资源。
于是乎就引入了延迟加载的思想，似曾相识吧，jdk1.7时，concurrenthashmap对于segment的初始化也是在使用的时候才初始化的。

懒汉模式1，用synchronized加在方法上了，注意，单例类这个方法是静态类，是一把类锁，如果类中还有其他竟然方法都会受截至，粒度是很大的。所以提出了第二种单例模式，同时考虑到多线程场景，需要双重判断。

似乎是比较完美了，单终归还是使用了用synchronized，于是乎，大牛们又整出了一个静态内部类的实现方式，[代码示例](code-section/lsm/study/design/model/singleton/StaticInnerClassSingelton1.java)

    知识点：静态内部类里的静态变量是在实际调用的时候初始化的，并且，由于不是方法调用， 所以不存在线程问题
静态内部类就完美了吗，当然不是，在一些很特殊的情况下，还是会有问题，一个是反射，一个是反序列化
### 4.反射情况下，如何保证单例？
通过分析代码，不难发现，只要通过反射破坏构造函数的访问性，就能够创建一个新实例

[测试代码示例](code-section/lsm/study/design/model/singleton/StaticInnerClassSingelton1Test.java)

解决方案，很简单，就是反射构造的时候给它抛出个异常就行了。

[示例](code-section/lsm/study/design/model/singleton/StaticInnerClassSingelton2.java)
### 5.反序列化下，如何保证单例？
序列化这种情况就太特殊了，就先不深入研究了。

需要实现序列化接口中的readResolve()方法来解决。应用场景很有限，做初步了解，知道有这么回事就行了。
***
**总结**

我并不认为最后的方案就是最优秀的方案，真正优秀的方案一定是与实际场景相结合的，你需要做的事情就是了解备选方案，清楚他们各自的优缺点，然后根据实际场景选择最合适的。
