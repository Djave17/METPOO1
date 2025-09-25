package models;

public class Student extends Person
{
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public String introduce() {
        return super.introduce() + " Mi carrera es " + this.major;
    }
}
