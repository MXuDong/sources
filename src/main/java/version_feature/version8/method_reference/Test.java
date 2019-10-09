package version_feature.version8.method_reference;

/**
 * @author Dong
 */

public class Test {

    public static void main(String[] args) {
        //引用方法 Test.print()方法
        //如果目标方法（这里是StringAble.printString()方法）存在返回值
        //则被引用方法将自动被返回
        //所以下面接口的返回值定义为String也是可以的
        printSomething("something", Test::print);
    }

    public static void printSomething(String something, StringAble stringAble){
        stringAble.printString(something);
    }

    public static void  print(String o){
        System.out.println("print:" + o);
    }
}

interface StringAble{
    void printString(String o);
}