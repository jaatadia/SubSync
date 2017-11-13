package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidTimeRangeException;
import org.jaatadia.subsync.model.exceptions.InvalidTimeStampException;

public class TimeRange implements Synchronizable{

    public TimeStamp start;
    public TimeStamp end;

    public TimeRange(TimeStamp start, TimeStamp end){
        this.start = start;
        this.end = end;
    }

    public TimeRange(String range) throws InvalidTimeRangeException, InvalidTimeStampException {
        String[] timestamps = range.split("-->");
        if(timestamps.length != 2) throw new InvalidTimeRangeException(range);
        start=new TimeStamp(timestamps[0]);
        end=new TimeStamp(timestamps[1]);
        if (start.compareTo(end)>0) throw new InvalidTimeRangeException(range);
    }


    @Override
    public String toString() {
        return start.toString()+" --> "+end.toString();
    }


    public Synchronizable synchronize(int milliseconds) {
        start.synchronize(milliseconds);
        end.synchronize(milliseconds);
        return this;
    }
}
