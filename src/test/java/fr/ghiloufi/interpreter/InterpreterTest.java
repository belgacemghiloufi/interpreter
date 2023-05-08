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
		List<String> instructions = List.of("1");
		assertEquals("1", interpreter.evaluate(instructions));
	}
	
	@Test
	public void should_return_string() {
		List<String> instructions = List.of("\"Hello World !\"");
		assertEquals("Hello World !", interpreter.evaluate(instructions));
	}

}
