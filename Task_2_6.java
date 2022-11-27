//        Задание 6.
//Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
//1 Расширение файла: txt
//2 Расширение файла: pdf
//3 Расширение файла:
//4 Расширение файла: jpg
//Используем listFiles() класса File.import java.io.File;

import java.io.File;

public class Task_2_6 {

    //    по пути к файлу получает список файлов и директорий из папки, возвращает SB, содержащий расширения всех файлов
//    если раскомментировать строки, то будут добавлены названия папок и файлов
    public static StringBuilder getNameOfFiles(String pathName) {
        StringBuilder nameOfFiles = new StringBuilder();
        File dir = new File(pathName);
        System.out.println(dir.getAbsolutePath());
// массив файлов и подкаталогов, которые находятся в определенном каталоге
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            if (file.isFile()) {
//                nameOfFiles.append("File ");
//                nameOfFiles.append(file.getName());
//                nameOfFiles.append(" ");
                nameOfFiles.append("Расширение файла: ");
                nameOfFiles.append(file.getName().split("\\.")[1]);
                nameOfFiles.append("\n");
            } else {
//                nameOfFiles.append("Folder ");
//                nameOfFiles.append(file.getName());
//                nameOfFiles.append("\n");
            }
        }
        return nameOfFiles;
    }

    public static void main(String[] args) {
        String pathName = ".";
        System.out.println(getNameOfFiles(pathName));

    }
}
