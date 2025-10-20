package calculator;

import java.util.ArrayList;
import java.util.List;

public final class Numbers {
    private final List<PositiveNumber> values;

    private Numbers(List<PositiveNumber> values) {
        this.values = values;
    }

    public static Numbers from(String[] tokens) {
        List<PositiveNumber> list = new ArrayList<>();
        for (String t : tokens) {
            PositiveNumber n = PositiveNumber.from(t);
            list.add(n);
        }
        return new Numbers(list);
    }

    public int sum() {
        int acc = 0;
        for (PositiveNumber n : values) {
            acc = n.addTo(acc);
        }
        return acc;
    }
}
