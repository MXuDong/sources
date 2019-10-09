# Collection
type: interface

public interface Collection<E> extends Iterable<E>

# 类文档

该接口是集合大类中的根接口。
一个集合代表着一组对象，该对象被称为元素。
一些集合允许重复的元素，而另一些集合不允许。
一些集合是有序的，另一些是无序的。
JDK不提供任何该接口的直接实现：提供了更具体的子类的实现，如：Set、List.
该接口提供了最大程度的通用性用于操作和抽象的表示集合。
（原文中为：This interface is typically used to pass collections around and manipulate them where maximum generality is desired. 
 机器翻译为：该接口通常用于传递集合并操作它们，其中需要最大的通用性。
 但是我认为 pass collections around 翻译成传递不好，我翻译为抽象或者表示）

背包（bags：一种数据结构 类似栈）和多集（multisets：一种数据结构 无序且允许元素重复）应该直实现承该接口。

所有通用的Collection实现类（通常是实现Collection的子接口）应该提供梁总标准的构造方法：
一个是空参的构造方法：该方法创建一个空集合，
另一个是具有一个Collection类型参数的构造方法，使用具有参数的元素进行创建。
实际上，第二种构造方法允许用户复制任意集合来生成目标类型的等效集合。
当然，没有任何方法保证强制执行这个约定（Collection是一个接口，接口中不能包含构造函数）
但是Java平台内所有的通用Collection的实现类都是符合上述约定的。

在这个接口中有一些“破坏性”的方法，
当调用某种集合不支持的操作进行修改集合的时候会抛出（UnsupportedOperationException java.lang包下）
如果操作被调用后对集合本身没有影响，这种情况下可以但不是必须要抛出该异常。
例如：对不可修改的集合调用addAll(Collection)方法添加空集可以引发该异常，但不是必须的。
（注意这里是添加空集合，表示不添加任何数据，所以没有影响，如果是添加有数据的集合，那就要抛出异常）

Collection的一些实现类限制他包含的元素。
例如：一些实现类禁制``null``元素，还有一些实现类限制元素的数据类型。
如果尝试添加一个不支持的类型将会抛出UncheckedException，例如空指针异常（NullPointerException），类强制转换异常（ClassCaseException）。
如果尝试查询一个不合法的元素可能会抛出异常，或者仅仅是返回``false``.
通俗来说，对于尝试使用一个非法元素去操作集合，但是对结果没有任何影响时，有可能会抛出异常，也有可能顺利执行该方法。
此部分在接口的规范中标记为'可选'。

由每种集合自行决定他们自己的同步策略。
在没有有力的保障下的实现类，未知的行为来自该集合的一些方法被其他线程调用导致的数据改变。
包括直接调用、将集合传递给可能执行调用的方法、使用现有迭代器检索集合。

在集合框架接口下的一些方法都是根据``equals``方法定义的。但是这并不代表制真的就是使用这个方法。
子类自由决定使用更加优化的方法，进而笔迷使用equals。
参考[contains(Object o);方法](#Method3)
更一般地说，各种集合框架接口的实现可以自由地利用底层对象方法的指定行为，只要实现者认为合适。

对于自引用的集合，使用递归思想进行操作会失败并且抛出异常。
这包括clone（）、equals（）、hashcode（）和tostring（）方法。
实现可以选择性地处理自引用场景，但是大多数当前实现类不这样做。

该接口是Java集合框架的一员。

#### 对实现类的限制：
对于默认方法（接口中使用default关键字标识的方法）不具有任何同步处理，子类如果需要进行同步处理，应该覆盖相应方法。