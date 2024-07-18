import java.util.Scanner;

import static java.util.Scanner.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(": ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid input format");
        }

        String operand1 = parts[0].replaceAll("\"", "");
        String operator = parts[1];
        String operand2 = parts[2].replaceAll("\"", "");
        if (!operand1.matches("[a-zA-Z]+")) { throw new IllegalArgumentException("Первый элемент не  должен быть числом ");}
        String result = "";

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                if (operand1.contains(operand2)) {
                    result = operand1.replace(operand2, "");
                } else {
                    result = operand1;
                }
                break;
            case "*":
                int num = Integer.parseInt(operand2);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    sb.append(operand1);
                }
                result = sb.toString();
                break;
            case "/":
                int divisor = Integer.parseInt(operand2);
                int length = operand1.length() / divisor;
                result = operand1.substring(0, length);
                break;
            default:
                throw new IllegalArgumentException("Ошибка");
        }

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        System.out.println(": \"" + result + "\"");
    }
}
