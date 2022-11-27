import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionHW_2_3 {
    public static void main(String[] args) {

// ДЗ 3. Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String fileName = "json_string.json";
        String fileInfo = "info.txt";
        saveFile(jsonString, fileName, false);
        StringBuilder sbJson = loadFile(fileName);
//        преобразуем StringBuilder в String, затем разбиваем её. Разделитель "},{"
        String[] persons = sbJson.toString().split("},\\{");
        for (String person : persons) {
//            удаляем лишние символы (", [, ], {, })
            person = person.replace("\"", "");
            if (person.contains("[")) {
                person = person.replace("[", "");
            }
            if (person.contains("]")) {
                person = person.replace("]", "");
            }
            if (person.contains("{")) {
                person = person.replace("{", "");
            }
            if (person.contains("}")) {
                person = person.replace("}", "");
            }
//            разбиваем на записи по каждому студенту. Разделитель ",".
            String[] records = person.split(",");
//            и передаём записи в метод noteFromJournal для формирования SB строки журнала каждого студента
            StringBuilder noteFromJournal = getNote(records);
//            печатаем каждую запись
            System.out.println(noteFromJournal);
//            дозаписываем информацию в файл
            noteFromJournal.append("\n");
            saveFile(noteFromJournal.toString(), fileInfo, true);

        }
    }

    //    Формируем запись журнала. На входе массив строк - записи по студенту. На выходе StringBuilder.
    public static StringBuilder getNote(String[] records) {
        StringBuilder noteFromJournal = new StringBuilder();
//        проходим по каждой записи
        for (String record : records) {
//            делим запись по ":"
            String[] elements = record.split(":");
//            в зависимости от записи добавляем соответствющую запись в журнал
            switch (elements[0]) {
                case "фамилия" -> {
                    noteFromJournal.append("Студент ");
                    noteFromJournal.append(elements[1]);
                }
                case "оценка" -> {
                    noteFromJournal.append(" получил ");
                    noteFromJournal.append(elements[1]);
                }
                case "предмет" -> {
                    noteFromJournal.append(" по предмету ");
                    noteFromJournal.append(elements[1]);
                    noteFromJournal.append(".");
                }
            }
        }
        return noteFromJournal;
    }

    // Запись файла
    public static void saveFile(String content, String fileName, boolean addRec) {
//        второй агрумент отвечает за дозапись уже имеющегося. false - записывает новый, true - дозаписывает существующий
        try (FileWriter fw = new FileWriter(fileName, addRec)) {
            fw.write(content);
            fw.flush();
//            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //    Чтение из файла. На выходе StringBuilder
    public static StringBuilder loadFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try (FileReader fr = new FileReader(fileName)) {
            // читаем посимвольно
            int symb;
//            пока не конец файла
            while ((symb = fr.read()) != -1) {
                fileContent.append((char) symb);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileContent;
    }
}
