import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * Реализуйте структуру телефонной книги с помощью HashMap, 
 * учитывая, что 1 человек может иметь несколько телефонов.
 */

public class task1 {
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        PrintDataHumans( DataHumans());  
    }

    public static Map<String, String> DataHumans() {
        Map<String, String> dataHumans = new HashMap<>();
        boolean condition = true;
        while (condition) {
            System.out.println("Введите Фамилию и Имя через пробел: ");
            String name = iScanner.nextLine();
            System.out.println("Введите один или несколько номеров телефона через пробел: ");
            String phone = iScanner.nextLine();
            dataHumans.put(name, phone);
            System.out.println("Для продолжения ввода данных нажмите 'Enter'" + "\n" + "Введите 'stop' для прекращения работы программы.");
            String cond = iScanner.nextLine();
            if (!cond.equals("")) condition = false;
        }
        iScanner.close();
        return dataHumans;
    }

    public static void PrintDataHumans(Map<String, String> dataHumans) {
        for (Map.Entry<String, String> elem : dataHumans.entrySet()) {
            System.out.println("Фамилия/Имя => " + elem.getKey() + "\n" + "Телефон => " + elem.getValue());
        }
    }
}
