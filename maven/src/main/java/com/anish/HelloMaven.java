package com.anish;

/**
 * The smallest example for running a Java class through Maven.
 */
public class HelloMaven {

    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "Maven learner";

        System.out.println("Hello, " + name + "!");
        System.out.println("This class was compiled from src/main/java.");
    }
}
