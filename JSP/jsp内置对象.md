# 内置对象

## 四种范围对象
* pageContext      JSP页面容器      当前页面有效(页面跳转后无效)
* request          请求对象         同一次请求有效（请求转发后有效，重定向后无效）
* session          会话对象         同一次会话有效（无论怎么跳转都有效；关闭/切换浏览器后无效；从登陆->退出 之间全部都有效）
* application      全局对象         全局有效（整个项目有效切换浏览器任然有效；关闭项目，关闭服务，其他项目无效）

### 共有方法
~~~java
Object getAttribute(String name);   //根据属性名，获取属性值
void setAttribute(String name, Object obj); //设置属性值（新增，修改，就和容器map一样）
void removeAttribute(String name);  //根据属性名，删除对象
~~~


## 其他对象
* response         响应对象
* config           配置对象
* page             当前JSP页面对象（相当于java中的this）
* out              输出对象
* exception        异常对象 