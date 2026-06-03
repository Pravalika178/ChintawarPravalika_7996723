import java.sql.*;

public class Student
{
    private static final String URL =
            "jdbc:mysql://localhost:3306/college";

    private static final String USER = "root";

    private static final String PASSWORD = "Pravalika";

    public void insertStudent(int id,
                              String name,
                              int age)
    {
        String sql =
                "INSERT INTO students(id,name,age) VALUES(?,?,?)";

        try
        {
            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " row inserted");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void updateStudent(int id,
                              String newName)
    {
        String sql =
                "UPDATE students SET name=? WHERE id=?";

        try
        {
            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,newName);
            ps.setInt(2,id);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " row updated");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        Student d =
                new Student();

        d.insertStudent(
                4,
                "Neha",
                20);

        d.updateStudent(
                4,
                "Neha Sharma");
    }
}