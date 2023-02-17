import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Пусть дан список сотрудников: Иван Иванов и т.д.
 * Написать программу, которая найдет и выведет повторяющиеся имена
 * с количеством повторений. Отсортировать по убыванию популярности.
 */

public class task2 {
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        PrintRepeatsName(GetListRepeats(GetListName(ListStaff())));
    }

    public static Map<String, String> ListStaff() {
        Map<String, String> dataHumans = new HashMap<>();
        boolean condition = true;
        while (condition) {
            System.out.println("Введите Фамилию и Имя через пробел: ");
            String[] name = iScanner.nextLine().split(" ");
            dataHumans.put(name[0], name[1]);
            System.out.println("Для продолжения ввода данных нажмите 'Enter'. Введите любое слово для прекращения работы программы.");
            String cond = iScanner.nextLine();
            if (!cond.equals("")) condition = false;
        }
        iScanner.close();
        return dataHumans;
    }

    public static List<String> GetListName(Map<String, String> listStaff) {
        List<String> nameList = new ArrayList<>();
        for (Map.Entry<String, String> elem : listStaff.entrySet()) {
            nameList.add(elem.getValue());
        }
        nameList.sort(null);
        return nameList;
    }

    public static Map<String, Integer> GetListRepeats(List<String> nameList) {
        Map<String, Integer> repeatsName = new HashMap<>();
        for (String string : nameList) {
            System.out.print(string + " ");
        }
        System.out.println();
        for (String elem : nameList) {
            if (repeatsName.containsKey(elem)) repeatsName.put(elem, (repeatsName.get(elem) + 1));
            else {
                repeatsName.put(elem, 1);
            }
        }
        return repeatsName;
    }

    public static void PrintRepeatsName(Map<String, Integer> repeatsName) {
        List<Integer> repeats = new ArrayList<>();
        for (Map.Entry<String, Integer> elem : repeatsName.entrySet()) {
            repeats.add(elem.getValue());
        }
        repeats.sort(null);
        Integer len = 0;
        for (int i = repeats.size() - 1; i >= 0; i--) {
            if (len == 0) {
                for (Map.Entry<String, Integer> elem : repeatsName.entrySet()) {
                    if (elem.getValue() == repeats.get(i)) {
                        System.out.println("Имя " + elem.getKey() + "повторяется " + repeats.get(i) + " раз.");
                    }
                }
            }
            else {
                for (Map.Entry<String, Integer> elem : repeatsName.entrySet()) {
                    if (elem.getValue() == repeats.get(i)) {
                        System.out.println("Имя " + elem.getKey() + " повторяется " + repeats.get(i) + " раз.");
                    }
                }
            }
        }
    }
}
