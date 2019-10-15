package design_pattern.createional_patterns.factory_pattern.codes;

/**
 * @author Dong
 * @since
 */

public class Cat implements Animal {
    String catName = null;

    @Override
    public void printName() {
        System.out.println("This is animal cat" + (catName == null || "".equals(catName) ? "" : "and the cat name is " + catName));
    }

    @Override
    public void setName(String name) {
        catName = name;
    }
}
