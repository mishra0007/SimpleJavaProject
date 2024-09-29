package org.example.MovieBooking.Model;

import org.example.MovieBooking.Model.Interface.Show;

public class Movie implements Show {
    private String title;
    private String description;
    private String genre;
    ShowRunTime showRunTime;
    private int Rating;

    public Movie(String title, String description, String genre, ShowRunTime showRunTime) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.showRunTime = showRunTime;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setRating(int rating) {
        // todo: implement Rating system
    }

    @Override
    public int getRating() {
        // todo: implement Rating system
        return 0;
    }
}
