package org.example.MovieBooking.Model;

import org.example.MovieBooking.Model.Interface.Screen;
import org.example.MovieBooking.Model.Interface.Seat;

import java.util.ArrayList;
import java.util.List;

public class MovieScreen implements Screen<Movie> {

    private int numberOfSeatAvailable;
    private int numberOfDeluxeSeatAvailable;
    private int numberOfPremiumSeatAvailable;
    private Seat[] deluxeSeat;
    private Seat[] premiumSeat;
    private Movie movie;
    private int screenNumber;

    public MovieScreen(int screenNumber, Movie movie) {
        numberOfDeluxeSeatAvailable = 50;
        numberOfPremiumSeatAvailable = 50;
        numberOfSeatAvailable = 100;
        deluxeSeat = new DeluxeSeat[50];
        premiumSeat = new PremiumSeat[50];
        for (int i = 0; i < 50; i++) {
            deluxeSeat[i] = new DeluxeSeat();
            premiumSeat[i] = new PremiumSeat();
        }
        this.movie = movie;
        this.screenNumber = screenNumber;
    }

    @Override
    public int getScreenNumber() {
        return screenNumber;
    }

    @Override
    public boolean isSeatAvailable(int numberOfSeat) {
        return numberOfSeatAvailable >= numberOfSeat;
    }

    @Override
    public List<Seat> bookDeluxeSeat(int numberOfSeat) {
        List<Seat> seatList = new ArrayList<>();
        if (numberOfDeluxeSeatAvailable >= numberOfSeat) {
            int count = 0;
            for (Seat seat : deluxeSeat) {
                if (seat.isSeatAvailable() && count < numberOfSeat) {
                    seatList.add(seat);
                    seat.setSeatBookedStatus();
                    numberOfDeluxeSeatAvailable--;
                    numberOfSeatAvailable--;
                    count++;
                }
                if (count == numberOfSeat) break;
            }
        }
        return seatList;
    }

    @Override
    public List<Seat> bookPremiumSeat(int numberOfSeat) {
        List<Seat> seatList = new ArrayList<>();
        if (numberOfPremiumSeatAvailable >= numberOfSeat) {
            int count = 0;
            for (Seat seat : premiumSeat) {
                if (seat.isSeatAvailable() && count < numberOfSeat) {
                    seatList.add(seat);
                    seat.setSeatBookedStatus();
                    numberOfPremiumSeatAvailable--;
                    numberOfSeatAvailable--;
                    count++;
                }
                if (count == numberOfSeat) break;
            }
        }
        return seatList;
    }

    @Override
    public List<Seat> bookSeat(int numberOfSeat) {
        List<Seat> seatList = new ArrayList<>();
        if (numberOfSeatAvailable >= numberOfSeat) {
            // First book premium seats if available
            int premiumSeatsToBook = Math.min(numberOfSeat, numberOfPremiumSeatAvailable);
            seatList.addAll(bookPremiumSeat(premiumSeatsToBook));

            // Then book deluxe seats if more are needed
            int deluxeSeatsToBook = numberOfSeat - seatList.size();
            seatList.addAll(bookDeluxeSeat(deluxeSeatsToBook));
        }
        return seatList;
    }

    @Override
    public void SetShow(Movie show) {
        this.movie = show;
    }

    @Override
    public Movie getShow() {
        return movie;
    }
}
