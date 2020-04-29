package kata.tdd.employee.utils;

import kata.tdd.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Repository {
public  static List<Employee> getEmployees(){
    List<Employee> employees =  new ArrayList<>();
    employees.add(new Employee("Max",17));
    employees.add(new Employee("Sepp",18));
    employees.add(new Employee("Nina",15));
    employees.add(new Employee("Mike",51));
    return  employees;
}
}
