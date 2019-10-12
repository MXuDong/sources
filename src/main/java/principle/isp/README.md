# 接口隔离原则 - Interface Segregation Principle - ISP
 
    no client should be forced to depend on methods it does not use.
    
    不应该强迫任何客户端依赖它不使用的方法
    
说白了就是接口尽量小，尽量让实现类不要有那么多用不到的方法去实现。

如果用IDEA就会发现，他会告诉你有很多方法没有用到，这个时候就要考虑接口隔离了，当然，有些方法是为了外部准备的，因此不用考虑。

与单一原则不同，单一原则重点在类，本原则重点在接口！