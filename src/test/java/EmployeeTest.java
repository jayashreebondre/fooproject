import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

 public class EmployeeTest {

     Employee employee;

     public EmployeeTest()
     {
        employee = new Employee();
     }

    @Test
    void testsetFirstName() {
       String Firstname = "Jayashree"; // Test code
       String expected = "Jayashree"; // Test code
       employee.setFirstName(Firstname);
       String actual = employee.getFirstName(); //cut
       Assertions.assertEquals(expected,actual); // Assertion
    }


    @Test
    void testGetFirstName() {
       Employee testobj=new Employee();
       String Firstname = "Shubhangi"; // Test code
       String expected = "Shubhangi"; // Test code
       testobj.setFirstName(Firstname);
       String actual = testobj.getFirstName(); //cut
       Assertions.assertEquals(expected,actual); // Assertion
    }

    @Test
    void getLastname() {
       Employee testobj =new Employee();
       String Lastname = "Patil"; // Test code
       String expected = "Patil"; // Test code
       testobj.setLastname(Lastname);
       String actual = testobj.getLastname(); //cut
       Assertions.assertEquals(expected,actual); // Assertion

    }

    @Test
    void testsetLastname() {
       Employee testobj=new Employee();
       String LastName = "Bondre"; // Test code
       String expected = "Bondre"; // Test code
       testobj.setLastname(LastName);
       String actual = testobj.getLastname(); //cut
       Assertions.assertEquals(expected,actual); // Assertion

    }

    @Test
    void testgetAge() {
       Employee testobj =new Employee();
       int Age = 35; // Test code
       int expected = 35; // Test code
       testobj.setAge(Age);
       int actual = testobj.getAge(); //cut
       Assertions.assertEquals(expected,actual); // Assertion

    }

    @Test
    void testsetAge() {
       Employee testobj =new Employee();
       int Age = 40; // Test code
       int expected = 40; // Test code
       testobj.setAge(Age);
       int actual = testobj.getAge(); //cut
       Assertions.assertEquals(expected,actual); // Assertion

    }

    @Test
    void testgetCompanyID() {
       Employee testobj =new Employee();

       int expected = 1101; // Test code

       int actual = testobj.getCompanyID(); //cut
       Assertions.assertEquals(expected,actual); // Assertion


    }

    @Test
    void testgetSalary() {
       Employee testobj =new Employee();
       float Salary = 45000; // Test code
       float expected = 45000; // Test code
       testobj.setSalary(Salary);
       float actual = testobj.getSalary(); //cut
       Assertions.assertEquals(expected,actual); // Assertion
    }

    @Test
    void testsetSalary() {
          Employee testobj =new Employee();
          float Salary = 55000; // Test code
          float expected = 55000; // Test code
          testobj.setSalary(Salary);
          float actual = testobj.getSalary(); //cut
          Assertions.assertEquals(expected,actual); // Assertion
    }

    @Test
    void testaddEmployee() {
        Employee e1 = new Employee("Jayashree","Bondre",35,125000);
        Employee e2 = new Employee("Santosh","Bondre",38,150000);
        employee.AddEmployee(e1);
        employee.AddEmployee(e2);
        Employee expected = e1;
        Object actual = employee.getEmployeeList().get(0);
        assertEquals(expected, actual);
    }

    @Test
    void getEmployeeList() {
       employee.getEmployeeList();
    }

    @Test
    void testgetAllEmployee() {
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));

       ArrayList<Employee> list = employee.GetAllEmployee();
       int expected = list.size();
       int actual = employee.getEmployeeList().size();
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testgetEmployeeByName() {

       Employee expected = new Employee("Jayashree","Bondre",35,125000);
       expected.AddEmployee(expected);
       Employee actual = expected.GetEmployeeByName("Jayashree");
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testRemoveEmployeeByName() {

       Employee empRemove = new Employee();
       Employee e1 = new Employee("Jayashree","Bondre",35,125000);
       Employee e2 = new Employee("Santosh","Bondre",38,150000);
       Employee e3 = new Employee("Shourya","Bondre",15,130000);

       empRemove.AddEmployee(e1);
       empRemove.AddEmployee(e2);
       empRemove.AddEmployee(e3);
       empRemove.RemoveEmployeeByName("Jayashree Bondre");

       Object actual = empRemove.getEmployeeList().size();
       assertEquals(2, actual);
    }

    @Test
    void testsalaryIncreaseForAll() {
       String expected = "Salary increase successful";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       employee.AddEmployee(new Employee("Jayashree","Bondre",35,125000));
       String actual = employee.SalaryIncreaseForAllEmployee(15);
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testsalaryIncreaseAboveLimitForAll() {
       String expected = "Accepted salary increase may not exceed 100%";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       employee.AddEmployee(new Employee("Jayashree","Bondre",35,125000));
       String actual = employee.SalaryIncreaseForAllEmployee(105);
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testsalaryIncreaseBelowLimitForAll() {
       String expected = "Salary increment cannot lower current salary";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       employee.AddEmployee(new Employee("Jayashree","Bondre",35,125000));
       String actual = employee.SalaryIncreaseForAllEmployee(-5);
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testSalaryIncreaseForEmployee() {
       String expected = "Salary increase successful";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       employee.AddEmployee(new Employee("Jayashree","Bondre",35,125000));
       String actual = employee.SalaryIncreaseForEmployee("Jayashree",10);
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testsalaryIncreaseAboveLimitForEmployee() {
       String expected = "Accepted salary increase may not exceed 100%";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       employee.AddEmployee(new Employee("Jayashree","Bondre",35,125000));
       String actual = employee.SalaryIncreaseForEmployee("Jayashree",105);
       Assertions.assertEquals(expected,actual);
    }

    @Test
    void testsalaryIncreaseBelowLimitForEmployee() {
       String expected = "Salary increment cannot lower current salary";
       employee.AddEmployee(new Employee("Pooja","Yadav",30,125000));
       employee.AddEmployee(new Employee("Komal","Yadav",25,150000));
       String actual = employee.SalaryIncreaseForEmployee("Jayashree",-5);
       Assertions.assertEquals(expected,actual);
    }


 }