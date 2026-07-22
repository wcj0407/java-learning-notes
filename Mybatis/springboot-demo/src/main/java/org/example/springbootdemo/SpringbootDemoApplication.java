package org.example.springbootdemo;

import org.example.springbootdemo.mapper.UserMapper;
import org.example.springbootdemo.pojo.user;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
@MapperScan("org.example.springbootdemo.mapper")
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	private UserMapper usermapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=======开始查询用户数据=======");
		List<user> userList = usermapper.findAll();
		userList.forEach(System.out::println);
		System.out.println("=======查询结束=======");
	}
}
