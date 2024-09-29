package org.example.MovieBooking.View;

import org.example.MovieBooking.Model.Interface.Screen;
import org.example.MovieBooking.Model.Interface.Seat;
import org.example.MovieBooking.Model.Interface.Show;
import org.example.MovieBooking.Model.Interface.Theater;
import org.example.MovieBooking.Model.Movie;

import java.util.List;

public class MovieView {

    public void displayAvailableTheaterForAMovie(List<Theater<Movie>> theaterList, String movie) {
        System.out.printf("Available Theaters for %s are: \n", movie);
        for (Theater<Movie> theater: theaterList) {
            System.out.println(theater.getTheaterName());
        }
    }

    public void displayAvailableMovieInATheater(List<Movie> movies, String theater) {
        System.out.printf("Available Movie in %s are: \n", theater);
        for (Movie movie: movies) {
            System.out.println(movie.getTitle());
        }
    }

    public void seatBookedSuccessfully(String theater, Screen<Movie> movieScreen, List<Seat> seatList) {
        System.out.printf("You have successfully booked %s in %s which is running on screen %s. Please find the " +
                "seat number below \n", movieScreen.getShow().getTitle(), theater, movieScreen.getScreenNumber());
        System.out.println(seatList);
    }

    public void seatBookedUnsuccessfully() {
        System.out.println("OOPS no seat are available");
    }

    public void checkShowAvailability(Theater theater) {
        System.out.println("This Show are available in these theaters: " + theater);
    }

    public void checkTheaterAvailability(Show show) {
        System.out.println("These Show are available in this theaters: " + show);
    }

}
