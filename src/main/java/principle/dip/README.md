# 依赖倒置原则 - Dependence Inversion Principle - DIP
    High level modules should not depend on low level modules; both should depend on abstractions. 
    Abstractions should not depend on details. Details should depend upon abstractions.
    
    高级模块不应该依赖于低级模块，他们都应该依赖于抽象。
    抽象不应该依赖于细节，而细节应该取决于抽象。
    
本质上就是指，在软件开发的过程中，需要依赖接口而不是实现。重点关注的是对抽象的变成而不是具体的实现。

在软件开发中，如果出现模块之间的相互调用，例如模块A调用模块B，因此我们说A模块依赖于B模块。
如果是面向实现变成，我们会发现，当B模块发生变动后，会导致A模块的变动，如果还有其他模块依赖A模块，则牵一发而动全身，成本非常高。
但是如果利用好抽象，本质上，抽象是很难发生变动的，但是如果需求变动，则具体实现发生变动，而抽象不动，则A模块就不会跟着变动。

# 作用
在某种程度上讲，依赖倒置大大的降低了模块之间的耦合程度。 

    