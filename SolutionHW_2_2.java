import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SolutionHW_2_2 {
    //    throws Exception - можно указывать чтобы не писать везде try catch
    public static void main(String[] args) throws IOException {

// 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

//      создаётся переменная типа Logger
        Logger logger = Logger.getLogger(SolutionHW_2_2.class.getName());
//      Обработчик FileHandler: записать сообщение журнала в файл.
//      если второй аргумент true, то файл дозаписывается, если false, то каждый раз записывается новый
        FileHandler fh = new FileHandler("log.txt", false);
//      добавление обработчика для переменной logger
        logger.addHandler(fh);
//      определение формата вывода
        SimpleFormatter sFormat = new SimpleFormatter();
//      установление формата вывода для обработчика
        fh.setFormatter(sFormat);

        //logger.setLevel(Level.INFO);
//        запись в журнал с уровнем (обычно так не делается)
//        logger.log(Level.WARNING, "String_1");
////        запись в журнал сообщения (без уровня)
//        logger.info("String_2");

        byte[] arr = new byte[10];
//        заполняем массив случайным образом (int от 0 до 99)

        StringBuilder sbArray = new StringBuilder();
        sbArray.append("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            //  Math.random() - случайное число double из промежутка [0,1)
            arr[i] = (byte) (Math.random() * 100);
            sbArray.append(arr[i]);
            sbArray.append(" ");
        }
//        вывод в консоль исходного массива
        System.out.println(sbArray);
//        логирование исходного массива с уровнем WARNING. StringBuilder надо преобразовать в String
        logger.log(Level.WARNING, sbArray.toString());

//        очистка sbArray
        sbArray.delete(0, sbArray.length());
        sbArray.append("Сортированный массив: ");

        arr = BubbleSort(arr, logger);
        for (byte b : arr) {
            sbArray.append(b);
            sbArray.append(" ");
        }
//        вывод в консоль сортированного массива
        System.out.println(sbArray);
//        логирование сортированного массива с уровнем WARNING. StringBuilder надо преобразовать в String
        logger.log(Level.WARNING, sbArray.toString());

    }

    // сортировка массива методом пузырька
// сортировка пузырьком - это метод сортировки массивов и списков путем последовательного сравнения и обмена соседних элементов,
// если предшествующий оказывается больше последующего.
//    аргументы массив и logger
    public static byte[] BubbleSort(byte[] array, Logger logger) {
        StringBuilder sbArray = new StringBuilder();
        int iterCount = 0;
//        флаг "Массив отсортирован"
        boolean isSorted = false;
        byte temp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
//                если предыдущий элемент массива больше последующего, то меняем их местами, сбрасываем флаг isSorted
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
//              формирование sb (в котором текущее состояние массива) для логирования
            iterCount++;
            sbArray.append("Массив после ");
            sbArray.append(iterCount);
            sbArray.append(" итерации: ");
            for (byte b : array) {
                sbArray.append(b);
                sbArray.append(" ");
            }
            logger.info(sbArray.toString());
            //        очистка sbArray (подготовка для следующего лога
            sbArray.delete(0, sbArray.length());
        }
        return array;
    }
}
