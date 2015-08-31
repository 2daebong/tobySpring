package learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

	public Integer calcMul(String filePath) throws IOException {
		
		LineCallback callback = new LineCallback() {
			public Integer doSomethingWithLine(String line, int val) {
				return val * Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(filePath, callback, 1);
	}

	public Integer calcSum(String filePath) throws IOException {
		
		LineCallback callback = new LineCallback() {
			
			public Integer doSomethingWithLine(String line, int val) {
				return val + Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(filePath, callback, 0);
	}

	private Integer lineReadTemplate(String filePath, LineCallback callback, int initVal) throws IOException {
		BufferedReader br = null;
		Integer val = initVal; // 변하는 부

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
