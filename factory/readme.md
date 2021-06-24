### 工厂模式:

> 当创建逻辑比较复杂时，就可以考虑使用工厂模式，封装对象的创建过程，将对象的创建和使用相分离。

工厂模式，属于创建类型



实际代码我放在了Github: https://github.com/liangtengyu/DesignPatterns-for-Java

### 应用场景:

学习一个设计模式之前 我们先了解它的使用场景能够帮我们更快的理解它,
相对于直接 new 来创建对象，用工厂模式来创建究竟有什么好处呢？

主要有两种情况:

* 第一种情况是类似规则配置解析的例子，代码中存在 if-else 分支判断，动态的根据不同的类型创建不同的对象。针对这种情况，我们就可以考虑使用工厂模式，将这一大块的 if-else 创建对象的代码抽离出来，放到工厂类中。

* 还有一种情况是，尽管我们不需要根据不同的类型创建不同的对象，但是，单个对象本身的创建过程比较复杂，我们也可以考虑使用工厂模式。

好处:由于工厂模式是依靠抽象架构的，它把实例化产品的任务交由实现类完成，扩展性比较好。也就是说，当需要系统有比较好的扩展性时，可以考虑工厂模式，不同的产品用不同的实现工厂来组装。通俗的讲就是降低代码改变对产品功能的影响.

### 实现方式:

#### 简单工厂（Simple Factory）

首先，我们来看，什么是简单工厂模式。我们通过一个例子来解释一下。

[简单工厂模式](https://github.com/liangtengyu/DesignPatterns-for-Java/blob/master/factory/src/main/java/simpleFactory)



```java
public class Cocacola implements Cola {
    public String getCola() {
        return "可口可乐";
    }
}
```


```java
public class ColaFactory {

    public static Cola getInstance(Integer  colaType) {
        if (1 == colaType) {
            return new Cocacola();
        } else if (2 == colaType) {
            return new Pepsicola();
        } else {
            return new Fakecola();
        }
    }

}
```



```java
 public static void main(String[] args) {
        String drink = ColaFactory.getInstance(1).drink();
        System.out.println(drink);
    }
    //可口可乐
```

尽管简单工厂模式的代码实现中，有多处 if 分支判断逻辑，违背开闭原则，但权衡扩展性和可读性，这样的代码实现在大多数情况下是没有问题的。



#### 工厂方法（Factory Method）

工厂方法是简单工厂的进一步的延伸，这样说是因为简单工厂违反了开闭原则，而此时工厂方法却可以完美的解决这个问题！接下来看看它是怎么解决的吧！

[工厂方法 - 项目](file:/Users/tengyu/IdeaProjects/designs/factory/src/main/java/factoryMethod)

对于规则配置文件解析这个应用场景来说，工厂模式需要额外创建诸多 Factory 类，也会增加代码的复杂性，而且，每个 Factory 类只是做简单的 new 操作，功能非常单薄（只有一行代码），也没必要设计成独立的类，所以，在这个应用场景下，`简单工厂模式`好用，比`工厂方法模式`更加合适



```java
public interface ColaFactory {//工厂接口
    Cola getCola();
}
```



```java
public class CocaColaFactoryImpl implements ColaFactory {//实现可口可乐工厂
    public Cola getCola() {
        return  new Cocacola();
    }
}
```



```java
public static void main(String[] args) {
    //工厂方法需要一个可乐时,直接去对应的工厂拿,而是不像简单工厂那样 都是从一个工厂中根据判断来拿
    //每一种可乐都对应一个工厂
    ColaFactory pepsiColaFactory = new PepsiColaFactoryImpl();
    Cola cola = pepsiColaFactory.getCola();
    cola.getCola();
}
```

### 什么时候该用工厂方法模式，而非简单工厂模式呢？

​		之所以将某个代码块剥离出来，独立为函数或者类，原因是这个代码块的逻辑过于复杂，剥离之后能让代码更加清晰，更加可读、可维护。

​		但是，如果代码块本身并不复杂，就几行代码而已，我们完全没必要将它拆分成单独的函数或者类。基于这个设计思想，当对象的创建逻辑比较复杂，不只是简单的 new 一下就可以，而是要组合其他类对象，做各种初始化操作的时候，我们推荐使用工厂方法模式，将复杂的创建逻辑拆分到多个工厂类中，让每个工厂类都不至于过于复杂。而使用简单工厂模式，将所有的创建逻辑都放到一个工厂类中，会导致这个工厂类变得很复杂。

​		除此之外，在某些场景下，如果对象不可复用，那工厂类每次都要返回不同的对象。如果我们`使用简单工厂模式来实现`，`就只能选择第一种包含 if 分支逻辑的实现方式`。如果我们还想避免烦人的 if-else 分支逻辑，这个时候，我们就推荐使用工厂方法模式。

#### 抽象工厂（Abstract Factory）

抽象工厂模式的应用场景比较特殊，没有前两种常用，我们简单了解一下

简单工厂只是对可乐产品进行了抽象,工厂方法是对可乐工厂进行抽象,抽象工厂是对工厂方法的再次抽象

光从概念可能不好理解,我们来个实例

需求:现在产品线调整了,我们生产的可乐 虽然有各自的品牌但是都是透明瓶子,我们要做出自己的特点.需要给不同品牌的可乐喷涂不同的颜色瓶身.

思考:如果此时我们将可乐的生产和颜色的喷涂都耦合在工厂方法的代码中,后续调整会很麻烦,也违背了开闭原则,对拓展开放,对修改关闭,那么此时我们使用抽象工厂就比较合适了



```java
public abstract class ColaAbstractFactory {//创建抽象工厂类
    abstract ColaFactory getCola(String cola);
    abstract ColorFactory getColor(String color);
}
```



```java
public class ColaAbstractFactoryImpl extends ColaAbstractFactory {

		//实现抽象类
   public ColaFactory getCola(String cola) {
        if ("cocacola".equals(cola)) {
            return new CocaColaFactoryImpl();
        } else if ("fake".equals(cola)) {
            return new FakeColaFactoryImpl();
        } else if ("pepsi".equals(cola)) {
            return new PepsiColaFactoryImpl();
        } else
            return null;
    }

    public ColorFactory getColor(String color) {
        if ("yellow".equals(color)) {
            return new YellowColorFactoryImpl();
        } else if ("blue".equals(color)) {
            return new BlueColorFactoryImpl();
        } else if ("red".equals(color)) {
            return new RedColorFactoryImpl();
        } else
            return null;
    }
}
```

```java
public class RedColorFactoryImpl implements ColorFactory {//对不同颜色的需求进行喷涂.其它颜色类似就不重复贴了
    public String getColor() {
        System.out.println("喷涂红色瓶身");
        return "红色瓶子";
    }
}
```

最终我们想要获得可乐+红色瓶身

```java
public static String getColaAndColor(String cola,String color){
    ColaAbstractFactoryImpl colaAbstractFactory = new ColaAbstractFactoryImpl();

    ColaFactory cola = colaAbstractFactory.getCola(cola);
    ColorFactory red = colaAbstractFactory.getColor(color);

    Cola col = cola.getCola();
    String colo = red.getColor();
    return col.getCola()+"-"+colo;
}
```



```java
public static void main(String[] args) {
    String colaAndColor = FactoryProducer.getColaAndColor("cocacola", "red");
    System.out.println(colaAndColor);

}
//output:
喷涂红色
生产可口可乐
可口可乐-红色瓶子
```



## 工厂模式学习的思考
### 工厂分类
 
工厂模式可以细分为三种类型：简单工厂、工厂方法和抽象工厂。

当创建逻辑比较复杂时，就可以考虑使用工厂模式，封装对象的创建过程，将对象的创建和使用相分离。何为创建逻辑毕竟复杂呢？主要有两种情况，第一种情况是类似规则配置解析的例子，代码中存在 if-else 分支判断，动态的根据不同的类型创建不同的对象。针对这种情况，我们就可以考虑使用工厂模式，将这一大块的 if-else 创建对象的代码抽离出来，放到工厂类中。还有一种情况是，尽管我们不需要根据不同的类型创建不同的对象，但是，单个对象本身的创建过程比较复杂，比如前面提到的要组合其他类对象，做各种初始化操作，在这种情况下，我们也可以考虑使用工厂模式。

常见的工厂模式有 DataFormat 类、String.valueOf 等等。


### 带着问题学习
搞清楚应用场景：什么时候该用工厂模式？相对于直接 new 来创建对象，用工厂模式来创建究竟有什么好处呢？

### 简单工厂（Simple Factory）
首先，我们来看，什么是简单工厂模式。我们通过一个例子来解释一下。

[简单工厂模式](src/main/java/simpleFactory)

```java
public class ColaFactory {

    public static Cola getInstance(Integer  colaType) {
        if (1 == colaType) {
            return new Cocacola();
        } else if (2 == colaType) {
            return new Pepsicola();
        } else {
            return new Fakecola();
        }
    }

}
```

```java
 public static void main(String[] args) {
        String drink = ColaFactory.getInstance(1).drink();
        System.out.println(drink);
    }
    //喝可口可乐
    //喝可口可乐
```
总结一下，尽管简单工厂模式的代码实现中，有多处 if 分支判断逻辑，违背开闭原则，但权衡扩展性和可读性，这样的代码实现在大多数情况下是没有问题的。

### 工厂方法（Factory Method）
工厂方法是简单工厂的进一步的延伸，这样说是因为简单工厂违反了开闭原则，而此时工厂方法却可以完美的解决这个问题！接下来看看它是怎么解决的吧！

[工厂方法 - 项目](src/main/java/factoryMethod)


对于规则配置文件解析这个应用场景来说，工厂模式需要额外创建诸多 Factory 类，也会增加代码的复杂性，而且，每个 Factory 类只是做简单的 new 操作，功能非常单薄（只有一行代码），也没必要设计成独立的类，所以，在这个应用场景下，简单工厂模式简单好用，比工厂方法模式更加合适。

### 什么时候该用工厂方法模式，而非简单工厂模式呢？
之所以将某个代码块剥离出来，独立为函数或者类，原因是这个代码块的逻辑过于复杂，剥离之后能让代码更加清晰，更加可读、可维护。但是，如果代码块本身并不复杂，就几行代码而已，我们完全没必要将它拆分成单独的函数或者类。基于这个设计思想，当对象的创建逻辑比较复杂，不只是简单的 new 一下就可以，而是要组合其他类对象，做各种初始化操作的时候，我们推荐使用工厂方法模式，将复杂的创建逻辑拆分到多个工厂类中，让每个工厂类都不至于过于复杂。而使用简单工厂模式，将所有的创建逻辑都放到一个工厂类中，会导致这个工厂类变得很复杂。除此之外，在某些场景下，如果对象不可复用，那工厂类每次都要返回不同的对象。如果我们`使用简单工厂模式来实现`，`就只能选择第一种包含 if 分支逻辑的实现方式`。如果我们还想避免烦人的 if-else 分支逻辑，这个时候，我们就推荐使用工厂方法模式。


### 抽象工厂（Abstract Factory）
抽象工厂模式的应用场景比较特殊，没有前两种常用，简单了解一下就可以了

[抽象工厂 - 项目](src/main/java/abstractFactory)

