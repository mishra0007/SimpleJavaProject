package org.example.MovieBooking.Model;

import org.example.MovieBooking.Model.Interface.Seat;

public class DeluxeSeat implements Seat {

    boolean isAvailable;

    public DeluxeSeat() {
        isAvailable = true;
    }

    @Override
    public boolean isSeatAvailable() {
        return isAvailable;
    }

    @Override
    public void setSeatBookedStatus() {
        isAvailable = false;
    }
}
