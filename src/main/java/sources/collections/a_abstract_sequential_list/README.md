# AbstractSequentialList
type : abstract class

public abstract class AbstractSequentialList<E> extends AbstractList<E>

# 类文档

该类提供了List接口的骨架为了最小的实现List接口的成本。
由顺序访问支持。（链表）
对于随机访问数据（数组），应该优先于此类使用AbstractList。

在实现随机访问方法的意义上，该类和AbstractList相反。

要实现列表，程序员仅需要扩展此类并为listIterator和size方法提供实现。
对于不可修改的列表，程序员只需要实现列表迭代器的hasNext，next，hasPrevious，previous和index方法。

对于可修改的列表，程序员应该另外实现列表迭代器的set方法。对于可变大小的列表，程序员应该另外实现列表迭代器的remove和add方法。

程序员通常应按照Collection接口规范中的建议提供一个void（无参数）和collection构造函数。

本类是Java集合框架中的成员