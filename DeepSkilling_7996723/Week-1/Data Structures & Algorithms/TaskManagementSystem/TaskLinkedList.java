public class TaskLinkedList
{
    private TaskNode head;
    public void addTask(Task task)
    {
        TaskNode newNode = new TaskNode(task);
        if (head == null)
        {
            head = newNode;
            return;
        }
        TaskNode current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
    }
    public Task searchTask(int taskId)
    {
        TaskNode current = head;
        while (current != null)
        {
            if (current.task.getTaskId() == taskId)
            {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }
    public void displayTasks()
    {
        TaskNode current = head;
        while (current != null)
        {
            System.out.println(current.task);
            current = current.next;
        }
    }
    public void deleteTask(int taskId)
    {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        if (head.task.getTaskId() == taskId)
        {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }
        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId)
        { 
            current = current.next;
        }
        if (current.next == null)
        {
            System.out.println("Task not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Task deleted successfully.");
    }
}