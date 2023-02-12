import java.util.LinkedList;
import java.util.List;

/*
 * Пусть дан LinkedList с некоторыми элементами. Реализуйте
 * метод, который вернет "перевернутый" список.
 */

public class task1 {
    public static void main(String[] args) {
        List<Integer> numsList = fillList();
        System.out.println(numsList);
        System.out.println(reversList(numsList));
    }

    public static List<Integer> fillList() {
        List<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            numsList.add(i);
        }
        return numsList;
    }

    public static List<Integer> reversList(List<Integer> list) {
        List<Integer> reverList = new LinkedList<>();
        for (Integer num : list) {
            ((LinkedList<Integer>) reverList).addFirst(num);
        }
        return reverList;
    }
}
