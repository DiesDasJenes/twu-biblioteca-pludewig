package com.twu.biblioteca.resources;

import org.joda.time.LocalDate;

public class Movie implements Resource {
    private static final int HIGHEST_POSSIBLE_RATING = 10;
    private StringFormatter stringFormatter;
    private String id;
    private String title;
    private LocalDate published;
    private String director;
    private int rating;
    private boolean checkedIn;

    public Movie(String id, String title, LocalDate published, String director, int rating, boolean checkedIn) {
        this.id = id;
        this.title = title;
        this.published = published;
        this.director = director;
        this.rating =   reduceRatingOutOfRange(rating);
        this.checkedIn = checkedIn;
        stringFormatter = new StringFormatter();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String ID) {
        this.id = ID;
    }

    public int getYear(){
        return this.published.getYear();
    }

    public String getTitle() {
        return title;
    }

    public String getReducedTitle(){
        return stringFormatter.isStringTooLong(title) ? stringFormatter.reduceStringAddDots(title) : title;
    }

    @Override
    public String getPropertyList(String fieldFormatStr) {
        String formatStr = String.format(
                "| %1$s | %1$s | %1$s | %1$s | %1$s |%n", fieldFormatStr
        );
        return String.format(
                formatStr,
                id, stringFormatter.isStringTooLong(title) ? stringFormatter.reduceStringAddDots(title) : title, stringFormatter.isStringTooLong(director) ? stringFormatter.reduceStringAddDots(director) : director, getYear(), getRating() + "/10"
        );
    }

    int getRating() {
        return rating;
    }

    private int reduceRatingOutOfRange(int rating){
        return rating > HIGHEST_POSSIBLE_RATING ? HIGHEST_POSSIBLE_RATING : rating;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    void invertCheckedFlag() {
        this.checkedIn = !isCheckedIn();
    }
}
