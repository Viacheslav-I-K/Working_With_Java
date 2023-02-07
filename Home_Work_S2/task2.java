import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой этерации запишите в лог-файл.
 */

public class task2 {
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        sortArrBubble(getData());
    }

    public static Integer[] getData(){
        System.out.println("Введите числа через пробел: ");
        String[] arr = (iScanner.nextLine()).split(" ");
        int len = arr.length;
        Integer[] intArr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }

    public static Integer[] sortArrBubble(Integer[] arr){
        boolean marker = true;//Маркер для работы цикла While
        int counter = 0;// Маркер для аргумента дозаписи/перезаписи данных в файл
        while (marker == true) {
            int count = 0;//Маркер для прослеживания внесения изменений в массив, если после цикла for равно 0, значит массив отсортирован
            for (int item = 0; item < arr.length - 1; item++) {
                if (arr[item] > arr[item + 1]){
                    Integer memoryItem = arr[item];
                    arr[item] = arr[item + 1];
                    arr[item + 1] = memoryItem;
                    count++;
                }
                boolean app = true;
                if (counter == 0 && item == 0) app = false;
                try(FileWriter fw = new FileWriter("sortBubble.txt", app)){
                    fw.write(Arrays.toString(arr));
                    fw.append('\n');
                    fw.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
                counter ++;
            }
            if (count == 0) marker = false;
        }
        return arr;
    }
}
