public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        HrDepartment hrDepartment = new HrDepartment();

       Employee employee = new Employee("collector1", "sadsas", 100.0, hrDepartment, task);

        employee.setName("Sasha");
        employee.setSurname("Romanovskij");

        Employee employee1 = new Employee("chef", "12ed3", 300.53, hrDepartment, task);

        employee1.setName("Rooney");
        employee1.setSurname("Wonder");

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);
        employees.add(employee1);

        hrDepartment.setEmployees(employees);

        task.setName("Create me");
        task.setDoStatus(true);
        task.setEmployee(employee);

        System.out.println("First employee (person):");
        System.out.println(employee.toString());
        System.out.println("HrDepartment:");
        System.out.println(hrDepartment.toString());
        System.out.println("Task:");
        System.out.println(task);

    }
}
