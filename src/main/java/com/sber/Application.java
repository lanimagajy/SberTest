package com.sber;

/**
 * @author Anton Girin
 */
public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }


    public void start() {
        Calculation calculation = new Calculation();
        System.out.println(calculation
                .isBalanced("((()))()(()())()"));
        System.out.println(calculation
                .findNumber(new int[]{1, 2, 7, -5, 10, 2, 2, -7}, 30));

    }


}
