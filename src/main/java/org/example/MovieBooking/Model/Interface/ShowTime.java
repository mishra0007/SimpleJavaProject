package org.example.MovieBooking.Model.Interface;

import java.util.List;

public interface ShowTime<T> {
    void setShow(T show, Theater<T> theater);
    List<Theater<T>> getTheaterByShow(String show);
    List<T> getShowByTheater(String theater);
}
