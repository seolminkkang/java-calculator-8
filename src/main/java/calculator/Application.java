package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            StringAddCalculator calculator = new StringAddCalculator();
            int result = calculator.calculate(input);

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 요구사항: 예외 발생 시 종료(System.exit() 금지) → 자연 종료
            // 필요 시 메시지 출력만
            // System.err.println(e.getMessage());
        } finally {
            Console.close();
        }
    }
}
