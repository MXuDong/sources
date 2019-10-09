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

