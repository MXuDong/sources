package version_feature.version8.lambdas;

/**
 * 主类
 *
 * @author Dong
 */
public class TestLambda {

    public static void main(String[] args) {
        say1(x -> "say" + x, "仅有一个参数，且方法体仅有一行返回值， 所以Lambda：(x)->{return x + \"say\";} 简化为 x -> \"say\" + x");
        say1(x->{x = "say" + x; return x;}, "仅有一个参数，但是方法体为两行，因此参数括号省略，但是方法体不能省略 ： x->{x = \"say\" + x; return x;}");
        say2((x, y)-> x + y, "test：", "有两个参数，方法体仅有一行返回值，所以Lambda表达式简化为 (x, y)-> x + y");
        say3(()->"test 没有参数，括号不能省略，仅有一行返回值，省略return和花括号以及分号 ： ()->\"value\"");

        //运行结果行在lambdas的README.md的最下面
    }

    public static void say1(SayAble_1_param sayAble_1_param, String value) {
        System.out.println(sayAble_1_param.say(value));
    }

    public static void say2(SayAble_2_param sayAble_2_param, String name, String value) {
        System.out.println(sayAble_2_param.say(name, value));
    }

    public static void say3(SayAble_0_param sayAble_0_param) {
        System.out.println(sayAble_0_param.say());
    }
}

/**
 * 仅有一个参数
 */
interface SayAble_1_param {
    String say(String something);
}

/**
 * 有两个参数
 */
interface SayAble_2_param {
    String say(String name, String something);
}

/**
 * 没有参数
 */
interface SayAble_0_param {
    String say();
}