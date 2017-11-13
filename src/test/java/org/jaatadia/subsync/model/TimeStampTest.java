package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidTimeStampException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeStampTest {


    @Test
    public void invalidTimeStamp() throws Exception {
        String[] values = {"0a:20:01,723","00:70:01,723","00:00:71,723"};

        for(String value : values) {
            try {
                TimeStamp t = new TimeStamp(value);
                assert (false);
            } catch (InvalidTimeStampException t) {
                assert (true);
            }
        }
    }


    @Test
    public void parseAndtoString() throws Exception {
        String value = "00:00:01,723";
        TimeStamp t = new TimeStamp(value);
        assertEquals(value,t.toString());
    }

    @Test
    public void synchronize() throws Exception {
        assertEquals("00:00:01,733",new TimeStamp("00:00:01,723").synchronize(10).toString());
        assertEquals("00:00:02,723",new TimeStamp("00:00:01,723").synchronize(1000).toString());
        assertEquals("00:01:01,723",new TimeStamp("00:00:01,723").synchronize(60000).toString());
        assertEquals("01:00:01,723",new TimeStamp("00:00:01,723").synchronize(3600000).toString());

        assertEquals("00:00:02,023",new TimeStamp("00:00:01,723").synchronize(300).toString());
        assertEquals("00:01:00,023",new TimeStamp("00:00:01,723").synchronize(58300).toString());
        assertEquals("01:00:00,023",new TimeStamp("00:00:01,723").synchronize(3598300).toString());

        assertEquals("00:00:01,423",new TimeStamp("00:00:01,723").synchronize(-300).toString());
        assertEquals("00:01:55,723",new TimeStamp("00:02:01,723").synchronize(-6000).toString());
        assertEquals("00:01:01,723",new TimeStamp("00:02:01,723").synchronize(-60000).toString());
        assertEquals("01:56:01,723",new TimeStamp("02:02:01,723").synchronize(-360000).toString());


        assertEquals("00:00:00,000",new TimeStamp("00:00:01,723").synchronize(-6000).toString());
        assertEquals("00:00:00,000",new TimeStamp("00:02:01,723").synchronize(-600000000).toString());
        assertEquals("99:59:59,999",new TimeStamp("00:02:01,723").synchronize(600000000).toString());
    }
}