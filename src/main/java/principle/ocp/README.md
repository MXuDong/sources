# 开闭原则 - Open Closed Principle - OCP

## 原则描述
    Software entities like classes,modules and functions should be open for extension but closed for modifications.
    一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。

当发生变动的时候，软件实体应该通过扩展来应对变动，而不是改变已有结构。

## 场景
当系统发生新的变更，在不改变原有代码基础上，扩展新的实现方式就可以完成变更应对。

这里需要指明一点，系统变更指复杂度上升，对于复杂度降低的形况，是没有办法进行扩展的，此时需要对源码进行修改。

## 使用
优秀的抽象和完整的架构可以在很大程度上应对变更，降低代码的复杂度、提高复用率。

底层的抽象尽量完整、合理，一旦确定就不应再发生变动。如果发生变动，不应涉及到另一层的使用。这种情况多发生在耦合度高的情况。