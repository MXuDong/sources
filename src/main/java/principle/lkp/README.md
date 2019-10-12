# 迪米特法则 - Least Knowledge Principle - LKP
    
    Each unit should have only limited knowledge about other units: only units "closely" related to the current unit.
    Each unit should only talk to its friends; don't talk to strangers.
    Only talk to your immediate friends.
    
    每个单元对其他单元的知识应该有限：只有与当前单元“紧密”相关的单元。
    每个单位只能与朋友交谈；不要和陌生人说话。
    只与您的直系朋友交谈。
    
这个原则本质上是为了降低耦合度，原则指出，他不能够和其它类直接依赖，而是通过中介类。
但是在系统开发复杂度上升后，会出现大量的中介类，反而会增加复杂度，所以慎用。

而本法则常用在模块之间的降耦，对于模块之间的依赖可以使用。

如果两个类不必彼此直接通信，那么这两个类就不应当发生直接的相互作用。如果其中的一个类需要调用另一个类的某一个方法的话，可以通过第三者转发这个调用。

朋友圈的确定

“朋友”条件：
1. 当前对象本身（this）
2. 以参量形式传入到当前对象方法中的对象
3. 当前对象的实例变量直接引用的对象
4. 当前对象的实例变量如果是一个聚集，那么聚集中的元素也都是朋友
5. 当前对象所创建的对象

任何一个对象，如果满足上面的条件之一，就是当前对象的“朋友”；否则就是“陌生人”。