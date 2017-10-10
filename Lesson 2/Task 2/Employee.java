public class Employee extends Person implements IEmployee {
    private String position;
    private String id;
    private Double salary;
    private HrDepartment hrDepartment;
    private Task task;

    Employee(){
        System.out.println("Create Employee");
    }

    Employee(String position, String id, Double salary, HrDepartment hrDepartment, Task task){
        this.position = position;
        this.id = id;
        this.salary = salary;
        this.hrDepartment = hrDepartment;
        this.task = task;
        System.out.println("Create Employee");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String toString(){

        return getName()+ " " + getSurname()+ " " + position + " " + id + " " + salary;
    }

    @Override
    public boolean doTask(Task task) {
        return task.getDoStatus();
    }
}

