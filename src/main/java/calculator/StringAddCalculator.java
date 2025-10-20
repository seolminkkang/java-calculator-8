package calculator;

public class StringAddCalculator {

    public int calculate(String input) {
        if (isBlank(input)) return 0;

        input = input.replace("\\n", "\n");

        Delimiter.Result parsed = Delimiter.parse(input);
        Delimiter delimiter = parsed.delimiter();
        String numbersPart = parsed.numbersPart();

        if (isBlank(numbersPart)) return 0;

        String[] tokens = delimiter.split(numbersPart);
        Numbers numbers = Numbers.from(tokens);

        return numbers.sum();
    }

    private boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
