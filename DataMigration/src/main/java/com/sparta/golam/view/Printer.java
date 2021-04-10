package com.sparta.golam.view;

import java.util.Arrays;

public class Printer {

    public static void print(Object objectToPrint) {
        System.out.println(objectToPrint);
    }

    public static void printError(Object errorMessageToPrint) {
        System.err.println(errorMessageToPrint);
    }

    public static void printArray(Object[] arrayToPrint) {
        System.out.println(Arrays.toString(arrayToPrint));
    }

}
