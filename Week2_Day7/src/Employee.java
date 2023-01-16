public class Employee {
    private String emp_ID;
    private String emp_name;
     double Salary;


    public Employee(){
    }

    public Employee(String emp_ID, String emp_name, int Salary){
        this.emp_ID = emp_ID;
        this.emp_name = emp_name;
        this.Salary = Salary;

    }

    public String getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }


    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    public double getSalary() {
        return Salary;
    }
    public double getAnnoualSalary(){
        this.Salary = 4500;
        double AnnoualSalary = Salary * 12;
        return AnnoualSalary ;
    }
    public double raisedSalary(double percent){
        int Salary = 4500;
        double sal = Salary * percent;
        double raised_Salary = sal + Salary;
        return raised_Salary;
    }


    @Override
    public String toString() {
        return "Employee Information(" +
                "emp_ID='" + emp_ID + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", Salary=" + Salary +
                ')';
    }
}
