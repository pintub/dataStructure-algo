package com.bookyourshow.model;

import java.util.List;

//Assume 1-1 screens
public class Cinema {

    private final List<ShowTiming> showTimings;
    private final List<Seat> bookingSpotList; //Composite

    private List<MovieShowTimingMap> movieShowTimingMaps;

    public Cinema(List<ShowTiming> showTimings, List<Seat> bookingSpotList) {
        this.showTimings = showTimings;
        this.bookingSpotList = bookingSpotList;
    }

    //MovieBooking
    //Seat#
    //ShowTiming#
    //addMovieBooking()
    //cancelMovieBooking()
}
