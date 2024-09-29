package org.example.MovieBooking.Model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShowRunTime {
    Date startTime;
    Date endTime;

    public ShowRunTime(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
