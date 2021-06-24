### 建造者模式:

> 创建者模式隐藏了复杂对象的创建过程，它把复杂对象的创建过程加以抽象，通过子类继承或者重载的方式，动态的创建具有复合属性的对象。通俗的讲就是 创建可装配的复杂对象

建造者模式，属于创建类型



### 应用场景:

学习一个设计模式之前 我们先了解它的使用场景能够帮我们更快的理解它,实现方式:


- 当使用new()时 参数过多容易导致混乱和BUG的产生
  - 使用set方法赋值时 会创建一个可变对象,即对象创建完后还可以使用set方法改变变量,此时应该使用builer
  - 使用new关键字创建对象时,对于入参的校验比较混乱
  - 使用set方法时,对于入参的校验比较分散,不容易集中管理
  - **当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。**

- 使用Builder的好处
  - 将入参的校验逻辑都封装到build()方法中,进行统一的处理,处理完成才创建对象,否则不创建对象,方便管理校验逻辑
  - 使用build方法创建对象后,对象无法通过set方法进行修改参数,保证了对象的不可变



### 实现方式:

例:

```java
public class ResourceConfig {


    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourceConfig(ResourceConfigBuilder builder) {
        this.name = builder.name;//使用static 内部类可以直接拿属性
        this.maxTotal = builder.getMaxTotal();//也可以通过get方法获取
        this.maxIdle = builder.getMaxIdle();
        this.minIdle = builder.getMinIdle();
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public String toString() {
        return "ResourceConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }




    public static class ResourceConfigBuilder {
        private static final  int DEF_MAX_TOTAL = 8 ;
        private static final  int DEF_MAX_IDLE=0;
        private static final  int DEF_MIN_IDLE=0;

        private String name;
        private int maxTotal=DEF_MAX_TOTAL;
        private int maxIdle = DEF_MAX_IDLE;
        private int minIdle = DEF_MIN_IDLE;

        public ResourceConfigBuilder setName(String name) {
            this.name = name;
            return this;//返回this 能够实现链式调用
        }

        public ResourceConfigBuilder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public ResourceConfigBuilder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourceConfigBuilder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public String getName() {
            return name;
        }

        public int getMaxTotal() {
            return maxTotal;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public ResourceConfig build(){
            //校验逻辑放到build()方法之前,先校验 再 创建
            if (minIdle > maxTotal) {
                throw new IllegalArgumentException("无效的参数, cause : minIdle > maxTotal");
            }
            return new ResourceConfig(this);
        }
    }
}
```

### 总结-抽象理解


创建对象我们可以通过工厂方法和builder

*  工厂方法相当于对同类工厂抽象,如:披萨 汉堡 同是KFC的产品. 定向生产这2种产品工厂,披萨工厂 汉堡工厂

*  Builder相当于对于一种类的创建过程繁琐的抽象,如 披萨 我们在创建过程中想用什么肉类,什么蔬菜,甜还是咸,创建之前统一进行处理,到最终创建完成



# Builder
- 概念: 创建可装配的复杂对象
- 使用场景: 
  - 当使用new()时 参数过多容易导致混乱和BUG的产生
  - 使用set方法赋值时 会创建一个可变对象,即对象创建完后还可以使用set方法改变变量,此时应该使用builer
  - 使用new关键字创建对象时,对于入参的校验比较混乱
  - 使用set方法时,对于入参的校验比较分散,不容易集中管理
    
- 使用Builder的好处
  - 将入参的校验逻辑都封装到build()方法中,进行统一的处理,处理完成才创建对象,否则不创建对象,方便管理校验逻辑
  - 使用build方法创建对象后,对象无法通过set方法进行修改参数,保证了对象的不可变



-抽象理解:
创建对象我们可以通过工厂方法和builder

工厂方法相当于对同类工厂抽象,如:披萨 汉堡 同是KFC的产品. 定向生产这2种产品工厂,披萨工厂 汉堡工厂

Builder相当于对于一种类的创建过程繁琐的抽象,如 披萨 我们在创建过程中想用什么肉类,什么蔬菜,甜还是咸,创建之前统一进行处理,到最终创建完成