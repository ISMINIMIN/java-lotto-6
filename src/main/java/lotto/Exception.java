package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public static void printException(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }

    public static void priceValidate(String input) {
        int price;
        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또 1장의 가격은 1,000원입니다.");
        }
    }

    public static void winningNumberValidate(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력하셔야 합니다.");
        }

        Set<Integer> checkDuplication = new HashSet<>();
        for(int number : winningNumbers) {
            checkDuplication.add(number);
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        if(winningNumbers.size() != checkDuplication.size()) {
            throw new IllegalArgumentException("중복된 번호를 입력하셨습니다.");
        }
    }

    public static void bonusNumberValidate(String input, List<Integer> winningNumbers) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1개의 숫자를 입력하셔야 합니다.");
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        for(int number : winningNumbers) {
            if(number == bonusNumber) {
                throw new IllegalArgumentException("당첨번호에 중복된 번호가 존재합니다.");
            }
        }
    }
}
