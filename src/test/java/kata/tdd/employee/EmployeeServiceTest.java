package kata.tdd.employee;

import kata.tdd.employee.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;


public class EmployeeServiceTest {
   private EmployeeService employeeService;
    @BeforeEach
    void  setup(){
        employeeService= new EmployeeService();
    }

    @Test
    public  void shouldReturnAlistWhitTwoEmployees(){
        List<Employee> actuals= employeeService.getMajorEmployees();
        Assertions.assertThat(actuals.size()).isEqualTo(2);
        Assertions.assertThat(actuals.get(0)).isEqualToComparingFieldByField(new Employee("Sepp",18));
        Assertions.assertThat(actuals.get(1)).isEqualToComparingFieldByField(new Employee("Mike",51));
    }

    @Test
    public  void shouldReturnASortedList(){
        List<Employee> actuals= employeeService.getMajorEmployees();
        Assertions.assertThat(actuals.size()).isEqualTo(2);
        Assertions.assertThat(actuals.get(0)).isEqualToComparingFieldByField(new Employee("Mike",51));
        Assertions.assertThat(actuals.get(2)).isEqualToComparingFieldByField(new Employee("Sepp",18));
    }

}
