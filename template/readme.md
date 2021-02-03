# template method design pattern
模版方法 设计模式

模板方法模式中定义一个算法,将特定的实现推迟到子类中,使得在不改变算法的情况下,通过子类来实现定制化的流程和步骤
上面的算法,我们可以理解成业务逻辑,并不是指特定的算法或数据结构.


模版方法在JAVA io 库中的应用:

InputStream是一个典型的模版方法,他是一个抽象类,有一个抽象方法read 
子类需要实现抽象方法read() ,在不同的子类中 他有不同的流程 如:ByteArrayInputStream


--- 
拓展:
decorator 也就是装饰器模式,在java io 库中的应用也是在inputstream中体现  

FilterInputStream 继承于InputStream  使用装饰器模式,继承于FilterInputStream的子类的实现使用各种方式实现read(),可以使用嵌套方式来处理流,
