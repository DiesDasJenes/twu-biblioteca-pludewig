package com.twu.biblioteca.support;

import org.joda.time.LocalDate;


public class Book implements Resource {
    private String Title;
    private String Author;
    private LocalDate Published;
    private Boolean checkedIn;
    private String BookId;
    private String UserId;

    Book(String title, String author, LocalDate published, Boolean checkedIn, String id) {
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
    public String getPropertyList(String fieldFormatStr) {

        String formatStr = String.format(
                "| %1$s | %1$s | %1$s | %1$s |%n", fieldFormatStr
        );
        return String.format(
                formatStr,
                BookId, isStringTooLong(Title,19) ? reduceString(Title,17) : Title, isStringTooLong(Author,19) ? reduceString(Author,17) : Author, getYearPublished()
        );
    }

    private boolean isStringTooLong(String str,int range){
        return str.length() >= range;
    }

    private String reduceString(String str,int range){
        return str.substring(0,range).concat("...");
    }

    public String getAuthor() {
        return Author;
    }

    public LocalDate getPublished() {
        return Published;
    }
}
