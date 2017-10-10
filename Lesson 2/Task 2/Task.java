public class Task {
    private String name;
    private Boolean doStatus;
    private Employee employee;

    Task(){
        System.out.println("Create Task");
    }

    Task(String name, Employee employee){
        this.name = name;
        this.doStatus = false;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDoStatus() {
        return doStatus;
    }

    public void setDoStatus(Boolean doStatus) {
        this.doStatus = doStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String toString(){
        return name + " " + doStatus + " " + employee.toString();
    }
}
