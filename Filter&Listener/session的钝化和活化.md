# session的钝化和活化

钝化：内存----->硬盘

活化：硬盘----->内存

session对象的四种状态：

~~~java
session.setAttribute("a",xxx);		//将对象a绑定到session中
session.remove("a");						//将对象a从session中解绑
钝化
活化
~~~

监听绑定和解绑：接口HttpSessionBindingListener

监听钝化和活化：接口HttpSessionActivationListener

## 绑定解绑

~~~java
public class BeanListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定：Bean对象（将Bean对象增加到session域），绑定的对象："+this+"，sessionId："+event.getSession().getId());
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("解绑：Bean对象（将Bean对象从session域中remove），解绑的对象："+this+"，sessionId："+event.getSession().getId());
	}
}
~~~



下面是连续两次访问binding.jsp页面时的输出结果:

~~~java
//第一次
绑定：Bean对象（将Bean对象增加到session域），绑定的对象：org.student.listener.BeanListener@2e9bddbb，sessionId：407F82B631D42757E9BD953A5C329C52
    
 //第二次
绑定：Bean对象（将Bean对象增加到session域），绑定的对象：org.student.listener.BeanListener@6b087a3f，sessionId：407F82B631D42757E9BD953A5C329C52
解绑：Bean对象（将Bean对象从session域中remove），解绑的对象：org.student.listener.BeanListener@2e9bddbb，sessionId：407F82B631D42757E9BD953A5C329C52
~~~

第一次访问绑定一个对象，第二次又绑定一个对象，但两个Attribute的key是一样的，所以就相当于第二个将前一个给覆盖了，所以第一个对象会解绑

## 钝化和活化

如何钝化和活化：配置tomcat安装目录/conf/context.xml，也可直接配置eclipse目录里的server下的context.xml（Linux下推荐，因为安装目录可能需要管理员权限，导致无法创建目录）

~~~jsp
<!-- 通过配置实现钝化、活化
	maxIdleSwap:最大空闲时间，如果超过该时间，将会被钝化
	FileStore:通过该类具体实现钝化操作
	directory:相对路径,相对于tomcat/work/Catalina/localhost/ProjectName（也可绝对路径）
    -->
    <Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="5">
	<Store className="org.apache.catalina.session.FileStore" directory="/home/zhangqi/桌面/dunhua"/>
    </Manager>
~~~

钝化、活化的本质就是序列化和反序列化，所以需要实现Serializable接口

## 总结

钝化、活化实际执行是通过context.xml中进行配置而进行的

活化：session中获取某一个对象时，如果该对象不存在，则直接尝试从之前钝化的文件中去获取HttpSessionActivationListener只是负责在session钝化和活化时予以监听