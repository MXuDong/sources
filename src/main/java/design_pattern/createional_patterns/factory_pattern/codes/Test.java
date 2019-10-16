package design_pattern.createional_patterns.factory_pattern.codes;

/**
 * 测试类
 *
 * @author Dong
 */

public class Test {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("come-money", "dog");
        dog.printName();
        Animal cat = AnimalFactory.getAnimal("more lucky", "cat");
        cat.printName();
    }
}
