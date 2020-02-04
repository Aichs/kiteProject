import org.aichs.kite.entity.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo {


    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.99),
            new Employee("赵六",16,3333.33),
            new Employee("田七",8,7777.77)
    );


    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if(emp.getAge() >= 35){
                emps.add(emp);
            }
        }
        return emps;
    }

//    public List<Employee> filterEmployee(){
//
//    }

    @Test
    public void test1() {
       List<Employee> list = filterEmployees(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    // 按照当前公司中工资大于5000的员工信息
    @Test
    public void test2(){

    }
}
