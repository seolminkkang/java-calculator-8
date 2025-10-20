package calculator;

public final class PositiveNumber {
    private final int value;

    private PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static PositiveNumber from(String token) {
        if (token == null || token.isBlank()) throw new IllegalArgumentException();

        int parsed = parseInt(token);
        return new PositiveNumber(parsed);
    }

    public int addTo(int acc) {
        return acc + this.value;
    }

    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int v) {
        if (v <= 0) throw new IllegalArgumentException();
    }
}
