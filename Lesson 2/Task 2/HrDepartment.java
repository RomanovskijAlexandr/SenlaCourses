public class HrDepartment {
    private ArrayList<Employee> employees;

    HrDepartment(){
        this.employees = new ArrayList<Employee>();
        System.out.println("Create HrDepartment");
    }

    HrDepartment(ArrayList<Employee> employees){
        this.employees = employees;
        System.out.println("Create HrDepartment");
    }
    public void setEmployees(ArrayList<Employee> employees){
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public void addEmployee(Employee newEmployee){
        employees.add(newEmployee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public String toString(){
        for (Employee employee:employees) {
            System.out.println(employee.toString());
        }
        return "";
    }
}
