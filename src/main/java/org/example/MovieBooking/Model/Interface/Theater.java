package org.example.MovieBooking.Model.Interface;

import java.util.List;

public interface Theater<T> {
    List<Screen<T>> getScreen();
    String getTheaterName();
}
