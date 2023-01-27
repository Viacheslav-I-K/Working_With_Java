import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        /*
        Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
         */
        System.out.println("Введите число n: ");
        Scanner iScanner = new Scanner(System.in);
        int num = iScanner.nextInt();
        System.out.println("Сумма чисел от 1 до " + num + " = " + Amount_numbers(num));
        System.out.println("Произведение чисел от 1 до " + num + " = " + Composition_numbers(num));

    }
    // Произведение чисел от 1 до n
    public static int Composition_numbers(Integer n){
        int res = 1;
        for (int i = 2; i <= n; i++) {
           res *= i;
        }
        return res;
    }
    // Сумма чисел от 1 до n
    public static int Amount_numbers(Integer n){
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }
}
