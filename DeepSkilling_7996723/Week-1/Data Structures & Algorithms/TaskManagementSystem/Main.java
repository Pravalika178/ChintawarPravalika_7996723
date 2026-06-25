public class Main
{
    public static void main(String[] args)
    {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask( new Task(101, "Design Database","Pending"));
        taskList.addTask(new Task(102,"Develop API","In Progress"));
        taskList.addTask(new Task(103,"Testing","Pending"));
        System.out.println("=== All Tasks ===");
        taskList.displayTasks();
        System.out.println("\n=== Search Task ===");
        Task foundTask =taskList.searchTask(102);
        if (foundTask != null)
        {
            System.out.println(foundTask);
        }
        else
        {
            System.out.println("Task not found.");
        }
        System.out.println("\n=== Delete Task ===");
        taskList.deleteTask(102);
        System.out.println("\n=== Tasks After Deletion ===");
        taskList.displayTasks();
    }
}