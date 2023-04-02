import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTEST {
    public static void main(String[]args) throws SQLException {
        Connection connection = null;
        String url = "jdbc:mariadb://localhost:3306/ld_kern_db";
        String user ="LD_KERN_ID1";
        String pwd = "313244";

        connection = DriverManager.getConnection(url,user,pwd);
        System.out.println("Connection");


    }
}
