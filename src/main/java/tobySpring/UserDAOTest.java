package tobySpring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDAOTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		ApplicationContext context = new GenericXmlApplicationContext("spring/applicationContext.xml");
		UserDAO dao = context.getBean("userDAO", UserDAO.class);
		
		User user = new User();
		user.setId("daebong");
		user.setName("이대범");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
	}
}