# List
type : interface

public interface List<E> extends Collection<E>

# 类文档

一个有序集合（也被称为队列（sequence））。
使用该接口可以精确的空值队列中的每个元素插入的位置。
用户可以通过整数索引（List中的位置）获取和查找元素。

与Set不同，List允许重复的数据。
通常来说，List允许一对数据E1,E2满足E1.equals(E2)，并且如果List的子类允许null值，也可以存在多个null值。
有些时候，一些List的实现类会通过抛出运行时异常来阻止出现重复数据，但是预期这样的情况不会太多。
