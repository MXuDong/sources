# AbstractList
type : abstract class

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>

# 类文档

该类实现了List接口的基本框架，并减少实现List的代价，支持随机访问数据存储（类似数组）。
对于顺序访问数据（例如链表），应优先使用AbstractSequentialList而不是此类。

如果实现不可修改的List，程序开发人员仅需要继承本类并提供get(int)、size()方法的实现。

如果实现可变List，程序开发人员需要另外重写set(int, Object)、set(int, E)方法（否则将会抛出``UnsupportedOperationException``）。
如果列表是可变大小的，则程序员必须另外重写add（int，Object）、add（int，E）和remove（int）方法。

根据Collection接口文档中的建议，实现类通常提供一个空值（无参）和Collection类型的构造方法。

与其他抽象集合的实现类不同，并不是一定要实现迭代器，迭代器和列表迭代器在本类中已经实现。

此类中每个非抽象方法的文档都详细描述了其实现。如果正在实现的集合允许更有效的实现，则可以覆盖这些方法中的每一个。

该类是集合框架中的成员

# 内部类

## private class Itr implements Iterator<E>
迭代器
