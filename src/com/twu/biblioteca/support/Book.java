package com.twu.biblioteca.support;

import org.joda.time.LocalDate;


public class Book implements Resource {
    public static final int RANGE_OF_TABLE = 19;
    public static final int RANGE_MINUS_DOTS = RANGE_OF_TABLE-2;
    private String Title;
    private String Author;
    private LocalDate Published;
    private Boolean checkedIn;
    private String BookId;
    private String UserId;

    public Book(String title, String author, LocalDate published, Boolean checkedIn, String id) {
        Title = title;
        Author = author;
        Published = published;
        this.checkedIn = checkedIn;
        BookId = id;
    }

    public void invertCheckedFlag() {
        this.checkedIn = !checkedIn;
    }

    public Boolean isCheckedIn() {
        return checkedIn;
    }

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
                ", Published=" + Published;
    }

    @Override
    public String getOriginalTitle() {
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
    public String getPropertyList(String fieldFormatStr) {

        String formatStr = String.format(
                "| %1$s | %1$s | %1$s | %1$s |%n", fieldFormatStr
        );
        return String.format(
                formatStr,
                BookId, isStringTooLong(Title) ? reduceStringAddDots(Title) : Title, isStringTooLong(Author) ? reduceStringAddDots(Author) : Author, getYearPublished()
        );
    }

    private boolean isStringTooLong(String str){
        return str.length() >= RANGE_OF_TABLE;
    }

    private String reduceStringAddDots(String str){
        return str.substring(0,RANGE_MINUS_DOTS).concat("...");
    }

    public String getAuthor() {
        return Author;
    }

    public String getReducedTitle(){
        return this.isStringTooLong(Title) ? reduceStringAddDots(Title) : Title;
    }

    public LocalDate getPublished() {
        return Published;
    }
}
