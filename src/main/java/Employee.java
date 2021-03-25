import java.util.ArrayList;

public class Employee {
    private String Firstname;
    private String Lastname;
    private int Age;
    private float Salary;
    private  ArrayList<Employee> EmployeeList;
    final private int CompanyId = 1101;

    public Employee()
    {
        EmployeeList = new ArrayList<Employee>();
    }
    public Employee(String firstname, String lastname,int age, float salary)
    {
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
        Salary = salary;

        if(EmployeeList == null)
            EmployeeList = new ArrayList<Employee>();
    }


    public String getFirstName() {
        return Firstname;
    }

    public void setFirstName(String firstName) {
        this.Firstname = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public int getCompanyID() {
           return CompanyId;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        this.Salary = salary;
    }

    public ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }

    public void AddEmployee(Employee emp){
        EmployeeList.add(emp);
    }

    public ArrayList<Employee> GetAllEmployee() {
        return EmployeeList;
    }

    public Employee GetEmployeeByName(String firstname) {
        Employee emp = new Employee();
        for (int i = 0; i < EmployeeList.size(); i++) {
            if (EmployeeList.get(i).Firstname == firstname) {
                emp = EmployeeList.get(i);
            }
        }
        return emp;
    }

    public void RemoveEmployeeByName(String name) {
        String empName;

        for (int i = 0; i < EmployeeList.size(); i++)
        {
            empName = EmployeeList.get(i).Firstname+" "+EmployeeList.get(i).Lastname;
            if (empName.equalsIgnoreCase(name))
            {
                EmployeeList.remove(EmployeeList.get(i));
            }
        }
    }

    public String SalaryIncreaseForAllEmployee(float percentage)
    {
        String salaryMessage;
        if(percentage <= 0)
            salaryMessage = "Salary increment cannot lower current salary";
        else if(percentage >=100)
            salaryMessage = "Accepted salary increase may not exceed 100%";
        else
        {
            for (int i = 0; i < EmployeeList.size(); i++) {
                float currentSalary = EmployeeList.get(i).Salary;
                float newSalary = currentSalary + (currentSalary * percentage / 100);
                EmployeeList.get(i).Salary = newSalary;
            }
            salaryMessage = "Salary increase successful";
        }
        return salaryMessage;
    }

    public String SalaryIncreaseForEmployee(String firstname, float percentage)
    {
        String salaryMessage = null;
        if(percentage <= 0)
            salaryMessage = "Salary increment cannot lower current salary";
        else if(percentage >=100)
            salaryMessage = "Accepted salary increase may not exceed 100%";
        else
        {
            for (int i = 0; i < EmployeeList.size(); i++) {
                if (EmployeeList.get(i).Firstname == firstname) {
                    float currentSalary = EmployeeList.get(i).Salary;
                    float newSalary = currentSalary + (currentSalary * percentage / 100);
                    EmployeeList.get(i).Salary = newSalary;
                }
            }
            salaryMessage = "Salary increase successful";
        }
        return salaryMessage;
    }
}



