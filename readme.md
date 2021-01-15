# DesignParttens
#### 六大设计原则

六大设计原则分别是单一职责原则、开闭原则、里式替换原则、接口隔离原则、依赖反转原则及迪米特原则。

##### 单一职责原则

单一职责原则意思是一个类只做一件事。也就是说，不要设计大而全的类，要设计粒度小、功能单一的类。

##### 开闭原则

开闭原则是指对扩展开放，对修改关闭。具象来说，就是添加一个新的功能时，优先考虑在已有代码的基础上扩展代码，而非修改已有代码，这也要求我们要能写出扩展性好的代码。对扩展开放是为了应对变化（需求），对修改关闭是为了保证已有代码的稳定性，最终结果是为了让系统更有弹性。

##### 里式替换原则

里式替换原则是指子类对象能够替换程序中父类对象出现的任何地方，并且保证原来程序的逻辑行为不变以及正确性不会被破坏。听起来有点运行时多态的味道，但是里式替换作为一种设计原则，是用来指导继承关系中子类该如何设计的，子类的设计要保证在替换父类的时候，不改变原有程序的逻辑以及不破坏原有程序的正确性。一些常见的违背里式替换原则的例子有，子类的方法重写违背了父类声明要实现的功能、子类违背父类对输入/输出/异常的约定、子类违背父类注释中所罗列的任何特殊说明等。简单来说，就是子完美继承了父类的设计初衷，并做了增强。

##### 接口隔离原则

接口隔离原则是指客户端不应该依赖于它不需要的接口。

##### 依赖反转原则

依赖反转是指高层模块不要依赖于低层模块，它们应该通过抽象来相互依赖。除此之外，抽象不要依赖具体实现细节，具体实现细节依赖抽象。

依赖反转容易跟控制反转、依赖注入相混淆。控制反转是一个比较笼统的设计思想，并不是一种具体的实现方法，一般用来指导框架层面的设计。这里所说的控制指的是对程序执行流程的控制，而反转指的是在没有使用框架之前，程序员自己控制整个程序的执行。在使用框架之后，整个程序的执行流程通过框架来控制。流程的控制权从程序员反转给了框架。依赖注入是一种具体的编码技巧，我们不通过 new 的方式在类内部创建依赖类的对象，而是将依赖的类对象在外部创建好之后，通过构造函数、函数参数等方式注入给类来使用。

##### 迪米特法则

即最小知识原则。说的是，不该有直接依赖关系的类，不要有依赖；有依赖关系的类之间，尽量只依赖必要的接口。迪米特法则是希望减少类之间的耦合，让类越独立越好，每个类都应该少了解系统的其他部分，一旦发生变化，需要了解这一变化的类就会比较少。它和单一职责的目的都是实现高内聚低耦合，但是出发的角度不一样，单一职责是从自身提供的功能出发，迪米特法则是从关系出发。

#### 单例模式

单例模式保证一个类仅有一个实例，并提供一个访问它的全剧访问点。它的实现有饿汉式、懒汉式、DCL、静态内部类和枚举。

单例模式的应用场景有避免资源访问冲突、表示业务概念上的全剧唯一类。

在 Android 中，常用的单例类有 LayoutInflater、LocalBroadcastManager 等。

#### 工厂模式

工厂模式可以细分为三种类型：简单工厂、工厂方法和抽象工厂。

当创建逻辑比较复杂时，就可以考虑使用工厂模式，封装对象的创建过程，将对象的创建和使用相分离。何为创建逻辑毕竟复杂呢？主要有两种情况，第一种情况是类似规则配置解析的例子，代码中存在 if-else 分支判断，动态的根据不同的类型创建不同的对象。针对这种情况，我们就可以考虑使用工厂模式，将这一大块的 if-else 创建对象的代码抽离出来，放到工厂类中。还有一种情况是，尽管我们不需要根据不同的类型创建不同的对象，但是，单个对象本身的创建过程比较复杂，比如前面提到的要组合其他类对象，做各种初始化操作，在这种情况下，我们也可以考虑使用工厂模式。

常见的工程模式有 DataFormat 类、String.valueOf 等等。

#### 构建者模式

构建者模式即 Builder 模式。如果一个类中有很多属性，为了避免构造函数的参数列表很长，影响代码的可读性和易用性，我们可以通过构造函数配合 setXxx() 方法来解决。不仅可以控制参数的必要性，还可以对参数进行合法性校验。

在 Android 中，最典型的应用莫过于 AlertDialog 了。

#### 代理模式

代理模式是指在不改变原始类的情况下，通过引入代理类来给原始类附加功能。代理可以分为静态代理和动态代理。

静态代理的实现比较简单，就是把实际的对象通过构造函数传给代理类，代理类可以在原有的基础上添加一些附加功能。动态代理不必像静态代理事先为每个原始类编写代理类，他可以在运行时动态的创建原始类的代理类，然后在系统中用代理类替换带原始类。在 Java 中的实现也比较简单，毕竟提供了InvocationHandler 来做，但是 Java 中的动态代理只能代理接口，如果想代理类就要使用 cglib 了。

在做插件化，Hook Activity 的生命周期时，就可以使用动态代理替换掉 ActivityThread 的 H 类的 handleMessage 方法。

#### 装饰器模式

装饰器模式主要解决继承关系过于复杂的问题，通过组合来替代继承。它主要的作用是给原始类添加增强功能。这也是判断是否该用装饰器模式的一个重要的依据。除此之外，装饰器模式还有一个特点，那就是可以对原始类嵌套使用多个装饰器。为了满足这个应用场景，在设计的时候，装饰器类需要跟原始类继承相同的抽象类或接口。这其实有点静态代理的内味，但是代理模式一般附加的是跟原始类无关的功能，比如打点，而在装饰器模式中，装饰器类附加的是跟原始类相关的增强功能。

在 Java 中，典型的装饰器模式应用就是 Java 的 I/O 类库了。

#### 适配器模式

适配器模式就是用来做适配的，它将不兼容的接口转化为可兼容的接口，让原本由于接口不兼容而不能在一起工作的类可以一起工作。适配器模式有两种实现方式：类适配器和对象适配器。其中，类适配器使用继承关系来实现，对象适配器使用组合关系来实现。

适配器模式的应用场景有：封装有缺陷的接口设计、替换依赖的外部系统、兼容老版本接口、适配不同格式的数据。

在 Android 中最常见的适配器模式就是 RecyclerView 的数据适配器了，Java 中的 Arrays.asList 也可以看做一种数据适配器，将数组类型的数据转化为集合数据类型。

结合上面所讲的代理模式和装饰者模式，这三种模式都属于结构型模式，也都可称为 Wrapper 模型，也就是通过 Wrapper 类二次封装原始类。但这三种设计模式的用意完全不同，也就是说要解决的问题、应用场景不同。代理模式在不改变原始类接口的条件下，为原始类定义一个代理类，主要目的是控制访问，而非加强功能，这是它跟装饰器模式最大的不同。装饰器模式是对原始类功能进行增强，并且支持多个装饰器的嵌套使用。适配器模式是一种事后的补救策略，适配器提供跟原始类不同的接口，而代理模式、装饰器模式提供的都是跟原始类相同的接口。

#### 观察者模式

观察者模式的表现形式是，在对象之间定义一个一对多的依赖，当一个对象状态改变的时候，所有依赖的对象都会自动接收到通知。

生产者消费者模型如消息队列，一般都可以看成是观察者模式。在 Android 中，最常见的观察者模式应用就是广播了。

在 Java 中的 util 包下也有 Observable 和 Observer，不过这个 Observable 是一个类而不是一个接口，其次它的所有方法比如 addObserver、deleteObserver、setChanged、notifyObservers 等都是加锁的，notifyObservers 由于加锁可能存在两个问题，新添加的观察者没有收到通知和注销的观察者依旧收到了通知。

#### 责任链模式

责任链模式是指将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，并沿着这条链传递这个请求，直到链上的某个接收对象能够处理它为止。在 GoF 的定义中，一旦某个处理器能处理这个请求，就不会继续将请求传递给后续的处理器了。Android 中事件分发机制的用的就是这种形式。当然，也存在请求不会被终止传递的场景，而是所有处理器都会处理一遍，OkHttp 的拦截器链使用的就是这种形式。

## 创建类模式:

创建型模式(Creational Pattern)对类的实例化过程进行了抽象，能够将软件模块中对象的创建和对象的使用分离。为了使软件的结构更加清晰，外界对于这些对象只需要知道它们共同的接口，而不清楚其具体地实现细节，使整个系统的设计更加符合单一职责原则。

创建型模式在创建什么(What)，由谁创建(Who)，何时创建(When)等方面都为软件设计者提供了尽可能大的灵活性。创建型模式隐藏了类的实例的创建细节，通过隐藏对象如何被创建和组合在一起达到使整个系统独立的目的。


- [单例模式  Singeton  ](单例模式/readme.md)
- [工厂模式  Factory  ](工厂模式/readme.md)
- [建造者模式 Builder](建造者模式/src/main/java)
- [原型模式 prototype](原型模式/src/main/java)


## 结构类模式:

结构型模式(Structural Pattern)描述如何将类或者对 象结合在一起形成更大的结构，就像搭积木，可以通过 简单积木的组合形成复杂的、功能更为强大的结构。

结构型模式可以分为类结构型模式和对象结构型模式：

类结构型模式关心类的组合，由多个类可以组合成一个更大的
系统，在类结构型模式中一般只存在继承关系和实现关系。 - 对象结构型模式关心类与对象的组合，通过关联关系使得在一 个类中定义另一个类的实例对象，然后通过该对象调用其方法。 根据“合成复用原则”，在系统中尽量使用关联关系来替代继 承关系，因此大部分结构型模式都是对象结构型模式。


- [适配器模式 Adapter](适配器模式/src/main/java)
- [桥接模式 Bridge](桥接模式/src/main/java)
- [组合模式 Composite](组合模式/src/main/java)
- [装饰器模式 Decorator](装饰器模式/src/main/java)
- [外观模式/门面模式 Facade](外观模式-门面模式/src/main/java)
- [享元模式 Flyweight](享元模式/src/main/java)
- [代理模式 Proxy](抽象工厂+动态代理/src/main/java)

## 行为类模式
行为型模式(Behavioral Pattern)是对在不同的对象之间划分责任和算法的抽象化。

行为型模式不仅仅关注类和对象的结构，而且重点关注它们之间的相互作用。

通过行为型模式，可以更加清晰地划分类与对象的职责，并研究系统在运行时实例对象 之间的交互。在系统运行时，对象并不是孤立的，它们可以通过相互通信与协作完成某些复杂功能，一个对象在运行时也将影响到其他对象的运行。

行为型模式分为类行为型模式和对象行为型模式两种：

类行为型模式：类的行为型模式使用继承关系在几个类之间分配行为，类行为型模式主要通过多态等方式来分配父类与子类的职责。
对象行为型模式：对象的行为型模式则使用对象的聚合关联关系来分配行为，对象行为型模式主要是通过对象关联等方式来分配两个或多个类的职责。根据“合成复用原则”，系统中要尽量使用关联关系来取代继承关系，因此大部分行为型设计模式都属于对象行为型设计模式。


- [职责链模式  Chain ofResponsibility](/src/main/java)

- [命令模式 Command](/src/main/java)

- [解释器模式 Interpreter](/src/main/java)

- [迭代器模式 Iterator](/src/main/java)

- [中介者模式 Mediator](/src/main/java)

- [备忘录模式 Memento](/src/main/java)

- [观察者模式 Observer](/src/main/java)

- [状态模式 State](/src/main/java)

- [策略模式 Strategy](/src/main/java)

- [模板方法模式 TemplateMethod](/src/main/java)

- [访问者模式 Visitor](/src/main/java)

 



 