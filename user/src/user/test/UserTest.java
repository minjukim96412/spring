package user.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import user.domain.User;
import user.service.UserService;
import user.service.UserServiceImpl;

public class UserTest {
	
	private ApplicationContext context;
	
	@Autowired
	private UserService userService;
	
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("conf/beans.xml");
		userService = (UserServiceImpl)context.getBean("userService");
	}
	
	@Test
	public void dataSourceTest() {
		DataSource ds =  (DataSource)context.getBean("dataSource");
		
		try {
			Connection conn = ds.getConnection();
			System.out.println(conn);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
	}
	
	//@Test
	public void insertUser() {
		User user = new User(0,"아이디1","이름1","남","서울");
		userService.insertUser(user);
		System.out.println(user);
	}
	
	@Test
	public void updateUser() {
		User user = new User(2,"new아이디","new이름","여","서울");
		userService.updateUser(user);
	}
	
	@Test
	public void deleteUser() {
		userService.deleteUser(3);
		
	}
	
	@Test
	public void getUser() {
		User user = userService.getUser(2);
		System.out.println(user);
	}
	@Test
	public void getUserList() {
		List<User> userList = userService.getUserList();
		System.out.println(userList);
	}
	
	
}
