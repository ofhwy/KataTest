import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void calc(String input) throws Exception {
        String[] arr = input.split(" ");

        boolean isRoman = true;
        int first = Rome.getInt(arr[0]);
        int second = Rome.getInt(arr[2]);

        if (first == -1 && second == -1) {
            isRoman = false;
            first = Integer.parseInt(arr[0]);
            second = Integer.parseInt(arr[2]);
        } else if (first == -1 || second == -1) {
            throw new Exception("Неверный ввод!");
        }

        if (first > 10 || first < 1 || second > 10 || second < 1) throw new Exception("Неверный ввод!");

        int res = switch (arr[1]) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "/" -> first / second;
            case "*" -> first * second;
            default -> 0;
        };
        if (isRoman && res<=0) throw new Exception("Неверный результат");
        if (isRoman) {
           res = Integer.parseInt(Rome.getRome(res));
        }
        System.out.println(res);
    }

    class Rome {
        static String[] mini_roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        static String[] big_roman = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        static Integer getInt(String str) {
            return Arrays.asList(mini_roman).indexOf(str);
        }

        public static String getRome(Integer num) {
            if (num <= 10) {
                return mini_roman[num];
            } else if (num == 100) {
                return "C";
            } else {
                return big_roman[num / 10] + mini_roman[num % 10];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String inputLine = console.nextLine();
        while (!inputLine.equals("stop")) { //пока inputLine не равно stop
            calc(inputLine);
            inputLine = console.nextLine();
        }
    }
}