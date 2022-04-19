package PracticeJava8.ComparatorDemo;

public class Person {
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
