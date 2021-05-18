package externals;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/anar?useSSl=false & serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3306/anar";
        String username = "root";
        String password = "112358";
        return DriverManager.getConnection(url, username, password);
    }
}
