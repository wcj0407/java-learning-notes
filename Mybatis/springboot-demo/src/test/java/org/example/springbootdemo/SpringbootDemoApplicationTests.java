package org.example.springbootdemo;

import org.example.springbootdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemoApplicationTests {
	@Autowired
	private UserMapper usermapper;

	@Test
	 void testFindAll(){
		List<UserMapper> all = usermapper.findAll();
		all.forEach(System.out::println);

	}
}
