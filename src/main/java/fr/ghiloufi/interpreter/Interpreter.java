package fr.ghiloufi.interpreter;

import java.util.List;
import java.util.regex.Pattern;

public class Interpreter {

	private Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public String evaluate(Object instruction) {
		if (isNumeric(instruction)) {
			return instruction.toString();
		}
		if (isString(instruction)) {
			return instruction.toString().replace("\"", "");
		}
		if (isList(instruction)) {
			@SuppressWarnings("unchecked")
			List<Object> instructions = (List<Object>) instruction;
			if (instructions.get(0).equals("+")) {
				String operand_1 = evaluate(instructions.get(1));
				String operand_2 = evaluate(instructions.get(2));
				return Integer.toString(Integer.parseInt(operand_1) + Integer.parseInt(operand_2));
			}
			if (instructions.get(0).equals("-")) {
				String operand_1 = evaluate(instructions.get(1));
				String operand_2 = evaluate(instructions.get(2));
				return Integer.toString(Integer.parseInt(operand_1) - Integer.parseInt(operand_2));
			}
			if (instructions.get(0).equals("*")) {
				String operand_1 = evaluate(instructions.get(1));
				String operand_2 = evaluate(instructions.get(2));
				return Integer.toString(Integer.parseInt(operand_1) * Integer.parseInt(operand_2));
			}
			if (instructions.get(0).equals("/")) {
				String operand_1 = evaluate(instructions.get(1));
				String operand_2 = evaluate(instructions.get(2));
				return Integer.toString(Integer.parseInt(operand_1) / Integer.parseInt(operand_2));
			}
		}
		throw new RuntimeException(String.format("Unknown instruction \n %S", instruction.toString()));
	}

	private boolean isList(Object instruction) {
		return instruction instanceof List;
	}

	private boolean isString(Object instruction) {
		return instruction.toString().startsWith("\"") && instruction.toString().endsWith("\"");
	}

	private boolean isNumeric(Object instruction) {
		return numericPattern.matcher(instruction.toString()).matches();
	}

}
