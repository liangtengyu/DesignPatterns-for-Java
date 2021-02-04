# 原型模式 prototype
概念: 基于原型复制进行对象的创建,用来节省时间.


使用场景: 当一个类需要大量计算或者从RPC,网络,数据库中获取耗时长时,可以使用原型模式


问题: 会涉及到深浅拷贝

- 深拷贝实现: 
  - 1 可通过序列化再反序列化 
  - 2 通过递归拷贝


---

拓展: `copy on write 思想`      写时复制

概念: 复制对象时,先是基于共享引用,当一方需要修改数据时,才真正复制数据,创建新对象并修改

场景: 读多写少的情况  , 读写分离

缺点: 
- 1. 频繁修改数据会导致复制多份造成GC压力
- 2. 数据一致性有保证了,但是实时性没有保证
