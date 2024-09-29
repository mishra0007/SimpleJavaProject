package org.example.MovieBooking.Controller;

public class Main {
    public static void main(String[] args) {
        MovieController movieController = new MovieController();
        //movieController.getAvailableTheaterForAMovie("movie1");
        //movieController.getAvailableMovieInATheater("theater2");
        movieController.bookMovieTicket("movie2", "theater1", 2);
    }
}
