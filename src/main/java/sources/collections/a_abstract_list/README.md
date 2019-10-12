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

迭代器内部如果需要实现快速失败（获取迭代器后，修改列表状态，会导致迭代器异常）。
则需要在列表内部操作modCount。
如果不需要，忽略即可，迭代器内部使用expectedCount保证迭代器正常。

通过字段：lastRet保证一次只能remove一次。
每次next（）方法会将lastRes置为cursor，然后cursor变动。
发生remove操作后，lastRet置为-1，下次再次调用就会发生异常，以保证每次进删除最近的数据，而不会错删、多删。

## private class ListItr extends Itr implements ListIterator<E>
列表迭代器-双向迭代器

在add方法中，存在添加数据后，lastRet被置为-1，因此此时删除是不可以的，即利用列表迭代器添加后立即删除的诡异操作是不可行的。

# 同包类
## class SubList<E> extends AbstractList<E>;
非RandomAccess子列表，这种列表直接继承了AbstractList，本质上其实是包装了一个AbstractList。
迭代器直接使用列表迭代器，列表迭代器又包装了传入的AbstractList的迭代器。

操作此类时，会检测modCount，也就是说，操作此类后，尽量不要操作源列表。

## class RandomAccessSubList<E> extends SubList<E> implements RandomAccess;
直接包装SubList