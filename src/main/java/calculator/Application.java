package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 안내 문구 출력 (요구사항 예시와 동일)
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 입력
        String input = Console.readLine();

        // 계산
        int result = new StringAddCalculator().calculate(input);

        // 출력 형식 준수
        System.out.println("결과 : " + result);

    }
}
