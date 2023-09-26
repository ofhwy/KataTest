import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        String[] arr = input.split(" ");
        byte first = Byte.parseByte(arr[0]);
        byte second = Byte.parseByte(arr[2]);
        String operation = arr[1];
        switch (operation) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "/":
                System.out.println(first / second);
                break;
            case "*":
                System.out.println(first * second);
                break;
        }

        return "";
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputLine = console.nextLine();
        while (!inputLine.equals("stop")) { //пока imputLine не равно stop
            calc(inputLine);
            inputLine = console.nextLine();
        }
    }
}