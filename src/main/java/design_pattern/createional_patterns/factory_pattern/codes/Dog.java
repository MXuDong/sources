package design_pattern.createional_patterns.factory_pattern.codes;

/**
 * @author Dong
 */

public class Dog implements Animal {

    String dogName = null;

    @Override
    public void printName() {
        System.out.println("This is animal dog" + (dogName == null || "".equals(dogName)? "":"and the dog name is " + dogName));
    }

    @Override
    public void setName(String name) {
        dogName = name;
    }
}
