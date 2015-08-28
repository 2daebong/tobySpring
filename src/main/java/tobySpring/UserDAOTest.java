package tobySpring;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(locations = { "/spring/applicationContext.xml"})
public class UserDAOTest {
	
	@Autowired
	private UserDAO dao;
	
	@Before
	public void setUp(){
	}
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException{

		dao.deleteAll();
		assertThat(dao.getCount(),is(0));
		
		User user = new User();
		user.setId("hello8");
		user.setName("E-SENS3");
		user.setPassword("1123423");
		
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
//		System.out.println("조회 성공 " + user2.getName());
	}
	
	@Test
	public void countTest() throws ClassNotFoundException, SQLException {
		// given 
		User user = new User("dummy1", "name1", "p1");
		User user2 = new User("dummy2", "name2", "p2");
		User user3 = new User("dummy3", "name3", "p3");
		// when
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user);
		assertThat(dao.getCount(), is(1));
		
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException{
		// given 
		dao.deleteAll();
		
		assertThat(dao.getCount(), is(0));
		
		dao.get("dummyId");
		// when

		// then
		
	}
	
	@Ignore
	@Test
	public void deleteTest() {
		// given 
		// when

		// then
		try {
			dao.deleteAll();
		} catch (SQLException e) {
			System.out.println("delete error .. ");
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void getCountTest() throws SQLException, ClassNotFoundException{
		// given 
		dao.deleteAll();
		User user = new User();
		user.setId("2daebong");
		user.setName("simon D");
		user.setPassword("1234");
		
		dao.add(user);
		// when

		// then
		assertThat(dao.getCount(), is(1));
	}
}