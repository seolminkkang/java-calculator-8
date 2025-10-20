package calculator;

import java.util.regex.Pattern;

public final class Delimiter {
    private static final String DEFAULT = "[,:]";
    private final Pattern splitPattern;

    private Delimiter(String regex) {
        this.splitPattern = Pattern.compile(regex);
    }

    public static Result parse(String input) {
        if (!input.startsWith("//")) {
            Delimiter d = new Delimiter(DEFAULT);
            return new Result(d, input);
        }

        int nl = input.indexOf('\n');
        if (nl < 0) throw new IllegalArgumentException();

        String header = input.substring(2, nl);
        if (header.isEmpty() || header.length() > 1) throw new IllegalArgumentException();

        String customRegex = Pattern.quote(header);
        String regex = DEFAULT + "|" + customRegex;

        Delimiter d = new Delimiter(regex);
        String body = input.substring(nl + 1);

        return new Result(d, body);
    }

    public String[] split(String numbersPart) {
        return this.splitPattern.split(numbersPart, -1);
    }

    public record Result(Delimiter delimiter, String numbersPart) {}
}
