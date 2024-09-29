package org.example.MovieBooking.Model.Interface;

import java.util.List;

public interface Screen<T> {
    boolean isSeatAvailable(int numberOfSeat);
    List<Seat> bookDeluxeSeat(int numberOfSeat);
    List<Seat> bookPremiumSeat(int numberOfSeat);
    List<Seat> bookSeat(int numberOfSeat);
    void SetShow(T show);
    T getShow();
    int getScreenNumber();
}
