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
	public void concatenateString() throws IOException {
		assertThat(calculator.concatenate(path), is("Hello World\n1234"));
	}
	
	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(path), is(10));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMul(path), is(24));
	}
}
