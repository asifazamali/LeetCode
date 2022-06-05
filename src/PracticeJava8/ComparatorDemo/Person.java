package PracticeJava8.ComparatorDemo;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private int age;
    private int children;
    private double salary;

    public Person(int id, String name, int age, int children, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.children = children;
        this.salary = salary;
    }

    public Person(int id, String name, int age, int children) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.children = children;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public int compareTo(Person p){
       return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && children == person.children
                && Double.compare(person.salary, salary) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, children, salary);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                ", salary=" + salary +
                '}';
    }
}
