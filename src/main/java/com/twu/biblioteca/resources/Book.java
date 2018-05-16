package com.twu.biblioteca.resources;

import org.joda.time.LocalDate;


public class Book implements Resource {
    private static final int RANGE_OF_TABLE = 19;
    private static final int RANGE_MINUS_DOTS = RANGE_OF_TABLE-2;
    private String title;
    private String author;
    private LocalDate published;
    private Boolean checkedIn;
    private String id;

    public Book(String title, String author, LocalDate published, Boolean checkedIn, String id) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.checkedIn = checkedIn;
        this.id = id;
    }

    public void invertCheckedFlag() {
        this.checkedIn = !checkedIn;
    }

    public Boolean isCheckedIn() {
        return checkedIn;
    }

    public int getYearPublished() {
        return published.getYear();
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", author=" + author +
                ", published=" + published;
    }

    @Override
    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return id;
    }

    @Override
    public String getPropertyList(String fieldFormatStr) {

        String formatStr = String.format(
                "| %1$s | %1$s | %1$s | %1$s |%n", fieldFormatStr
        );
        return String.format(
                formatStr,
                id, isStringTooLong(title) ? reduceStringAddDots(title) : title, isStringTooLong(author) ? reduceStringAddDots(author) : author, getYearPublished()
        );
    }

    private boolean isStringTooLong(String str){
        return str.length() >= RANGE_OF_TABLE;
    }

    private String reduceStringAddDots(String str){
        return str.substring(0,RANGE_MINUS_DOTS).concat("...");
    }

    public String getAuthor() {
        return author;
    }

    public String getReducedTitle(){
        return this.isStringTooLong(title) ? reduceStringAddDots(title) : title;
    }

    public String getTitle() {
        return title;
    }

}
