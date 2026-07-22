# JDBC

就是使用java语言操作关系型数据库的一套API



## JDBC的基础使用：

### 1.先创建一个表

```
create table user(
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) comment '用户名',
    password varchar(32) comment '密码',
    name varchar(10) comment '姓名',
    age tinyint unsigned comment '年龄'
) comment '用户表';

insert into user(id, username, password, name, age)
values
(1, 'daqiao', '123456', '大乔', 22),
(2, 'xiaoqiao', '123456', '小乔', 18),
(3, 'diaochang', '123456', '貂蝉', 24),
(4, 'lvbu', '123456', '吕布', 28),
(5, 'zhaoyun', '12345678', '赵云', 27);
```

### 2.要在idea中创建一个maven的项目并编写pom.xml

```
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>9.4.0</version>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.12.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.42</version>
    </dependency>
</dependencies>
```

### 3.创建一个test

```
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
```



## JDBC-查询数据

ResultSet:ResultSet rs = statement.executeQuery()

next():将光标从当前位置向前移动一行，并判断当前行是否为有效行返回是boolean

true：有效行，当前行有数据

false：无效行，当前行没有数据r

如果返回的是true表明里面有数据，就会利用getint 或者getString 来获取里面的具体数据