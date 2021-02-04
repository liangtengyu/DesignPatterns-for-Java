# template method design pattern
模版方法 设计模式

模板方法模式中定义一个算法,将特定的实现推迟到子类中,使得在不改变算法的情况下,通过子类来实现定制化的流程和步骤
上面的算法,我们可以理解成业务逻辑,并不是指特定的算法或数据结构.


模版方法的应用:

- 复用

- 扩展

复用的体现:
>InputStream是一个典型的模版方法,他是一个抽象类,有一个抽象方法read 
子类需要实现抽象方法read() ,在不同的子类中 他有不同的流程 如:ByteArrayInputStream

>Java AbstractList
> 在 Java AbstractList 类中，addAll() 函数可以看作模板方法，add() 是子类需要重写的方法，尽管没有声明为 abstract 的，但函数实现直接抛出了 UnsupportedOperationException 异常。前提是，如果子类不重写是不能使用的

```java

public boolean addAll(int index, Collection<? extends E> c) {
    rangeCheckForAdd(index);
    boolean modified = false;
    for (E e : c) {
        add(index++, e);
        modified = true;
    }
    return modified;
}

public void add(int index, E element) {
    throw new UnsupportedOperationException();
}
```
---
扩展的体现:

这里所说的扩展，并不是指代码的扩展性，而是指框架的扩展性，有点类似控制反转
> java Servlet 的doGet()、doPost() 是模板中可以由子类来定制的部分。实际上，这就相当于 Servlet 框架提供了一个扩展点（doGet()、doPost() 方法），让框架用户在不用修改 Servlet 框架源码的情况下，将业务代码通过扩展点镶嵌到框架中执行






--- 

decorator 也就是装饰器模式,在java io 库中的应用也是在inputstream中体现  

FilterInputStream 继承于InputStream  使用装饰器模式,继承于FilterInputStream的子类的实现使用各种方式实现read(),可以使用嵌套方式来处理流,
