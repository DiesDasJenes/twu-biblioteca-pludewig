package com.twu.biblioteca.resources;

public class StringFormatter {

    private static final int RANGE_OF_TABLE = 19;
    private static final int RANGE_MINUS_DOTS = RANGE_OF_TABLE-2;

    boolean isStringTooLong(String str){
        return str.length() >= RANGE_OF_TABLE;
    }

    String reduceStringAddDots(String str){
        return str.substring(0,RANGE_MINUS_DOTS).concat("...");
    }
}
