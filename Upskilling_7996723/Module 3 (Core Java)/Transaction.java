import java.sql.*;

public class Transaction
{
    public static void main(String[] args)
    {
        Connection con = null;

        try
        {
            con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Pravalika");

            con.setAutoCommit(false);

            PreparedStatement debit =
                con.prepareStatement(
                    "UPDATE accounts " +
                    "SET balance=balance-? " +
                    "WHERE id=?");

            debit.setDouble(1,1000);
            debit.setInt(2,1);

            debit.executeUpdate();

            PreparedStatement credit =
                con.prepareStatement(
                    "UPDATE accounts " +
                    "SET balance=balance+? " +
                    "WHERE id=?");

            credit.setDouble(1,1000);
            credit.setInt(2,2);

            credit.executeUpdate();

            con.commit();

            System.out.println(
                "Transaction Committed");
        }
        catch(Exception e)
        {
            try
            {
                if(con != null)
                {
                    con.rollback();

                    System.out.println(
                        "Transaction Rolled Back");
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
    }
}
