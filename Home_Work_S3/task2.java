import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Пусть дан произвольный список целых чисел, 
 * удалить из него четные числа
 */

public class task2 {
    public static void main(String[] args) {
        Integer[] nums = {12, 5, 7, 6, 2, 3, 11, 17, 4};
        List<Integer> numbers = Arrays.asList(nums);
        DeleteEvenNumbers(numbers);

    }

    public static void DeleteEvenNumbers(List<Integer> nums)  {
        List<Integer> newNums = new ArrayList<>();
        System.out.print("Первоначальный список: ");
        for (Integer item : nums) {
            System.out.print(item + " ");
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 != 0) {
                newNums.add(nums.get(i));
            }
        }
        System.out.println();
        System.out.print("Итоговый список: ");
        for (Integer item : newNums) {
            System.out.print(item + " ");
        }
    }
}
