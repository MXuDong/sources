package design_pattern.createional_patterns.factory_pattern.codes;

/**
 * 动物接口
 *
 * 定义的时候也可以使用抽象类
 *
 * @author Dong
 */

public interface Animal {
    /**
     * print the name of animal
     */
    void printName();

    /**
     * set the animal name, but it is not the name of
     * type like dog,cat and etc.
     */
    void setName(String name);
}
