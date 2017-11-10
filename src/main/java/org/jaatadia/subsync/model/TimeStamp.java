package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidTimeStampException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeStamp implements Synchronizable, Comparable<TimeStamp>{

    private int hours;
    private int minutes;
    private int seconds;
    private int millis;

    private static Pattern regex = Pattern.compile("^([0-9]{2}):([0-5][0-9]):([0-5][0-9]),([0-9]{3})$");

    public TimeStamp(String time) throws InvalidTimeStampException {
        Matcher res = regex.matcher(time.trim());
        if (!res.matches()) throw new InvalidTimeStampException(time);
        hours = Integer.parseInt(res.group(1));
        minutes = Integer.parseInt(res.group(2));
        seconds = Integer.parseInt(res.group(3));
        millis = Integer.parseInt(res.group(4));
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d,%03d",hours,minutes,seconds, millis);
    }

    public Synchronizable synchronize(int milliseconds) {

        millis += milliseconds%1000;
        seconds += (milliseconds/1000)%60;
        minutes += (milliseconds/(60000))%60;
        hours += milliseconds/3600000;
        balance();

        return this;
    }

    private void balance(){
        if(millis <0) {
            millis +=1000;seconds-=1;}
        if(millis >=1000) {
            millis -=1000;seconds+=1;}
        if(seconds<0) {seconds+=60;minutes-=1;}
        if(seconds>=60) {seconds-=60;minutes+=1;}
        if(minutes<0) {minutes+=60;hours-=1;}
        if(minutes>=60) {minutes-=60;hours+=1;}

        if(hours > 99) maxTimeStamp();
        if(hours < 0) minTimeStamp();

    }

    private void maxTimeStamp(){
        hours = 99;
        minutes = 59;
        seconds = 59;
        millis = 999;
    }

    private void minTimeStamp(){
        hours = 0;
        minutes = 0;
        seconds = 0;
        millis = 0;
    }

    private int toMillis(){
        return hours*3600000 + minutes * 60000 + seconds *1000 + millis;
    }

    public int compareTo(TimeStamp o) {
        return toMillis()-o.toMillis();
    }
}
