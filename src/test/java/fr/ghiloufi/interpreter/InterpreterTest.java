package fr.ghiloufi.interpreter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InterpreterTest {

	private Interpreter interpreter;

	@Before
	public void setup() {
		Interpreter interpreter = new Interpreter();
		this.interpreter = interpreter;
	}

	@Test
	public void should_return_number() {
		assertEquals("1", interpreter.evaluate("1"));
	}

	@Test
	public void should_return_string() {
		assertEquals("Hello World !", interpreter.evaluate("\"Hello World !\""));
	}

	@Test
	public void should_return_the_sum() {
		List<Object> instructions_1 = List.of("+", "1", "2");
		List<Object> instructions_2 = List.of("+", List.of("+", "2", "3"), "5");
		assertEquals("3", interpreter.evaluate(instructions_1));
		assertEquals("10", interpreter.evaluate(instructions_2));
	}

	@Test
	public void should_return_the_substraction() {
		List<Object> instructions_1 = List.of("-", "1", "2");
		List<Object> instructions_2 = List.of("-", List.of("-", "2", "3"), "5");
		assertEquals("-1", interpreter.evaluate(instructions_1));
		assertEquals("-6", interpreter.evaluate(instructions_2));
	}

	@Test
	public void should_return_the_power() {
		List<Object> instructions_1 = List.of("*", "1", "2");
		List<Object> instructions_2 = List.of("*", List.of("*", "2", "3"), "5");
		assertEquals("2", interpreter.evaluate(instructions_1));
		assertEquals("30", interpreter.evaluate(instructions_2));
	}

	@Test
	public void should_return_the_division() {
		List<Object> instructions_1 = List.of("/", "1", "2");
		List<Object> instructions_2 = List.of("/", List.of("/", "2", "3"), "5");
		List<Object> instructions_3 = List.of("/", "6", "2");
		List<Object> instructions_4 = List.of("/", List.of("/", "6", "3"), "2");
		assertEquals("0", interpreter.evaluate(instructions_1));
		assertEquals("0", interpreter.evaluate(instructions_2));
		assertEquals("3", interpreter.evaluate(instructions_3));
		assertEquals("1", interpreter.evaluate(instructions_4));
	}

}
