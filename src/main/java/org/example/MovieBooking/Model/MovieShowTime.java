package org.example.MovieBooking.Model;

import org.example.MovieBooking.Model.Interface.ShowTime;
import org.example.MovieBooking.Model.Interface.Theater;

import java.util.*;

public class MovieShowTime implements ShowTime<Movie> {

    Map<String, List<Theater<Movie>>> movieToTheater;
    Map<String, List<Movie>> theaterToMovie;
    private static MovieShowTime movieShowTime = null;

    private MovieShowTime() {
        movieToTheater = new HashMap<>();
        theaterToMovie = new HashMap<>();
    }

    public static MovieShowTime getInstance() {
        if(Objects.isNull(movieShowTime)) {
            return movieShowTime = new MovieShowTime();
        }
        return movieShowTime;
    }

    @Override
    public void setShow(Movie show, Theater<Movie> theater) {
        // Add the theater to the list of theaters showing the movie
        movieToTheater.putIfAbsent(show.getTitle(), new ArrayList<>());
        movieToTheater.get(show.getTitle()).add(theater);  // Add theater to the movie's list

        // Add the movie to the list of movies being shown at the theater
        theaterToMovie.putIfAbsent(theater.getTheaterName(), new ArrayList<>());
        theaterToMovie.get(theater.getTheaterName()).add(show);  // Add movie to the theater's list
    }

    @Override
    public List<Theater<Movie>> getTheaterByShow(String show) {
        return movieToTheater.getOrDefault(show, null);
    }

    @Override
    public List<Movie> getShowByTheater(String theater) {
        return theaterToMovie.getOrDefault(theater, null);
    }
}
