public class MVCTest
{
    public static void main(String[] args)
    {
        Student student = new Student("Pravalika", 101, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Initial Details:");
        controller.updateView();

        controller.setStudentName("Chintawar Pravalika");
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Details:");
        controller.updateView();
    }
}