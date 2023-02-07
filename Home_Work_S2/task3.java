import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
 * Дана json строка (сохранена в файл "student.txt")
 * Написать метод(ы), который распарсит json и, используя StringBuilder, 
 * создаст строки вида:
 *                  Студент [фамилия] получил [оценка] по предвему [предмет].
 * Пример вывода:
 *                  Студент Иванов получил 5 по предмету Математика.
 */

public class task3 {

    public static void main(String[] args) {
        String[] arr = convertArr(readFileJson());
        //System.out.println(Arrays.toString(arr));
        printStudentInfo(splitStringArr(arr));
    }

    public static char[] readFileJson() {
        try(FileReader reader = new FileReader("student.txt")){
            char[] buf = new char[256];
            int item;
            while ((item = reader.read(buf)) > 0){
                if (item < 256){
                    buf = Arrays.copyOf(buf, item);
                }
            }
            return buf;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static String[] convertArr(char[] charArr){
        if (charArr != null){
            String[] stringArr = (new String(charArr)).split("},");
            for (int i = 0; i < stringArr.length; i++) {
                stringArr[i] = stringArr[i].replace("[", "");
                stringArr[i] = stringArr[i].replace("]", "");
                stringArr[i] = stringArr[i].replace("{", "");
                stringArr[i] = stringArr[i].replace("}", "");
                stringArr[i] = stringArr[i].replace("\"", "");
                stringArr[i] = stringArr[i].replace("\", ", "\"");
            }
            return stringArr;
        }
        return null;
    }

    public static String[][] splitStringArr(String[] arr){
        int len1 = arr.length;
        int len2 = ((arr[0]).split(",")).length;
        String[][] newArr = new String[len1][len2];
        for (int i = 0; i < arr.length; i++) {
            String[] item = (arr[i]).split(",");
            for (int j = 0; j < item.length; j++) {
                newArr[i][j] = item[j];
            }
        }
        return newArr;
    }

    public static void printStudentInfo(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            StringBuilder resultLine = new StringBuilder("");
            for (int j = 0; j < arr.length; j++) {
                String item = arr[i][j];
                int index = item.indexOf(':');
                if (j == 0) resultLine.append("Студент " + (arr[i][j]).substring(index + 1));
                if (j == 1) resultLine.append(" получил " + (arr[i][j]).substring(index + 1));
                if (j == 2) resultLine.append(" по предмету " + (arr[i][j]).substring(index + 1) + ".");
            }
            System.out.println(resultLine);
        }
    }
}
