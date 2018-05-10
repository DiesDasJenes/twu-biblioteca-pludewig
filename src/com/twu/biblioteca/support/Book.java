package com.twu.biblioteca.support;

import org.joda.time.LocalDate;

import java.util.Date;

public class Book implements Resource {
    private String Title;
    private Author Author;
    private LocalDate Published;
    private Boolean checkedOut;
    private String BookId;
    private String UserId;

    Book(String title, Author author, LocalDate published, Boolean checkedOut, String id) {
        Title = title;
        Author = author;
        Published = published;
        this.checkedOut = checkedOut;
        BookId = id;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    Boolean isCheckedOut() {
        return checkedOut;
    }

    Boolean isAvailable(){ return !checkedOut; }

    public String getBookId() {
        return BookId;
    }


    public int getYearPublished() {
        return Published.getYear();
    }

    @Override
    public String toString() {
        return  "Title='" + Title + '\'' +
                ", Author=" + Author +
                ", Published=" + Published +
                ", Available=" + !checkedOut;
    }

    @Override
    public String getTitle() {
        return Title;
    }

    @Override
    public String getUserID() {
        return UserId;
    }

    @Override
    public void setUserID(String userID) {
        this.UserId = userID;
    }

    @Override
    public String propertyList(String fieldFormatStr) {
        String formatStr = String.format(
                "%1$ss %1$ss %1$sd %1$sd%n", fieldFormatStr
        );
        return String.format(
                formatStr,
                Title, Author, getYearPublished(), isAvailable()
        );
    }

    @Override
    public String propertyHeaders(String fieldFormatStr) {
        return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s", "Book No.", "Title", "Author", "Published", "Available");
    }
}
