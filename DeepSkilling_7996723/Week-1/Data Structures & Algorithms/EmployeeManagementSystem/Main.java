public class Main
{
    public static void main(String[] args)
    {
        EmployeeManager manager = new EmployeeManager(10);
        manager.addEmployee(new Employee(101,"Rahul","Developer",60000));
        manager.addEmployee(new Employee(102,"Priya","Tester",50000));
        manager.addEmployee(new Employee(103,"Amit","Manager",80000));
        System.out.println("\n=== All Employees ===");
        manager.displayEmployees();
        System.out.println("\n=== Search Employee ===");
        Employee employee = manager.searchEmployee(102);
        if (employee != null)
        {
            System.out.println(employee);
        }
        else
        {
            System.out.println("Employee not found.");
        }
        System.out.println("\n=== Delete Employee ===");
        manager.deleteEmployee(102);
        System.out.println("\n=== Employees After Deletion ===");
        manager.displayEmployees();
    }
}