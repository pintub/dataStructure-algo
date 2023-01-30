package com.bookyourshow.model;

import java.time.Instant;

public class ShowTiming {

    private final Instant fromTime;
    private final Instant toTime;

    public ShowTiming(Instant fromTime, Instant toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }
}
