package fr.ghiloufi.interpreter;

import java.util.List;
import java.util.regex.Pattern;

public class Interpreter {

	private Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public String evaluate(List<String> instructions) {
		if (isNumeric(instructions.get(0)))
			return instructions.get(0);
		if(isString(instructions.get(0))) {
			return instructions.get(0).replace("\"", "");
		}
		return null;
	}

	private boolean isString(String string) {
		return string.startsWith("\"") && string.endsWith("\"");
	}

	private boolean isNumeric(String string) {
		return numericPattern.matcher(string).matches();
	}

}
