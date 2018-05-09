package com.twu.biblioteca.support_data;

import java.util.Date;

public class Book {
    private String Name;
    private Author Author;
    private Date Published;
    private Boolean checkedOut;
    private Integer Id;


    public Book(String name, com.twu.biblioteca.support_data.Author author, Date published, Boolean checkedOut, Integer id) {
        Name = name;
        Author = author;
        Published = published;
        this.checkedOut = checkedOut;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public com.twu.biblioteca.support_data.Author getAuthor() {
        return Author;
    }

    public Date getPublished() {
        return Published;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return  "Name='" + Name + '\'' +
                ", Author=" + Author +
                ", Published=" + Published +
                ", checkedOut=" + checkedOut;
    }
}
