package com.sber;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Расчет предоставленных заданий
 * @author Anton Girin
 */
public class Calculation {


    /**
     * @param s Строка для расчета согласованных круглых скобок
     * @return true- все круглые скобки согласованы, либо такие отсутствуют,
     * false- есть не согласованные круглые скобки
     * Сложность выполнения данной функции O(n)
     */
    public Boolean isBalanced(String s) {
        // Мапа, как индикатор согласованности скобок.
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        // Лучше всего по сложности подходит Stack, так как он использует LIFO.
        Deque<Character> stackBrackets = new LinkedList<>();
        // В данном цикле проверяется согласованность скобок.
        for (char c : s.toCharArray()) {
            // Проверяем, есть ли открывающая скобка.
            if (brackets.containsValue(c)) {
                // Если есть, добавляем в stack
                stackBrackets.push(c);
                //Проверяем, есть ли закрывающая скобка
            } else if (brackets.containsKey(c)) {
                // Если есть, то стек должен быть не пустым, иначе эта скобка
                // не согласованная и возвращаем false. Если есть согласованная
                // скобка то забираем ее и удаляем.
                if (stackBrackets.isEmpty() || stackBrackets.pop()!=brackets.get(c)) {
                    return false;
                }
            }
        }
        // Пустой ли, так как может быть, что в самом начале строки стоит ')'.
        return stackBrackets.isEmpty();
    }



    /**
     * @param arr - массив для проверки
     * @param numToFind - число, которое в сумме должны дать два элемента из массива
     * @return true- если есть два числа, которые в сумме дадут numToFind,
     * false- если нет.
     * Сложность выполнения данной функции O(n)
     */
    public Boolean findNumber(int[] arr, int numToFind) {
        // Думаем, думаем и понимаем, что лучше всего для пешения данной задачи
        // подходит что нибудь с приставкой Hash. Так как 'фьюх'- очень все быстро
        Set<Integer> set = new HashSet<>();
        // Цикл для поиска нужной пары в массиве
        for (int i : arr) {
            // Если элемент массива минус искомое число присутствует в Set,
            // то бинго, мы победили, вернем true и расходимся.
            if (set.contains(numToFind - i)) {
                return true;
            }
            // Иначе добавляем элемент массива в Set и продолжаем наши изыскания.
            set.add(i);
        }
        // Всяко бывает, бывает, что и не находится такой пары.
        return false;
    }

}
