//        Задание 2.
//
//Напишите метод, который сжимает строку по правилу:
//На входе: aaaabbbcdd
//На выходе: a4b3cd2

import java.util.Scanner;

public class Task_2_2 {
    //    Метод RLE-сжатия строки
    public static StringBuilder compressString(String sourseString) {
        StringBuilder compString = new StringBuilder();
        char[] symbols = sourseString.toCharArray();
        char symbol = symbols[0];
        byte count = 1;
        for (int i = 1; i < symbols.length; i++) {
            if (symbols[i] == symbol) {
                count++;
            } else {
                compString.append(symbol);
                if (count != 1) compString.append(count);
                symbol = symbols[i];
                count = 1;
            }
        }
        compString.append(symbol);
        if (count != 1) compString.append(count);
        return compString;
    }

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String sourseString = iScanner.nextLine();
        iScanner.close();

        System.out.printf("Сжатая строка %s", compressString(sourseString));
    }
}
