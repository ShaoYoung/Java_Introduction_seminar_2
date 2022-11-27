public class SolutionHW_2_1 {
    public static void main(String[] args) {

// 1.Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

        String sSQLQuery = "select * from students where";
        StringBuilder sbSQLQuery = new StringBuilder();
        sbSQLQuery.append(sSQLQuery);
        String jsonString = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
//        String jsonString = "{\"name\":\"Ivanov\"}";
//        String jsonString = "{\"name\":\"Ivanov\",\"age\":\"null\"}";
// удаляем из строки {, }, ", '
        jsonString = jsonString.replace("{", "");
        jsonString = jsonString.replace("}", "");
        if (jsonString.contains("\"")) {
            jsonString = jsonString.replace("\"", "");
        }
        if (jsonString.contains("'")) {
            jsonString = jsonString.replace("'", "");
        }
        String[] elements = jsonString.split(",");
        for (String elem : elements) {
            String[] pair = elem.split(":");
//            если у параметра есть значение
            if (pair.length > 1) {
//                если значение параметра не null
                if (!pair[1].toLowerCase().equals("null")) {
                    sbSQLQuery.append("\n");
                    sbSQLQuery.append(pair[0]);
                    sbSQLQuery.append(" = \"");
                    sbSQLQuery.append(pair[1]);
                    sbSQLQuery.append("\" and");
                }
            }
        }
//        удаляем последнее "and" из StringBuilder, содержащего итоговый SQL-запрос
        if (sbSQLQuery.substring(sbSQLQuery.length() - 3, sbSQLQuery.length()).equals("and")) {
            sbSQLQuery.delete(sbSQLQuery.length() - 3, sbSQLQuery.length());
        }

        System.out.printf("SQL-запрос:\n%s", sbSQLQuery);

    }
}
