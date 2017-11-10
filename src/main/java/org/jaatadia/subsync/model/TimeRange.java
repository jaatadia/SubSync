package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidRangeException;
import org.jaatadia.subsync.model.exceptions.InvalidTimeStampException;

public class TimeRange {

    private TimeStamp start;
    private TimeStamp end;

    public TimeRange(String range) throws InvalidRangeException, InvalidTimeStampException {
        String[] timestamps = range.split("-->");
        if(timestamps.length != 2) throw new InvalidRangeException(range);

    }

}
