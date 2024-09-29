package org.example.MovieBooking.Controller;

import org.example.MovieBooking.Model.*;
import org.example.MovieBooking.Model.Interface.Screen;
import org.example.MovieBooking.Model.Interface.Seat;
import org.example.MovieBooking.Model.Interface.ShowTime;
import org.example.MovieBooking.Model.Interface.Theater;
import org.example.MovieBooking.View.MovieView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MovieController {

    private Theater<Movie> theater1;
    private Theater<Movie> theater2;
    private final ShowTime<Movie> showTime;
    private final MovieView  movieView;

    MovieController() {
        ShowRunTime showRunTime = new ShowRunTime(new Date(), new Date());
        Movie movie1 = new Movie("movie1", "descriptionOfMovie1", "comedy", showRunTime);
        MovieScreen screen11 = new MovieScreen(11, movie1);
        List<Screen<Movie>> screenList1 = new ArrayList<>();
        screenList1.add(screen11);
        Movie movie2 = new Movie("movie2", "descriptionOfMovie2", "comedy", showRunTime);
        MovieScreen screen12 = new MovieScreen(12, movie2);
        screenList1.add(screen12);
        Movie movie3 = new Movie("movie3", "descriptionOfMovie3", "comedy", showRunTime);
        MovieScreen screen13 = new MovieScreen(13, movie3);
        screenList1.add(screen13);
        List<Screen<Movie>> screenList2 = new ArrayList<>();
        MovieScreen screen21 = new MovieScreen(21, movie1);
        screenList2.add(screen21);
        MovieScreen screen22 = new MovieScreen(22, movie2);
        screenList2.add(screen22);
        MovieScreen screen23 = new MovieScreen(23, movie3);
        screenList2.add(screen23);
        theater1 = new MovieTheater("theater1", screenList1);
        theater2 = new MovieTheater("theater2", screenList2);
        showTime = MovieShowTime.getInstance();
        movieView = new MovieView();
    }

    public void getAvailableTheaterForAMovie(String movie) {
        List<Theater<Movie>> theaterList = showTime.getTheaterByShow(movie);
        movieView.displayAvailableTheaterForAMovie(theaterList, movie);
    }

    public void getAvailableMovieInATheater(String theater) {
        List<Movie> movieList = showTime.getShowByTheater(theater);
        movieView.displayAvailableMovieInATheater(movieList, theater);
    }

    public void bookMovieTicket(String movie, String theater, int numberOfSeat) {
        List<Theater<Movie>> theaterList = showTime.getTheaterByShow(movie);
        Theater<Movie> movieTheater = null;
        for(Theater<Movie> movieTheater1: theaterList) {
            if(Objects.equals(theater, movieTheater1.getTheaterName())) {
                movieTheater = movieTheater1;
                break;
            }
        }
        if(Objects.nonNull(movieTheater)) {
            for(Screen<Movie> movieScreen: movieTheater.getScreen()) {
                if(Objects.equals(movie, movieScreen.getShow().getTitle())) {
                    List<Seat> seats = movieScreen.bookSeat(numberOfSeat);
                    movieView.seatBookedSuccessfully(theater, movieScreen, seats);
                    return;
                }
            }
        }
        movieView.seatBookedUnsuccessfully();
    }
}
