package run;
import models.*;


public class Main {

    public static void main(String[] args) {

        Person person = new Person("Alice", 30);
        System.out.println(person.introduce());

        Student student = new Student("Bob", 20, "Computer Science");
        System.out.println(student.introduce());
    }
}
