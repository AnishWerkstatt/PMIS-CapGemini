package com.anish;
public class BasicCalculator {

    public static int add(int first, int second) {
        return first + second;
    }

    public static int multiply(int first, int second) {
        return first * second;
    }

    public static void main(String[] args) {
        int first = 8;
        int second = 3;

        System.out.println(first + " + " + second + " = " + add(first, second));
        System.out.println(first + " * " + second + " = " + multiply(first, second));

        if (args.length == 2) {
            try {
                int firstArgument = Integer.parseInt(args[0]);
                int secondArgument = Integer.parseInt(args[1]);
                System.out.println("Arguments added = " + add(firstArgument, secondArgument));
            } catch (NumberFormatException exception) {
                System.err.println("Please provide two whole numbers, for example: 12 5");
            }
        }
    }
}
