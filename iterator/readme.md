## 迭代器模式(Iterator)
提供一种方法顺序访问一个聚合对象中的各种元素，而又不暴露该对象的内部表示。
迭代器模式将集合对象的遍历操作从集合类中拆分出来，放到迭代器类中，让两者的职责更加单一。更加符合开闭原则.


迭代器的两种接口实现方式:
1. 
   
```java
public interface Iterator<E>{
    boolean hasNext();
    E getCurrentElement;
    void next();
}
```
2.

```java
public interface Iterator<E>{
    boolean hasNext();
    E next();
}
```

第一种方式,获取对象和挪动游标指向分开实现,更加灵活,可以多次获取当前对象而不挪动游标.
