import java.util.Scanner;

public class Task_2_1 {
    public static void main(String[] args) {


//        Задание 1.
//Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N,
// которая состоит из чередующихся символов c1 и c2, начиная с c1.
//
//
//Ответ:
//с1 = а
//с2 = б
//
//абабабабаб (всего N символов)

//        получение данных из терминала через экземпляр Scanner. Надо import java.util.Scanner;
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n: ");
//        считываем строку из консоли
        String nString = iScanner.nextLine();
//        преобразем в int
        int n = Integer.parseInt(nString);
        System.out.printf("Введите символ c1: ");
//        считываем строку из консоли
        String c1 = iScanner.nextLine();
        System.out.printf("Введите символ c2: ");
//        считываем строку из консоли
        String c2 = iScanner.nextLine();
        //        сканер надо закрывать
        iScanner.close();

        StringBuilder sres = new StringBuilder();

// 1- й вариант
        //        for (int i = 1; i <= n; i++) {
//            if (i%2 == 0){
//                sres.append(c1);
//            } else {
//                sres.append(c2);
//            }
//        }

// === 2-й вариант
//        for (int i = 1; i <= n/2; i++) {
//            sres.append(c1+c2);
//        }
//
//        System.out.println(sres);

//        3- вариант
        sres.append((c1 + c2).repeat(Math.max(0, n / 2)));


        System.out.println(sres);

    }
}
