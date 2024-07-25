import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(": ");
        String input = scanner.nextLine().trim();

        StringBuilder result = new StringBuilder();
        boolean inQuotes = false;

        for (char c : input.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            }
            if (inQuotes && c == ' ') {
                result.append('ъ');
            } else {
                result.append(c);
            }
        }

            String[] parts = result.toString().split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода");
            }

            String operand1 = parts[0];
            String operator = parts[1];
            String operand2 = parts[2];
            if (operand1.matches("[-+]?\\d+") && !operand2.matches("[-+]?\\d+")) {
                throw new IllegalArgumentException("Первый элемент не  должен быть числом ");
            }

            if (!operand2.matches("10|[1-9]") && operand2.matches("[-+]?\\d+")) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }
operand1= operand1.replaceAll("\"", "");
        operand2= operand2.replaceAll("\"", "");
        if (operand1.length() > 10 || operand2.length() > 10) {
                throw new IllegalArgumentException("Строки должны быть длиной не более 10 символов");
            }

            String result1 = " ";

            switch (operator) {
                case "+":
                    result1 = operand1 + operand2;
                    break;
                case "-":
                    if (operand1.contains(operand2)) {
                        result1 = operand1.replace(operand2, "");
                    } else {
                        result1 = operand1;
                    }
                    break;
                case "*":
                    int num = Integer.parseInt(operand2);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < num; i++) {
                        sb.append(operand1);
                    }
                    result1 = sb.toString();
                    break;
                case "/":
                    int divisor = Integer.parseInt(operand2);
                    int length = operand1.length() / divisor;
                    result1 = operand1.substring(0, length);
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка");
            }

            if (result1.length() > 40) {
                result1 = result.substring(0, 40) + "...";
            }
            result1=result1.replaceAll("ъ"," ");

            System.out.println(": \"" + result1 + "\"");

    }
}
