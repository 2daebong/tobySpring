package learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	
	public String concatenate(String filePath) throws IOException {
		
		LineCallback<String> callback = new LineCallback<String>() {
			
			public String doSomethingWithLine(String line, String value) {
				return value += line;
			}
		};
		
		return lineReadTemplate(filePath, callback, "Hello World\n");
	}

	public Integer calcMul(String filePath) throws IOException {
		
		LineCallback<Integer> callback = new LineCallback<Integer>() {
			
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(filePath, callback, 1);
	}

	public Integer calcSum(String filePath) throws IOException {
		
		LineCallback<Integer> callback = new LineCallback<Integer>() {

			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(filePath, callback, 0);
	}

	private <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initVal) throws IOException {
		BufferedReader br = null;
		T val = initVal; // 변하는 부분

		try {
			br = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = br.readLine()) != null) {
				val = callback.doSomethingWithLine(line, val);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		return val;
	}
}
