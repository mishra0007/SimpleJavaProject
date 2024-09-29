package org.example.MovieBooking.Model;

import org.example.MovieBooking.Model.Interface.Screen;
import org.example.MovieBooking.Model.Interface.Theater;

import java.util.List;

public class MovieTheater implements Theater<Movie> {

    List<Screen<Movie>> screen;
    MovieShowTime movieShowTime;
    String name;

    public MovieTheater(String name, List<Screen<Movie>> screen) {
        this.screen = screen;
        this.name = name;
        movieShowTime = MovieShowTime.getInstance();
        for(Screen<Movie> movieScreen: screen) {
            movieShowTime.setShow(movieScreen.getShow(), this);
        }
    }

    @Override
    public List<Screen<Movie>> getScreen() {
        return screen;
    }

    public MovieShowTime getMovieShowTime() {
        return movieShowTime;
    }

    @Override
    public String getTheaterName() {
        return name;
    }

}
