package com.twu.biblioteca.support;

public class BookHeader implements DisplayHeader {


    @Override
    public String getHeader(String fieldFormatStr) {
        return String.format("| fieldFormatStr | %-20s | %-20s | %-20s | %-20s", "Book No.", "Title", "Author", "Published", "Available");
    }
}
