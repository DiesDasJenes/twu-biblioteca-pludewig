package com.twu.biblioteca.resources;

public class BookHeader implements DisplayHeader {
    @Override
    public String getHeader(String fieldFormatStr) {
        return String.format("| " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " |", "Book No.", "Title", "Author", "Published");
    }
}
