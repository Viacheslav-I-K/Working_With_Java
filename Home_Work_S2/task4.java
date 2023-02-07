import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
/*
 Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию
 (+ - / *). int a ; int b; String op (op!=”Stop”); (char != ’b’)
 Реализовать логирование.
         */
public class task4 {
    private static final Logger logger = Logger.getLogger(task4.class.getName());
    public static void main(String[] args) {
        
        FileHandler fh;
        try {
            fh = new FileHandler("logCalc.txt");
            logger.addHandler(fh);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner iScanner = new Scanner(System.in);
        boolean val = true;
        while (val == true){
            System.out.println("Введите первое число: ");
            int num_1 = iScanner.nextInt();
            logger.log(Level.INFO, "Введено первое число: " + num_1);
            System.out.println("Введите второе число: ");
            int num_2 = iScanner.nextInt();
            logger.log(Level.INFO, "Введено второе число: " + num_2);
            System.out.println("Введите знак операции для расчета итогового значения: ");
            String op_char = iScanner.next();
            logger.log(Level.INFO, "Введен символ операции: "+ op_char);

            if (op_char.equals("+")){
                int res = Find_amount(num_1, num_2);
                logger.log(Level.INFO, "Итог арифмитического решения: "+ res);
                System.out.println(num_1 + " + " + num_2 + " = " + res);
            }
            else if (op_char.equals("-")){
                int res = Find_difference(num_1, num_2);
                logger.log(Level.INFO, "Итог арифмитического решения: "+ res);
                System.out.println(num_1 + " - " + num_2 + " = " + res);
            }
            else if (op_char.equals("*")){
                int res = Find_multiplication(num_1, num_2);
                logger.log(Level.INFO, "Итог арифмитического решения: "+ res);
                System.out.println(num_1 + " * " + num_2 + " = " + res);
            }
            else if (op_char.equals("/")){
                Double res = Find_division(num_1, num_2);
                logger.log(Level.INFO, "Итог арифмитического решения: "+ res);
                System.out.println(num_1 + " / " + num_2 + " = " + res);
            }
            else{
                logger.log(Level.INFO, "Пользователь ввел не верные данные");
                System.out.println("Вы ввели что то не то!");
            }
            System.out.println("Для окончания работы с калькулятором введите 'Stop'. Для продолжения нажмите '+': ");
            String stop_char = iScanner.next();
            logger.log(Level.INFO, "Решение пользователя о продолжении работы с калькулятором: "+ stop_char);
            val = stop_char.equals("+");
            logger.log(Level.INFO, "Продолжить работу с калькулятором: "+ val);
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
