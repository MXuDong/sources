# 接口的静态、默认方法

## static 关键字
在1.8之前，接口是没有办法写静态方法的。
原因很简单，静态方法必然有多种实现，但是怎么调用就成了问题。
不同的实现类不能保证具有相同的实现方案，所以不能有静态方法，这是从主观角度分析的。

### 静态方法使用方式
直接在方法前加上``static``关键字即可，然后写出静态方法的方法体。
```java
public interface TestStatic{
    static void test(){
        System.out.println("test static");
    }
}
```

## default 关键字
在1.8之前，接口是不能拥有方法体的，但是1.8之后，可以有默认方法，即``default``关键字修饰的方法。
用``default``关键字修饰的接口方法，必须提供方法体。

### 默认方法使用方式
直接在方法前加上``default``关键字即可
```java
public interface TestDefault{
    default void test(){
        System.out.println("test default");
    }
}
```

## 由于default和static关键字引发的问题
试想如下场景
动物和机器都能发出声音，动物都是自然发声，机器是驱动发声。
所以定义如下接口
```java
interface AnimalSoundAble{
    default void makeSound(){
        System.out.println("Animal make sound");
    }
}
interface MachineSoundAble{
    default void makeSound(){
        System.out.println("Machine make sound");
    }
}
```
但是突然，一只小鸭子嗓子坏了，所以安了个机器用来发声，因此这只小鸭子属于两个接口的实现类
```java
class BadDuck implements AnimalSoundAble, MachineSoundAble{
}
```
那么这个时候，他的发声该是什么？

这时候，编译器会报错，遇到同名默认方法，实现类必须重新实现。
所以上述过程，最后``BadDuck``的实际书写应该为
```java
class BadDuck implements AnimalSoundAble, MachineSoundAble{
    public void makeSound(){
        System.out.println("Animal make sound by machine");
    } 
}
```

### 1.8之后，接口和抽象类的区别
在这之前，我们很容易说明接口和抽象类的区别，但是现在，接口也可以有方法体了。
那么两者还有什么区别

1. 抽象类为单继承关系，但是接口可以多实现
2. 抽象类具有局部变量，但是接口只能由静态常量
3. 抽象类具有构造方法，接口没有构造方法
还有一些其他区别，此刻不再一一列举