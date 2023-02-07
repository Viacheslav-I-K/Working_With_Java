import java.util.Arrays;
import java.util.List;

/*
 * Задан целочисленный список ArrayList. Найти минимальное, 
 * максимальное и среднее ариф из этого списка.
 */

public class task3 {
    public static void main(String[] args) {
        Integer[] nums = {12, 5, 7, 6, 47, 2, 3, 11, 17, 4};
        List<Integer> numbers = Arrays.asList(nums);
        FindMinAndMax(numbers);
    }

    public static void FindMinAndMax(List<Integer> nums) {
        int numMin = nums.get(0);
        int numMax = nums.get(0);
        double numAverage = 0;
        for (Integer item : nums) {
            if (item < numMin) {
                numMin = item;
            }
            else if (item > numMax) {
                numMax = item;
            }
            numAverage += item;
        }
        System.out.println("Минимальное значение в списке: " + numMin);
        System.out.println("Максимальное значение в списке: " + numMax);
        System.out.println("Среднее арифмитическое элементов списка: " + numAverage / nums.size());
    }
}
