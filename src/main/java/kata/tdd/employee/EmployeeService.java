package kata.tdd.employee;

import kata.tdd.employee.model.Employee;
import kata.tdd.employee.utils.Repository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    public static  final int MAJOR_AGE =18;
    public List<Employee> getMajorEmployees(){
        List<Employee> employees= new ArrayList<>();
        Repository.getEmployees().forEach(employee -> {
           if (employee.getAge()>= MAJOR_AGE)
               employees.add(employee);
        });
        return employees;
    }

}
