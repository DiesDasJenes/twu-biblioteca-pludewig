package com.twu.biblioteca.support;

public class BookHeader implements DisplayHeader {


    @Override
    public String getHeader(String fieldFormatStr) {
        return String.format("| " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr +" |", "Book No.", "Title", "Author", "Published", "Available");
    }
}
