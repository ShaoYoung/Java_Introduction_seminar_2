//   Задание 4.
//Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.
//Использовать StringBuilder для составления строки.

import java.io.FileWriter;
import java.io.IOException;

public class Task_2_4 {
//составляет строку из 100 повторений входящей строки word
    public static StringBuilder getSB(String word) {
        StringBuilder sbRepeat = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sbRepeat.append(word);
        }
        return sbRepeat;
    }

//    запись в файл
    public static void saveFile(StringBuilder content, String fileName, boolean addRec) {
//        второй агрумент отвечает за дозапись уже имеющегося. false - записывает новый, true - дозаписывает существующий
        try (FileWriter fw = new FileWriter(fileName, addRec)) {
            fw.write(content.toString());
            fw.flush();
//            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args) {

        String word = "TEST";
        StringBuilder sbRepeat = getSB(word);
        System.out.println(sbRepeat);
        saveFile(sbRepeat, "test_repeat.txt", false);


    }
}
