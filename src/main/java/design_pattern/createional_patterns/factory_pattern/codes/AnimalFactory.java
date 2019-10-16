package design_pattern.createional_patterns.factory_pattern.codes;

/**
 * @author Dong
 * @since
 */

public class AnimalFactory {

    public static Animal getAnimal(String name, String type){
        Animal animal = null;
        if(type.equals("dog")){
            animal = new Dog();
        }else{
            animal = new Cat();
        }
        animal.setName(name);
        return animal;
    }
}
