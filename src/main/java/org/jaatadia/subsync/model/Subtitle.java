package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;

import java.util.Arrays;

public class Subtitle implements Synchronizable{

    private int number;
    private TimeRange timeRange;
    private String text;

    public static Subtitle createNetx(Subtitle s, int duration,String text){
        TimeStamp start = s.timeRange.end.clone();
        TimeStamp end = s.timeRange.end.clone();
        end.synchronize(duration);
        TimeRange range = new TimeRange(start,end);
        return new Subtitle(s.number+1, range,text);
    }

    private Subtitle(int number, TimeRange timeRange, String text){
        this.number = number;
        this.timeRange = timeRange;
        this.text = text;
    }

    public Subtitle(String sub) throws InvalidSubtitleException {
        String[] lines = sub.trim().split("\n");
        if (lines.length < 2 || !(lines[0].matches("^[0-9]+$"))) throw new InvalidSubtitleException(sub);
        this.number = Integer.parseInt(lines[0]);
        this.timeRange = new TimeRange(lines[1]);
        this.text = String.join("\n",Arrays.copyOfRange(lines,2,lines.length));
    }

    public void setNumber(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }

    public TimeRange getTimeRange(){
        return timeRange;
    }

    public void setText(String text){this.text = String.join("\n", text.split("\n+")); }
    public String getText(){
        return text;
    }


    public Synchronizable synchronize(int milliseconds) {
        timeRange.synchronize(milliseconds);
        return this;
    }

    @Override
    public String toString() {
        return number+"\n"+timeRange+"\n"+text;
    }

}
