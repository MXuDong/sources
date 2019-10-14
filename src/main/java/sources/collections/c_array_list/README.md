# ArrayList
type : class

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
# 类文档

可变大小数组实现了List接口。
实现了所有List接口的可选操作，并且允许所有类型的元素，包括``null``。
除了实现了List接口之外，本类一些方法来操纵内部用于存储列表的数组的大小。
（除了同步问题外，本类与Vector基本一致）

size、isEmpty、get、set、iterator、listIterator操作可以在常量时间内完成。
add操作需要消耗固定时间，添加n元素，需要O（n）的时间。
除此之外的其他所有操作在需要线性时间（粗略估计）。
与LinkedList相比，常数因子比较低。

每个ArrayList实例都有一个容量。
容量是List中用于存储元素的数组大小。
容量至少是与List.size的大小一样。
当元素被加入ArrayList的时候，他的容量会自动增长。

应用可以在增加大量元素之前使用``ensureCapacity``方法增加容量。
这可以减少重新分配空间的次数。

注意，该实现类并不是线程安全的。
如果多个线程同时访问ArrayList实例，并且至少有一个线程在结构上修改列表，则必须在外部进行同步。
（结构修改是添加或删除一个或多个元素，或显式调整后备数组大小的任何操作。仅设置元素的值不是结构上的修改。）
通常，通过在自然封装列表的某个对象上进行同步来完成此操作。

如果不存在这样的对象，则应使用``Collections.SynchronizedList``方法.
最好在创建时完成此操作，以防止意外的不同步访问列表.

迭代器和列表迭代器在本类中的是现实属于快速失败的。
如果在创建迭代器后的任何时间对列表进行结构修改，则可以通过迭代器自身的方式以任何方式进行修改。
因此，面对并发修改，迭代器会快速干净地失败，而不会在未来的不确定时间内不确定的行为的风险。

请注意，迭代器的快速失败行为无法得到保证，因为通常来说，在存在不同步的并发修改的情况下，不可能做出任何严格的保证。
快速失败的迭代器会尽最大努力抛出ConcurrentModificationException。
因此，编写依赖于此异常的程序以确保其正确性是错误的：迭代器的快速失败行为应仅用于检测错误。

本类是Java集合框架中的成员。

## 部分变量说明
### private static final Object[] EMPTY_ELEMENTDATA = {};
### private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

这两个变量之所以放在一起说是因为他们的在实际使用中是相关的。

两者都是空数组，而且都是静态常量，因此区分它们的关系可能作用不是很大，但是有助于理解某种思维。

#### 对于 new ArrayList(0) 和 new ArrayList();的区别
new ArrayList(0)使用的数组是 EMPTY_ELEMENTDATA;
new ArrayList() 使用的数组是 DEFAULTCAPACITY_EMPTY_ELEMENTDATA;

因此可以看出，不同的构造方法对于实例内部数据数组是有影响的。
#### 影响在哪里
首先看一下文档原文

    Shared empty array instance used for default 
    sized empty instances. We distinguish this 
    from EMPTY_ELEMENTDATA to know how much to 
    inflate when first element is added.
    
    共享空数组实例用于默认大小的空实例。
    我们与EMPTY_ELEMENTDATA相区分，来了解在添加第一个元素的时候
    应该扩张多少。

证明两者的区别发生在第一个数据添加的时候。
#### 那看一下add方法的调用

add方法有两个重载方法：add(E e), add(int index, E element)
而，都出现的重要方法是ensureCapacityInternal(size + 1);

该法方法中是保证数组容量足够的方法。而该方法调用了calculateCapacity方法。
在calculateCapacity方法：
```java
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}
```
可以看到，如果使用DEFAULTCAPACITY_EMPTY_ELEMENTDATA作为数组源，则返回传入数据大小
和DEFAULTY_CAPACITY较大的，否则直接返回minCapacity，在1.8中，DEFAULT_CAPACITY = 10

当第一数据被添加的时候，数据空间一定为size = 0，因此一定发生了数据增长（grow方法）

而返回值做为grow的参数被传入
```java
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;
    
    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
```

#### grow(int)方法
原来的数据长度为size + 1 = 0 + 1 = 1，新长度为
 
    1 + 1 >> 1 = 1 + 0 = 1
然后grow会进行一次比较，如果新长度小于传入参数，则使用参数，最后进行数组示例。

在整个过程中，我们发现，如果是ArrayList()构造方法，则第一次将会直接生成10个数据的空间
，而之后的数据扩充频率较低，但是空间占用较大。

如果使用ArrayList(0)方法进行构造，则空间占用较低，而数据扩充频率将升高。

以同样添加19个数据作为标准

* ArrayList()方法增长1次，最后空间量为10

* ArrayList(0)方法增长4次，最后空间量为10

#### 性能分析
两者差距仅出现在10个元素之前（在[Test文件中有测试代码](Test.java)），如果ArrayList的实例非常多，但是每个实例包含的元素不是特别多
则使用ArrayList(0)进行构造比较合适。

对于实例数量有限，而且元素个数也不是特别多，那就使用ArrayList()进行构造。

如果实例数量有限，元素个数还很多，请用ArrayList(int bigCount);进行构造