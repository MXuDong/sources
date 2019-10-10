# 函数式接口
函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。

函数式接口可以被隐式转换为 lambda 表达式。

在JDK8之前就已经有函数式接口，在JDK8中新增了``java.util.function``包，包下有很多接口

# 自定义函数式接口
使用注解：``@FunctionInterface``标注在接口名称上即可
```java
@FunctionalInterface
interface TestFunInterface{
    void doSomething(Object ... args);
}
```

然后按照正常的函数接口使用即可

在使用的时候，可以配合Lambda、MethodReference（方法引用-``::``)一起使用

