### 单例模式:

单例模式，顾名思义就是只有一个实例，并且她自己负责创建自己的对象，这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象

单例模式，属于创建类型



### 应用场景:

学习一个设计模式之前 我们先了解它的使用场景能够帮我们更快的理解它,

单例模式只允许创建一个对象，因此更节省内存，加快对象访问速度，因此对象需要被公用的场合适合使用，如多个模块使用同一个数据源连接对象等等.如：

* 需要频繁实例化然后销毁的对象。
*  创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
* 有状态的工具类对象。
* 频繁访问数据库或文件的对象。



### 实现方式:

#### 饿汉式

```java
public class Singleton_3 {
    //使用饿汉式   线程安全
    private static Singleton_3 instance = new Singleton_3() ;

    private Singleton_3() {
    }

    public  static Singleton_3 getInstance() {

        return instance;
    }
}
```

#### 懒汉式 - 线程安全

```java
public class Singleton_2 {
    //使用懒汉式  线程安全 不建议使用
    private static Singleton_2 instance =null ;

    private Singleton_2() {
    }

    public synchronized static Singleton_2 getInstance() {
        if (instance !=null) return instance;
        return new Singleton_2();
    }
}
```

#### 懒汉式 - 非线程安全

```java
public class Singleton_1 {
    //使用懒汉式  非线程安全
    private static Singleton_1 instance =null ;

    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance !=null) return instance;
        return new Singleton_1();
    }
}
```

#### 静态类方式

```java
public class sigleton0 {       //使用静态类方式实现单例
    private static ConcurrentHashMap cache = new ConcurrentHashMap();

}
```

#### 内部类方式

```java
public class Singleton_4 {
    //使用内部类方式构造单例, 线程安全并且懒加载
    private AtomicInteger id = new AtomicInteger(0);


    private Singleton_4() {
    }

     public static  Singleton_4 getInstance(){
        return SingletonCreator.singleton_4;
    }

    private static class SingletonCreator{
        static  Singleton_4 singleton_4 = new Singleton_4();

    }
    public Integer getIncrementId(){
        return this.id.getAndIncrement();
    }
```



#### 双重校验锁方式

```java
public class Singleton_5 {
    //使用双重锁校验 线程安全
    private static Singleton_5 instance =null ;
    //满足懒加载
    private Singleton_5() {
    }

    public  static Singleton_5 getInstance() {
        if (instance !=null) return instance;
        synchronized (Singleton_5.class) {
            if (instance == null) {
                return new Singleton_5();
            }
        }
        return new Singleton_5();
    }
}
```

#### 原子类方式

```java
public class Singleton_6 {
    //使用atomicrefence  使用CAS方式  支持懒加载
    private static AtomicReference<Singleton_6> INSTANCE = new AtomicReference<Singleton_6>();

    private Singleton_6() {
    }

    public static Singleton_6 getInstance(){
        for (; ; ) {
            Singleton_6 singleton_6 = INSTANCE.get();
            if (null != singleton_6)return singleton_6;
            INSTANCE.compareAndSet(null, new Singleton_6());
            return INSTANCE.get();
        }

    }
```



### 实验

每次获取单例对象的结果实际都是同一个对象

```java
public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
        //获取实例
        Singleton_4 instance = Singleton_4.getInstance();
        //输出地址
        System.out.println("实例的地址:" + instance);
        //获取id
        System.out.println(instance.getIncrementId());
        System.out.println("-------------------------------------------------");
    }
}
```



结果 :



```java
实例的地址:Singleton_4@63947c6b
0
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
1
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
2
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
3
-------------------------------------------------
  .....
```




## 学习单例的思考
 

单例模式保证一个类仅有一个实例，并提供一个访问它的全剧访问点。它的实现有饿汉式、懒汉式、DCL、静态内部类和枚举。

单例模式的应用场景有避免资源访问冲突、表示业务概念上的唯一类。 

### 单例存在哪里问题?

#### 1.单例对oop的支持不友好

OOP 四大特性: 封装 继承 多态 抽象
而单例这种设计模式对于其中的抽象 继承 多态 都支持的不好 为什么这么说呢?

我们先来看一个单例的例子

```java
public class Singleton_4 {
    //使用内部类方式构造单例, 线程安全并且懒加载
    private AtomicInteger id = new AtomicInteger(0);


    private Singleton_4() {
    }

    public static Singleton_4 getInstance() {
        return SingletonCreator.singleton_4;
    }

    private static class SingletonCreator {
        static Singleton_4 singleton_4 = new Singleton_4();

    }

    public Integer getIncrementId() {
        return this.id.getAndIncrement();
    }
}
```

```java
 for (int i = 0; i < 100; i++) {
            //获取实例
            Singleton_4 instance = Singleton_4.getInstance();
            //输出地址
            System.out.println("实例的地址:" + instance);
            //获取id
            System.out.println(instance.getIncrementId());
            System.out.println("------------------------------");
        }
```
```xml
实例的地址:Singleton_4@63947c6b
0
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
1
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
2
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
3
-------------------------------------------------
实例的地址:Singleton_4@63947c6b
4
-------------------------------------------------
```
这是因为 单例的使用方式违背了基于接口而非实现编程原则,也就违背了广义上理解的 OOP 的抽象特性。如果未来某一天，我们希望针对不同的业务采用不同的 ID 生成算法。比如，订单 ID 和用户 ID 采用不同的 ID 生成器来生成。为了应对这个需求变化，我们需要修改所有用到 IdGenerator 类的地方，这样代码的改动就会比较大
除此之外，单例对继承、多态特性的支持也不友好。这里我之所以会用“不友好”这个词，而非“完全不支持”，是因为从理论上来讲，单例类也可以被继承、也可以实现多态，只是实现起来会非常奇怪，会导致代码的可读性变差。不明白设计意图的人，看到这样的设计，会觉得莫名其妙。所以，一旦你选择将某个类设计成到单例类，也就意味着放弃了继承和多态这两个强有力的面向对象特性，也就相当于损失了可以应对未来需求变化的扩展性。

#### 2.单例会隐藏类之间的依赖关系
代码的可读性非常重要。在阅读代码的时候，我们希望一眼就能看出类与类之间的依赖关系，搞清楚这个类依赖了哪些外部类。通过构造函数、参数传递等方式声明的类之间的依赖关系，我们通过查看函数的定义，就能很容易识别出来。但是，单例类不需要显示创建、不需要依赖参数传递，在函数中直接调用就可以了。如果代码比较复杂，这种调用关系就会非常隐蔽。在阅读代码的时候，我们就需要仔细查看每个函数的代码实现，才能知道这个类到底依赖了哪些单例类。

#### 3. 单例对代码的扩展性不友好
在系统设计初期，我们觉得系统中只应该有一个数据库连接池，这样能方便我们控制对数据库连接资源的消耗。所以，我们把数据库连接池类设计成了单例类。但之后我们发现，系统中有些 SQL 语句运行得非常慢。这些 SQL 语句在执行的时候，长时间占用数据库连接资源，导致其他 SQL 请求无法响应。为了解决这个问题，我们希望将慢 SQL 与其他 SQL 隔离开来执行。为了实现这样的目的，我们可以在系统中创建两个数据库连接池，慢 SQL 独享一个数据库连接池，其他 SQL 独享另外一个数据库连接池，这样就能避免慢 SQL 影响到其他 SQL 的执行。如果我们将数据库连接池设计成单例类，显然就无法适应这样的需求变更，也就是说，单例类在某些情况下会影响代码的扩展性、灵活性。所以，数据库连接池、线程池这类的资源池，最好还是不要设计成单例类。实际上，一些开源的数据库连接池、线程池也确实没有设计成单例类。

#### 4. 单例对代码的可测试性不友好
单例模式的使用会影响到代码的可测试性。如果单例类依赖比较重的外部资源，比如 DB，我们在写单元测试的时候，希望能通过 mock 的方式将它替换掉。而单例类这种硬编码式的使用方式，导致无法实现 mock 替换

#### 5. 单例不支持有参数的构造函数
单例不支持有参数的构造函数，比如我们创建一个连接池的单例对象，我们没法通过构造函数来指定连接池的大小.下面有`两种解决方案`
##### 1.使用特定的初始化方法
```java

public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    public synchronized static Singleton init(int paramA, int paramB) {
        if (instance != null){
            throw new RuntimeException("Singleton has been created!");
        }
        instance = new Singleton(paramA, paramB);
        return instance;
    }
}

        Singleton.init(10, 50); // 先init，再使用
        Singleton singleton = Singleton.getInstance();
```
##### 2.将参数放到 getIntance() 方法中
```java

public class Singleton {
  private static Singleton instance = null;
  private final int paramA;
  private final int paramB;

  private Singleton(int paramA, int paramB) {
    this.paramA = paramA;
    this.paramB = paramB;
  }

  public synchronized static Singleton getInstance(int paramA, int paramB) {
    if (instance == null) {
      instance = new Singleton(paramA, paramB);
    }
    return instance;
  }
}

Singleton singleton = Singleton.getInstance(10, 50);
```
不知道你有没有发现，上面的代码实现稍微有点问题。如果我们如下两次执行 getInstance() 方法，那获取到的 singleton1 和 signleton2 的 paramA 和 paramB 都是 10 和 50。也就是说，第二次的参数（20，30）没有起作用，而构建的过程也没有给与提示，这样就会误导用户

如果要解决这种问题.既然是单例模式，类本身的初始化过程就只允许有一次，那么我建议就不要在getInstance中做参数的传递，直接以配置文件的形式，方法内部直接读取配置参数，这样就不会误导用户了。

### 有什么替代方案

为了保证全局唯一，除了使用单例，我们还可以用静态方法来实现。这也是项目开发中经常用到的一种实现思路。比如:

```java

// 静态方法实现方式
public class IdGenerator {
  private static AtomicLong id = new AtomicLong(0);
  
  public static long getId() { 
    return id.incrementAndGet();
  }
}
// 使用举例
long id = IdGenerator.getId();
```
不过，静态方法这种实现思路，并不能解决我们之前提到的问题。实际上，它比单例更加不灵活，比如，它无法支持延迟加载。我们再来看看有没有其他办法。实际上，单例除了我们之前讲到的使用方法之外，还有另外一种使用方法。具体的代码如下所示：

```java

// 1. 老的使用方式
public demofunction() {
  //...
  long id = IdGenerator.getInstance().getId();
  //...
}

// 2. 新的使用方式：依赖注入
public demofunction(IdGenerator idGenerator) {
  long id = idGenerator.getId();
}
// 外部调用demofunction()的时候，传入idGenerator
IdGenerator idGenerator = IdGenerator.getInsance();
demofunction(idGenerator);
```

基于新的使用方式，我们将单例生成的对象，作为参数传递给函数（也可以通过构造函数传递给类的成员变量），可以解决单例隐藏类之间依赖关系的问题。不过，对于单例存在的其他问题，比如对 OOP 特性、扩展性、可测性不友好等问题，还是无法解决。所以，如果要完全解决这些问题，我们可能要从根上，寻找其他方式来实现全局唯一类。实际上，类对象的全局唯一性可以通过多种不同的方式来保证。我们既可以通过单例模式来强制保证，也可以通过工厂模式、IOC 容器（比如 Spring IOC 容器）来保证，还可以通过程序员自己来保证（自己在编写代码的时候自己保证不要创建两个类对象）。这就类似 Java 中内存对象的释放由 JVM 来负责，而 C++ 中由程序员自己负责，道理是一样的。

## 深入理解单例
### 如何理解单例模式中的唯一性？
我们重新看一下单例的定义：“一个类只允许创建唯一一个对象（或者实例），那这个类就是一个单例类，这种设计模式就叫作单例设计模式，简称单例模式。”定义中提到，“一个类只允许创建唯一一个对象”。那对象的唯一性的作用范围是什么呢？是指线程内只允许创建一个对象，还是指进程内只允许创建一个对象？答案是后者，也就是说，单例模式创建的对象是进程唯一的。这里有点不好理解，我来详细地解释一下。我们编写的代码，通过编译、链接，组织在一起，就构成了一个操作系统可以执行的文件，也就是我们平时所说的“可执行文件”（比如 Windows 下的 exe 文件）。可执行文件实际上就是代码被翻译成操作系统可理解的一组指令，你完全可以简单地理解为就是代码本身。当我们使用命令行或者双击运行这个可执行文件的时候，操作系统会启动一个进程，将这个执行文件从磁盘加载到自己的进程地址空间（可以理解操作系统为进程分配的内存存储区，用来存储代码和数据）。接着，进程就一条一条地执行可执行文件中包含的代码。比如，当进程读到代码中的 User user = new User(); 这条语句的时候，它就在自己的地址空间中创建一个 user 临时变量和一个 User 对象。进程之间是不共享地址空间的，如果我们在一个进程中创建另外一个进程（比如，代码中有一个 fork() 语句，进程执行到这条语句的时候会创建一个新的进程），操作系统会给新进程分配新的地址空间，并且将老进程地址空间的所有内容，重新拷贝一份到新进程的地址空间中，这些内容包括代码、数据（比如 user 临时变量、User 对象）。

所以，单例类在老进程中存在且只能存在一个对象，在新进程中也会存在且只能存在一个对象。而且，这两个对象并不是同一个对象，这也就说，`单例类中对象的唯一性的作用范围是进程内的，在进程间是不唯一的。`

### 如何实现线程唯一的单例？

线程唯一单例的代码实现很简单，如下所示。在代码中，我们通过一个 HashMap 来存储对象，其中 key 是线程 ID，value 是对象。这样我们就可以做到，不同的线程对应不同的对象，同一个线程只能对应一个对象。在JAVA中 线程实现单例 肯定会有同学想到ThreadLocal 实际上  ThreadLocal 工具类，可以更加轻松地实现线程唯一单例。不过，ThreadLocal 底层实现原理也是基于下面代码中所示的 HashMap。

```java

public class IdGenerator {
  private AtomicLong id = new AtomicLong(0);

  private static final ConcurrentHashMap<Long, IdGenerator> instances
          = new ConcurrentHashMap<>();

  private IdGenerator() {}

  public static IdGenerator getInstance() {
    Long currentThreadId = Thread.currentThread().getId();
    instances.putIfAbsent(currentThreadId, new IdGenerator());
    return instances.get(currentThreadId);
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
```

### 如何实现集群环境下的单例？
集群相当于多个进程构成的一个集合，“集群唯一”就相当于是进程内唯一、进程间也唯一。也就是说，不同的进程间共享同一个对象，不能创建同一个类的多个对象。
如果严格按照不同的进程间共享同一个对象来实现，那集群唯一的单例实现起来就有点难度了。具体来说，我们需要把这个单例对象序列化并存储到外部共享存储区（比如文件）。进程在使用这个单例对象的时候，需要先从外部共享存储区中将它读取到内存，并反序列化成对象，然后再使用，使用完成之后还需要再存储回外部共享存储区。为了保证任何时刻，在进程间都只有一份对象存在，一个进程在获取到对象之后，需要对对象加锁，避免其他进程再将其获取。在进程使用完这个对象之后，还需要显式地将对象从内存中删除，并且释放对对象的加锁。
```java

public class IdGenerator {
  private AtomicLong id = new AtomicLong(0);
  private static IdGenerator instance;
  private static SharedObjectStorage storage = FileSharedObjectStorage(/*入参省略，比如文件地址,或者这里可以使用redis 之类的*/);
  private static DistributedLock lock = new DistributedLock();
  
  private IdGenerator() {}

  public synchronized static IdGenerator getInstance() 
    if (instance == null) {
      lock.lock();
      instance = storage.load(IdGenerator.class);
    }
    return instance;
  }
  
  public synchroinzed void freeInstance() {
    storage.save(this, IdGeneator.class);
    instance = null; //释放对象
    lock.unlock();
  }
  
  public long getId() { 
    return id.incrementAndGet();
  }
}

// IdGenerator使用举例
IdGenerator idGeneator = IdGenerator.getInstance();
long id = idGenerator.getId();
IdGenerator.freeInstance();
```


结:

在文章中，我们讲到单例唯一性的作用范围是进程，实际上，对于 Java 语言来说，单例类对象的唯一性的作用范围并非进程，而是类加载器（Class Loader）

要回答这个问题，要理解classloader和JDK8中使用的双亲委派模型。
classloader有两个作用：1. 用于将class文件加载到JVM中；2. 确认每个类应该由哪个类加载器加载，并且也用于判断JVM运行时的两个类是否相等。
双亲委派模型的原理是当一个类加载器接收到类加载请求时，首先会请求其父类加载器加载，每一层都是如此，当父类加载器无法找到这个类时（根据类的全限定名称），子类加载器才会尝试自己去加载。
所以双亲委派模型解决了类重复加载的问题， 比如可以试想没有双亲委派模型时，如果用户自己写了一个全限定名为java.lang.Object的类，并用自己的类加载器去加载，同时BootstrapClassLoader加载了rt.jar包中的JDK本身的java.lang.Object，这样内存中就存在两份Object类了，此时就会出现很多问题，例如根据全限定名无法定位到具体的类。有了双亲委派模型后，所有的类加载操作都会优先委派给父类加载器，这样一来，即使用户自定义了一个java.lang.Object，但由于BootstrapClassLoader已经检测到自己加载了这个类，用户自定义的类加载器就不会再重复加载了。所以，双亲委派模型能够保证类在内存中的唯一性。
联系到课后的问题，所以用户定义了单例类，这样JDK使用双亲委派模型加载一次之后就不会重复加载了，保证了单例类的进程内的唯一性，也可以认为是classloader内的唯一性。当然，如果没有双亲委派模型，那么多个classloader就会有多个实例，无法保证唯一性。

---


启动类加载器:加载JAVA_HOME\lib目录下的类库

↑

扩展类加载器:加载JAVA_HOME\lib\ext目录下的类库,是java SE 扩展功能, jdk9 被模块化的天然扩展能力所取代

↑

应用程序加载器:加载用户的应用程序

↑

用户自定义的加载器:供用户扩展使用,加载用户想要的内容

---

这个类加载器的层次关系被称为类的"双亲委派模型"