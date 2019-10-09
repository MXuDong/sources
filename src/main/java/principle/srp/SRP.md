# 单一职责原则 - Single Responsibility Principle - SRP

## 原则描述
    There should never be more than one reason for a class to change.
    
    一个类有且只有一个变化的原因。
职责是指引起类变动的原因，如果一个类改变的动机多余一个，那么该类就不符合SRP原则。

换句话说，一个类只能做一件事。单一职责是降低耦合度最基本的原则。    

看似单一职责非常简单，但是在实际中，单一职责是非常容易忽略的设计原则。

看一个非常常见的接口代码
```java
/**
 * 数据库工具DBUtil的抽象接口
 * 方便处理不同数据而提供的统一操作
 * 列举两个非常常用的方法
 *
 * @author Dong
 */
public interface DBAble{
    /**
     * 数据库连接
     */
    void connection();
    
    /**
     * 获取指定数据并转换为String类型
     * 
     * @param field  指定字段
     * @param column 指定列
     * @return 结果
     */
    String getObject(String field, String column);
}
```
上面的代码中，就不符合SRP原则，将连接和数据处理放在了同一个类中。

推荐的方法为，将连接方法抽离为连接器，用来单独管理所有连接的类。