package models;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String introduce() {
        return "Hola mi nombre es " + this.name + " y tengo " + this.age + " años.";
    }

}
