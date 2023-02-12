import java.util.LinkedList;
import java.util.List;

/*
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди; dequeue() - возвращает
 * первый элемент из очереди и удаляет его; first() - возвращает
 * первый элемент из очереди, не удаляя
 */

public class task2 {
    public static void main(String[] args) {
        List<Integer> list = fillList();
        System.out.println("Первичный лист: " + list);
        inEndQueue(list, 12);
        System.out.println("Лист после добавления числа 12 в конец очереди: " + list);
        System.out.println("Возвращаемый первый элемент с удалением из списка = " + returnFirstElemDel(list));
        System.out.println("Получившийся список после удаления 1 элемента: " + list);
        System.out.println("Возвращаемый первый элемент без удаления из списка = " + returnFirstElem(list));
        System.out.println("Итоговый список: " + list);
    }

    public static List<Integer> fillList() {
        List<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            numsList.add(i);
        }
        return numsList;
    }

    public static void inEndQueue(List<Integer> list, Integer num) {
        ((LinkedList<Integer>) list).addLast(num);
        //return list;
    }

    public static Integer returnFirstElemDel(List<Integer> list) {
        Integer returnElem;
        returnElem = ((LinkedList<Integer>) list).pollFirst();
        return returnElem;
    }

    public static Integer returnFirstElem(List<Integer> list) {
        Integer firstElem = ((LinkedList<Integer>) list).peekFirst();
        return firstElem;
    }
}
