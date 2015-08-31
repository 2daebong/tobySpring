package learningtest.template;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	
	private Calculator calculator;
	private int val;
	private String path;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
		val = 0;
		path = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumOfNumbers() {
		try {
			val = calculator.calcSum(path);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		assertThat(val, is(10));
	}
	
	@Test
	public void multiplyOfNumbers() {
		try{
			val = calculator.calcMul(path);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		assertThat(val, is(24));
	}
}
