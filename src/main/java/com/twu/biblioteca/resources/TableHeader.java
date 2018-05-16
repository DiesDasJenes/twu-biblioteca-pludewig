package com.twu.biblioteca.resources;

public class TableHeader {

    public String getBookHeader(String fieldFormatStr) {
        return String.format("| " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " |", "Book No.", "Title", "Author", "Published");
    }

    public String getMovieHeader(String fieldFormatStr) {
        return String.format("| " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " | " + fieldFormatStr + " |", "Movie No.", "Title", "Author", "Published");
    }
}
