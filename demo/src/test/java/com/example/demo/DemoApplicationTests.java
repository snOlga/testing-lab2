package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	static double CALC_ERROR = 1;

	@BeforeAll
	static void mockAll() {
		Mockito.mockStatic(Logarithm.class);
		Mockito.mockStatic(Trigonometry.class);
	}

	@ParameterizedTest
	@CsvSource({
			"-3.14,0.00,1.00,0.00,0.00,0.00,0.00",
			"10.00,0.00,0.00,2.30258509,3.32192809,1.430676558,447.711"
	})
	void allMocked(double x, 
			double mockSin, 
			double mockSec, 
			double mockLn, 
			double mockLog2, 
			double mockLog5,
			double expected) {
		Mockito.when(Trigonometry.sin(x)).thenReturn(mockSin);
		Mockito.when(Trigonometry.sec(x)).thenReturn(mockSec);
		Mockito.when(Logarithm.ln(x)).thenReturn(mockLn);
		Mockito.when(Logarithm.log2(x)).thenReturn(mockLog2);
		Mockito.when(Logarithm.log5(x)).thenReturn(mockLog5);

		double result = FunctionSystem.count(x);

		Assert.isTrue(result <= (expected + CALC_ERROR) && result >= (expected - CALC_ERROR), "");
	}

}
