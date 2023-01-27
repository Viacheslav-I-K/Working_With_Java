import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        /*
        Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию
        (+ - / *). int a ; int b; String op (op!=”Stop”); (char != ’b’)
         */
        Scanner iScanner = new Scanner(System.in);
        boolean val = true;
        while (val == true){

            System.out.println("Введите первое число: ");
            int num_1 = iScanner.nextInt();
            System.out.println("Введите второе число: ");
            int num_2 = iScanner.nextInt();
            System.out.println("Введите знак операции для расчета итогового значения: ");
            String op_char = iScanner.next();

            if (op_char.equals("+")) System.out.println(num_1 + " + " + num_2 + " = " + Find_amount(num_1, num_2));
            else if (op_char.equals("-")) System.out.println(num_1 + " - " + num_2 + " = " + Find_difference(num_1, num_2));
            else if (op_char.equals("*")) System.out.println(num_1 + " * " + num_2 + " = " + Find_multiplication(num_1, num_2));
            else if (op_char.equals("/")) System.out.println(num_1 + " / " + num_2 + " = " + Find_division(num_1, num_2));
            else System.out.println("Вы ввели что то не то!");

            System.out.println("Для окончания работы с калькулятором введите 'Стоп'. Для продолжения нажмите '+': ");
            String stop_char = iScanner.next();
            val = !stop_char.equals("Стоп");
        }

        iScanner.close();
        System.out.println("Работа с калькулятором закончена!");
    }

    public static int Find_amount(int num_1, int num_2){
        int result = num_1 + num_2;
        return result;
    }

    public static int Find_difference(int num_1, int num_2){
        int result = num_1 - num_2;
        return result;
    }

    public static int Find_multiplication(int num_1, int num_2){
        int result = num_1 * num_2;
        return result;
    }

    public static double Find_division(int num_1, int num_2){
        double result = num_1 / num_2;
        return result;


    }
}
