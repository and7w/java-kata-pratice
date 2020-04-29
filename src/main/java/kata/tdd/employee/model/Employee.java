package kata.tdd.employee.model;

public class Employee {
    private String name;
    private int age;

    public Employee(String max, int i) {
        this.name=max;
        this.age=i;
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
}
