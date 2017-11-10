package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidTimeRangeException;
import org.jaatadia.subsync.model.exceptions.InvalidTimeStampException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeRangeTest {

    @Test
    public void invalidTimeRange() throws Exception {
        try{
             TimeRange t = new TimeRange("0a:20:01,723 --> 0a:20:01,723");
                assert (false);
        } catch (InvalidTimeStampException t) {
            assert (true);
        }


        String[] values = {
                "00:00:01,723 --> --> 00:00:02,723",
                "00:00:01,723 --> 00:00:02,723 --> 00:00:03,723",
                "00:00:01,723 --> 00:00:00,723"
        };
        for(String value : values) {
            try {
                TimeRange t = new TimeRange(value);
                assert (false);
            } catch (InvalidTimeRangeException t) {
                assert (true);
            }
        }
    }


    @Test
    public void synchronize() throws Exception {
        assertEquals("00:00:01,733 --> 00:00:02,733", new TimeRange("00:00:01,723 --> 00:00:02,723").synchronize(10).toString());
    }
}