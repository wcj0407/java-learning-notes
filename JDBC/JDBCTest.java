import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    @Test
    public void Test() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url ="jdbc:mysql://localhost:3306/db2";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
         int i =statement.executeUpdate("update user set age =26 where id =1");
        System.out.println(i);
        statement.close();
        connection.close();
    }
}
