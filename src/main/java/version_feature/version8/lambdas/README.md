# Lambda表达式

## 简介
Lambda表达式（也称为闭包）是Java 8中最大和最令人期待的语言改变。
它允许我们将函数当成参数传递给某个方法，或者把代码本身当作数据处理：函数式开发者非常熟悉这些概念。

## Lambda组成
对于抽象类或者接口的快速实现可以利用匿名类实现，在某种程度上，非常冗余。

首先是匿名类的使用方法
```java
public class Test1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名类");
            }
        });
    }
}
```
然后将run方法的括号留下，将方法体留下,然后在括号和方法体之间用``->``连接就变成了
```java
public class Test1 {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{System.out.println("这是匿名类");});
    }
}
```
这样 ()->{System.out.println("这是匿名类"); 就是一个Lambda表达式了。

如果参数仅有一个，括号是可以省略的。
如果方法体仅有一行代码（指分号分隔的代码行），方法体外的花括号也是可以省略的
如果仅有一行代码是return代码，则return和分号也可以省略

## 自己实现一次Lambda
自定义接口、方法参数等，然后使用Lambda表达式。
[使用Lambda](TestLambda.java)

运行截图

![运行截图](TestLambda%20Result%201%20.png)