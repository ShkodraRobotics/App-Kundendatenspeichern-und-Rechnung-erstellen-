import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class DBcon {
    private Connection con = null;
    String url = "jdbc:mariadb://localhost:3306/ld_kern_db";
    private String user;
    private String pass;





    public String Verbingun(String user,String pass){
        this.user = user;
        this.pass = pass;
        try {
            con= DriverManager.getConnection(this.url,this.user,this.pass);

        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
        return "succ";

    }




}
