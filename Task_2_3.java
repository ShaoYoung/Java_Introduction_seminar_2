//       Задание 3.
//Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
//Не использовать метод reverse().

import java.util.Scanner;

public class Task_2_3 {

    public static boolean checkPalindrome(String sourseString) {
        char[] symbols = sourseString.toCharArray();
        for (int i = 0; i <= symbols.length / 2; i++) {
            if (symbols[i] != symbols[symbols.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String sourseString = iScanner.nextLine();
        iScanner.close();

        if (checkPalindrome(sourseString)) System.out.printf("Строка %s палиндром", sourseString);
        else System.out.printf("Строка %s не палиндром", sourseString);

    }
}
