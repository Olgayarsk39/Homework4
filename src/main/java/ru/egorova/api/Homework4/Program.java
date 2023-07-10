package ru.egorova.api.Homework4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean f = true;
        while (f) {
            System.out.println("Введите номер задачи: ");
            System.out.println("1 - Задача № 1;");
            System.out.println("2 - Задача № 2;");
            System.out.println("3 - Задача № 3;");
            System.out.println("0 - Выход из программы.");
            System.out.println("**************************************");

            int no = Integer.parseInt(scanner.nextLine());

            switch (no) {
                case 1:
                    task1();
                    System.out.println();
                    break;
                case 2:
                    task2();
                    System.out.println();
                    break;
                case 3:
                    task3();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Завершение работы приложения");
                    f = false;
                    break;
                default:
                    System.out.println("Вы указали некорректный номер задачи.\nПовторите попытку ввода. ");
                    break;
            }
        }


    }

    /*
    1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    static void task1() {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println("Элементы списка: " + linkedList);
        System.out.println("Перевернутый список: " + reverse(linkedList));
    }

    static LinkedList<String> reverse(LinkedList<String> linkedList) {
        LinkedList<String> rev_ls = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            rev_ls.add(linkedList.get(i));
        }
        return rev_ls;
    }


/*
2 *. Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
Это задание повышенной сложности, для решения задачи потребуется создать класс-обертку над LinkedList, например:

class MyQueue {
    private LinkedList elements = new LinkedList();

    public MyQueue() { }
    public MyQueue(LinkedList linkedList) {
        this.elements = linkedList;
    }

        .........

}
 */


    static void task2() {
        LinkedList<Integer> ls = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Введите элемент:    ");
        enqueue(ls, scanner.nextInt());
        System.out.println("Добавление и помещение элемента в конец очереди   " + ls);
        System.out.print("Возвращение 1-ого элемента в очереди и его удаление " + dequeue(ls) + "   ");
        System.out.println(ls);
        System.out.print("Возвращение 1-ого элемента в очереди без удаления " + first(ls) + "   ");
        System.out.println(ls);
    }

    public static void enqueue(LinkedList<Integer> ls, int element) {
        ls.add(element);
    }

    public static int dequeue(LinkedList<Integer> ls) {
        int a = ls.getFirst();
        ls.removeFirst();
        return a;

    }

    public static int first(LinkedList<Integer> ls) {
        return ls.getFirst();
    }



    /*
    3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.
*/

    static void task3() {
        LinkedList<Integer> results = new LinkedList<>();
        System.out.println("Работа простого калькулятора");
        System.out.println("В блоке ввода операции Вы можете: ");
        System.out.println("- отменить операцию -- нажмите 'x'");
        System.out.println("- для выхода -- нажмите 'q' ");

        int first;
        int second;
        String operation;
        boolean firts_or_not = true;
        while (true) {
            if (firts_or_not == true) {
                System.out.print("Введите число ->   ");
                first = scanner.nextInt();
                scanner.nextLine();
                firts_or_not = false;
            } else {
                first = results.getLast();
            }

            System.out.print("Введите необходимую операцию (+, -, *, /) ->     ");
            operation = scanner.nextLine();

            if (operation.equals("x")) {
                results.removeLast();
                System.out.println(results.getLast());
                if (results.size() == 0) firts_or_not = true;
                continue;
            }
            if (operation.equals("q")) break;
            System.out.print("Введите еще число ->   ");
            second = scanner.nextInt();
            scanner.nextLine();

            switch (operation) {
                case "+":
                    System.out.println("Результат = " + (first + second));
                    results.add(first + second);
                    break;
                case "-":
                    System.out.println("Результат = " + (first - second));
                    results.add(first - second);
                    break;
                case "*":
                    System.out.println("Результат = " + (first * second));
                    results.add(first * second);
                    break;
                case "/":
                    System.out.println("Результат = " + (first / second));
                    results.add(first / second);
                    break;
                default:
                    System.out.println("Введена неправильная операция!");
                    break;
            }

        }

    }
}