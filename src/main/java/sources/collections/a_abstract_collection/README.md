# AbstractCollection
type : abstract class

public abstract class AbstractCollection<E> implements Collection<E>

# 类文档

本类实现了Collection接口的基本框架，减少实现collection接口的代价。

实现不可变集合，仅需要继承本类并实现``iterator``和``size``方法
（``iterator``方法返回的迭代器必须实现hasNext和next）。

实现可变集合，需要重写这个类的``add``方法（否则将会抛出``UnsupportedOperationException``），
并且``iterator``返回的地带其必须另外实现``remove``方法。

根据Collection接口文档中的建议，实现类通常提供一个空值（无参）和Collection类型的构造方法。

此类中每个非抽象方法的文档详细描述了其实现。如果正在实现的集合允许更有效的实现，则这些方法中的每一个都可能被重写。

# 部分方法解析
## 1. public Object[] toArray();
方法代码与解析
```java
public Object[] toArray() {
    // Estimate size of array; be prepared to see more or fewer elements
    // 估计数组大小，可能比元素多或少

    Object[] r = new Object[size()];
        //生成一个数组，该数组为返回数组，类型为Object
    Iterator<E> it = iterator();
        //获取迭代器
    for (int i = 0; i < r.length; i++) {
        //循环添加数据
        if (! it.hasNext()) // fewer elements than expected
            //已经没有元素，但是数组r还有空间，因此要缩减空间
            //调用 Arrays.copyOf(r, i)进行空间缩减
            return Arrays.copyOf(r, i);
                //返回数据
        r[i] = it.next();
            //正常填充数据
    }
    return it.hasNext() ? finishToArray(r, it) : r;
    //如果元素个数与预估大小一致，则填充数据后直接返回
    //如果元素个数大于预估大小，则调用finishToArray将为填充数据补充进来
} 
```
本方法依赖迭代器

## 2. public <T> T[] toArray(T[] a);
方法代码与解析
```java
public <T> T[] toArray(T[] a) {
    // Estimate size of array; be prepared to see more or fewer elements
    // 估计数组大小，可能比元素多或少
    int size = size();
        //获取当前集合的元素个数，并作为预估元素
    T[] r = a.length >= size ? a :
              (T[])java.lang.reflect.Array
              .newInstance(a.getClass().getComponentType(), size);
        //如果传入的数组大小不足，将会重新创建新的数组实例
        //如果传入空数组（nullPointer)，将会导致空指针异常（a.length）
    Iterator<E> it = iterator();
        //获取迭代器
    for (int i = 0; i < r.length; i++) {
        //循环填充数据
        if (! it.hasNext()) { // fewer elements than expected
            //元素数量不足
            if (a == r) {
                //没有创建新实例，而是使用传入数组a做数据的填充
                //则不能更改传入数组的长度
                r[i] = null; // null-terminate
                //只能将多余的位置设置为null，作为结束标志
            } else if (a.length < i) {
                //预估虽然错误，但是传入的数组还是不足以接收数据
                return Arrays.copyOf(r, i);
                //返回缩减后的r数组
            } else {
                //预估错误，且传入的数组足以接受全部数据，则将r内数据复制到a中
                System.arraycopy(r, 0, a, 0, i);
                if (a.length > i) {
                    a[i] = null;
                    //将数据置空
                }
            }
            return a;
                //返回处理过的数据
        }
        r[i] = (T)it.next();
            //正常填充数据
    }
    // more elements than expected
    return it.hasNext() ? finishToArray(r, it) : r;
        //若r数组不足，则调用finishToArray(r, it)方法将未添加的元素加进来
}
```

# private static <T> T[] finishToArray(T[] r, Iterator<?> it);
方法代码与解析
```java
private static <T> T[] finishToArray(T[] r, Iterator<?> it) {
    int i = r.length;
        //获取i的实际长度
    while (it.hasNext()) {
        //循环
        int cap = r.length;
            //指标等于r的长度
        if (i == cap) {
            //当指标等于r 的长度时（第一次循环会直接出发）
            int newCap = cap + (cap >> 1) + 1;
                //扩大容量未原来的 x + x / 2 + 1 = 1.5x+1
            // overflow-conscious code
            if (newCap - MAX_ARRAY_SIZE > 0)
                //如果容量大于最大数组长度，调用hugeCapacity，获取大容量值
                newCap = hugeCapacity(cap + 1);
                    //当前状态下，获取的值为Integer.MAX_VALUE
                    //默认的MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
            r = Arrays.copyOf(r, newCap);
                //复制一下，支持扩容擦欧总
        }
        r[i++] = (T)it.next();
            //填充数据
    }
    // trim if overallocated
    return (i == r.length) ? r : Arrays.copyOf(r, i);
        //返回实际长度大小的数组
}
```