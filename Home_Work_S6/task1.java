import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
1. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет выборку: имя ноутбука и выбранный критерий . Критерии фильтрации можно хранить в Map.
Сделать выборку.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Пользователь ввел 1. Вывести в виде.
|Имя| ОЗУ|
|--------|-----------|
| Asus | 2ГБ |
| HP | 4ГБ |
| MSI | 6ГБ |
2. Отфильтровать ноутбуки первоначального множества. По имени ноутбука в алфавитном порядке, по цене по убыванию
Например, по алфавиту
|Имя| ОЗУ| Цена
|--------|-----------|-----------|
| Asus | 2ГБ | 4666|
| MSI | 4ГБ |6600|
| HP | 6ГБ| 5555|
 */

public class task1 {
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<NoteBook> setNB = AddNoteBook();
        SortingCriteria(setNB);
        SortPlenty(setNB);
    }

    public static ArrayList<NoteBook> AddNoteBook() {
        NoteBook Asus = new NoteBook("Asus", 2, 128, "Windows 10", 402, 20000);
        NoteBook Asus1 = new NoteBook("Asus", 6, 512, "Windows 11", 422, 26300);
        NoteBook Msi = new NoteBook("MSI", 4, 256, "Windows 10", 396, 23500);
        NoteBook Msi1 = new NoteBook("MSI", 8, 512, "Windows 10", 431, 29400);
        NoteBook Hp = new NoteBook("HP", 6, 512, "Windows 10", 424, 26800);
        NoteBook Hp1 = new NoteBook("HP", 12, 1024, "Windows 11", 454, 33700);
        ArrayList<NoteBook> setNB = new ArrayList<>(Arrays.asList(Asus, Asus1, Msi, Msi1, Hp, Hp1));
        return setNB;
    }

    public static Map<String, String> OutputMenu() {
        Map<String, String> outputFilter = new HashMap<>();
        outputFilter.put("1", "ОЗУ");
        outputFilter.put("2", "Объем ЖД");
        outputFilter.put("3", "Операционная система");
        outputFilter.put("4", "Вес");
        outputFilter.put("5", "Цена");
        return outputFilter;
    }

    public static void SortingCriteria(ArrayList<NoteBook> setNB) {
        boolean userSelection = true;
        while (userSelection) {
            System.out.println("По какому из критериев сортировать? ");
            Map<String, String> outputFilter = OutputMenu();
            for (Map.Entry<String, String> elem : outputFilter.entrySet()) {
                System.out.println(elem.getKey() + " - " + elem.getValue() + ".");
            }
            System.out.print("Введите критерий для сортировки или введите '0' для выхода из меню: ");
            String userInput = iScanner.nextLine();
            System.out.println();
            switch (userInput) {
                case "0":
                    userSelection = false;
                    break;
                case "1":
                    System.out.println("|" + " Марка " + "|" + " RAM \t" + " |");
                    System.out.println("|=======|========|");
                    for (NoteBook elem : setNB) {
                        elem.PrintRAM();
                    }
                    break;
                case "2":
                    System.out.println("|" + " Марка " + "|" + " HDD \t" + " |");
                    System.out.println("|=======|========|");
                    for (NoteBook elem : setNB) {
                        elem.PrintHDD();
                    }
                    break;
                case "3":
                    System.out.println("|" + " Марка " + "|" + "      OS" + "    |");
                    System.out.println("|=======|============|");
                    for (NoteBook elem : setNB) {
                        elem.PrintOS();
                    }
                    break;
                case "4":
                    System.out.println("|" + " Марка " + "|" + " Weight" + " |");
                    System.out.println("|=======|========|");
                    for (NoteBook elem : setNB) {
                        elem.PrintWeight();
                    }
                    break;
                case "5":
                    System.out.println("|" + " Марка " + "|" + " Price" + "  |");
                    System.out.println("|=======|========|");
                    for (NoteBook elem : setNB) {
                        elem.PrintPrice();
                    }
                    break;
                default:
                    System.out.println("Такого критерия сортировки нет.");
            }
        }
    }

    public static void SortPlenty(ArrayList<NoteBook> setNB) {
        boolean userSelection = true;
        while (userSelection) {
            System.out.println("По какому из критериев сортировать? ");
            System.out.println("1 - Цена." + "\n" + "2 - Марка.");
            System.out.print("Введите критерий для сортировки или введите '0' для выхода из меню: ");
            String userInput = iScanner.nextLine();
            System.out.println();
            switch (userInput) {
                case "0":
                    userSelection = false;
                    break;
                case "1":
                    HashMap<NoteBook, Integer> newMap = new HashMap<>();
                    for (NoteBook elem : setNB) {
                        newMap.put(elem, elem.price);
                    }
                    Map<NoteBook, Integer> sortedMap = newMap.entrySet().stream() 
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap( 
                    Map.Entry::getKey, 
                    Map.Entry::getValue, 
                    (a, b) -> { throw new AssertionError(); }, 
                    LinkedHashMap::new 
                    ));
                    ArrayList<NoteBook> revList = new ArrayList<>();
                    for (Map.Entry<NoteBook, Integer> noteBook : sortedMap.entrySet()) {
                        revList.add(noteBook.getKey());
                    }
                    Collections.reverse(revList);
                    System.out.println("|" + " Марка " + "|" + " RAM\t" + "|" + " HDD\t" + "|" + "     OS     " + "|" + " Weight " + "|" + " Price " + "|");
                    System.out.println("|=======|=======|=======|========== =|========|=======|");
                    for (NoteBook noteBook : revList) {
                        noteBook.PrintAll();
                    }
                    break;
                case "2":
                    HashMap<NoteBook, String> newMap2 = new HashMap<>();
                    for (NoteBook elem : setNB) {
                        newMap2.put(elem, elem.name);
                    }
                    Map<NoteBook, String> sortedMapName = newMap2.entrySet().stream() 
                    .sorted(Map.Entry.comparingByValue()) 
                    .collect(Collectors.toMap( 
                    Map.Entry::getKey, 
                    Map.Entry::getValue, 
                    (a, b) -> { throw new AssertionError(); }, 
                    LinkedHashMap::new 
                    ));
                    System.out.println("|" + " Марка " + "|" + " RAM\t" + "|" + " HDD\t" + "|" + "     OS     " + "|" + " Weight " + "|" + " Price " + "|");
                    System.out.println("|=======|=======|=======|========== =|========|=======|");
                    for (Map.Entry<NoteBook, String> noteBook : sortedMapName.entrySet()) {
                        noteBook.getKey().PrintAll();
                    }
                    break;
                default:
                    System.out.println("Такого критерия сортировки нет.");
            }
        }
    }
}
