# session
* 浏览网站：开始->关闭
* 购物：浏览->付款->退出
* 电子邮件：浏览->写邮件->退出
开始->结束
cookie保存在客户端，session保存在服务端

## session机制 
客户端第一次请求服务端的时候，服务端会产生一个session对象（用于保存该客户的信息）；并且每个session对象都会有一个唯一的sessionID（用于区分其他的session）；
服务端又会产生一个cookie，并且该cookie的name=JSESSIONID，value=服务端sessionID的值；然后服务端会在响应客户端的同时发送给客户端，至此客户端就有了一个cookie（JSESSIONID）；因此，客户端的cookie就可以和服务端的session一一对应（JSESSIONID - sessionID）

客户端第二/n次请求时:服务端会先用客户端cookie中的JSESSION去服务端的session中匹配sessionid，如果匹配成功（cookie jessionid和session sessionid），说明此用户不是第一次访问，就无需登录

## 示例
客户端：顾客
服务端：商场的存包处

顾客第一次存包：商场判断此人是否之前已经存过包（通过你手里是否有钥匙）。
如果是新顾客，说明没钥匙，分配一把要是给该顾客；钥匙会和柜子一一对应，第二/n次存包，商场判断此人是否之前已经存过包，如果是老顾客（有钥匙），则不需要分配，该顾客手里的钥匙🔑会和柜子一一对应

## session特点
* session的属性即Attribute，也是键值对
* session存储在服务端
* session是在同一个用户（客户）请求时共享
* 实现机制：第一次客户请求时，产生一个sessionid，并赋值给cookie的jsessionid，然后发给客户端。最终，通过session的sessionid实现一一对应

## session方法
~~~java
String getId();    //获取sessionID
boolean isNew();    //判断是否是新用户（第一次访问）
void invalidate();  //使session失效（退出登录、注销）

setAttribute();
getAttribute();

void setMaxInactiveInterval(秒);//设置最大有效非活动时间
int getMaxInactiveInterval();   //获得最大非活动时间
~~~

|item|session|cookie
|:-:|:-:|:-:|
|保存的位置|服务端|客户端|
|安全性|较安全|较不安全|
|保存的内容|(String,Object)|(String,String)|