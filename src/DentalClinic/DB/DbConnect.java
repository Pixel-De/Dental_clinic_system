package DentalClinic.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private Connection db;

    private Connection Connect(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6411222","sql6411222","m6Z57Fl9LD");
            System.out.println("connection success");
            return connection;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    };

    public DbConnect(){
        this.db = this.Connect();
    }

    public Connection getStatus(){
        return this.db;
    }
}

