
## 责任链模式

责任链模式是指将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。将这些接收对象串成一条链，并沿着这条链传递这个请求，直到链上的某个接收对象能够处理它为止。在 GoF 的定义中，一旦某个处理器能处理这个请求，就不会继续将请求传递给后续的处理器了。当然，也存在请求不会被终止传递的场景，而是所有处理器都会处理一遍，OkHttp 的拦截器链使用的就是这种形式。

项目中

`version1`使用的是链表的方式,存储handler 

[点我查看 version-1](src/main/java/com/liangtengyu/version1)

`version2` 使用的是有序list来存储handler, 并且使用了模版方法的方式抽象出调用successor的逻辑使得项目更加简洁.

[点我查看 version-2](src/main/java/com/liangtengyu/version2)


责任链模式的实例:

Tomcat 使用 ApplicationFilterChain 实现Servlet Filter 来实现过滤器,并且内部使用迭代进行调用handler 
使用迭代的好处是可以实现双向过滤.在请求处理之后拦截response

Spring Interceptor 和ServletFilter 类似,不同之处在于Servlet是基于容器的,而Spring Interceptor是基于Spring框架实现的,请求过来后,先经过Servlet后经过Spring Interceptor,最后到达业务代码中.