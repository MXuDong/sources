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

列表接口在一些超出集合接口中指定之外的地方上添加了一些约定，对迭代器（iterator）、add方法、remove方法、equals方法和hashCode方法。
为了方便起见，这里还包括了其他继承方法的声明。

List接口提供了四种方法来访问列表内的元素。
列表从0开始（和Java数组一样）。
请注意，对于某些实现，这些操作的执行时间可能与索引值成比例（例如LinkedList类）。
因此，如果使用者不清楚何种方式更加恰当，使用迭代器会好过使用索引的方法。

List接口提供了一种特殊的迭代器，叫做：ListIterator，它允许元素的插入和替换，同时还提供了双向访问以及正常迭代器具有的功能。
提供了一种方法来获取从列表中指定位置开始的列表迭代器（ListIterator）。

List接口提供了两种方法来查找一个指定对象。
从性能的角度来看，应该谨慎使用这些方法。
在许多实现中，它们将执行昂贵的线性搜索。

List接口提供了两种方法来有效地在列表中的任意点插入和移除多个元素。

Collection的一些实现类限制他包含的元素。
例如：一些实现类禁制``null``元素，还有一些实现类限制元素的数据类型。
如果尝试添加一个不支持的类型将会抛出UncheckedException，例如空指针异常（NullPointerException），类强制转换异常（ClassCaseException）。
如果尝试查询一个不合法的元素可能会抛出异常，或者仅仅是返回``false``.
通俗来说，对于尝试使用一个非法元素去操作集合，但是对结果没有任何影响时，有可能会抛出异常，也有可能顺利执行该方法。
此部分在接口的规范中标记为'可选'。

该接口是Java集合框架下的一个成员。