//        Задание 5.
//Напишите метод, который вернет содержимое текущей папки в виде массива строк.
//Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
//Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task_2_5 {

    //    формирует массив строк - содержимое папки pathname
    public static String[] getNameOfFiles(String pathName) {
        File dir = new File(pathName);
// массив файлов и подкаталогов, которые находятся в определенном каталоге
        File[] filesList = dir.listFiles();
        String[] strArr = new String[filesList.length];
        for (int i = 0; i < filesList.length; i++) {
            if (filesList[i].isFile()) {
                strArr[i] = "  " + filesList[i].getName();
            } else {
                strArr[i] = filesList[i].getName();
            }
        }
        return strArr;
    }

    public static void saveFile(String fileName, String[] strArr) throws IOException {
        //      создаётся переменная типа Logger
        Logger logger = Logger.getLogger(Task_2_5.class.getName());
//      Обработчик FileHandler: записать сообщение журнала в файл.
//      если второй аргумент true, то файл дозаписывается, если false, то каждый раз записывается новый
        FileHandler fh = new FileHandler("log_save_list_files.txt", false);
//      добавление обработчика для переменной logger
        logger.addHandler(fh);
//      определение формата вывода
        SimpleFormatter sFormat = new SimpleFormatter();
//      установление формата вывода для обработчика
        fh.setFormatter(sFormat);

        try (FileWriter fw = new FileWriter(fileName, false)) {
            for (String file : strArr) {
                fw.write(file);
                fw.write("\n");
                System.out.println(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        String pathName = ".";
        String[] strArr = getNameOfFiles(pathName);
        String fileName = "list_files.txt";
        saveFile(fileName, strArr);
        }
    }

//        String pathFile = "C:\\Users\\Nikita\\IdeaProjects\\Introduction_to_Java\\Seminars\\seminar_2\\src\\main\\java\\org\\example\\Task_2_1.txt";
//
//        String line = "empty";
//        try {
//            File file = new File(pathFile);
//            if (file.createNewFile()) {
//                System.out.println("file.created"); }
//            else {
//                BufferedReader bufReader = new BufferedReader(new FileReader(file));
//                System.out.println("file.existed");
//                line = bufReader.readLine();
//                bufReader.close(); }
//        } catch (Exception e) {
//            //e.printStackTrace();
//        } finally {
//            System.out.println(line);
//        }





