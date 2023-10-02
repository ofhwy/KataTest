import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void main(String input) throws Exception {
        String[] arr = input.split(" ");

        boolean isRoman = true;
        int first = Rome.getInt(arr[0]);
        int second = Rome.getInt(arr[2]);

        if (first == -1 && second == -1) {
            first = Integer.parseInt(arr[0]);
            second = Integer.parseInt(arr[2]);
            isRoman = false;
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
        System.out.println(isRoman ? Rome.getRome(res) : res);
    }

    class Rome {
        static String[] lil_roman = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        static Map<Integer, String> big_roman = new HashMap<Integer, String>() {{
            put(1, "X");
            put(2, "XX");
            put(3, "XXX");
            put(4, "XL");
            put(5, "L");
            put(6, "LX");
            put(7, "LXX");
            put(8, "LXXX");
            put(9, "XC");
        }};

        static Integer getInt(String str) {
            return Arrays.asList(lil_roman).indexOf(str);
        }

        public static String getRome(Integer num) {
            if (num <= 10) {
                return lil_roman[num];
            } else if (num == 100) {
                return "C";
            } else {
                return big_roman.get(num / 10) + lil_roman[num % 10];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String inputLine = console.nextLine();
        while (!inputLine.equals("stop")) { //пока inputLine не равно stop
            main(inputLine);
            inputLine = console.nextLine();

        }
    }
}