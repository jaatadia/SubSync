package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidRequestException;
import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;

public class Subtitle implements Synchronizable{

    private int number;
    private TimeRange timeRange;
    private String text;

    public Subtitle(String sub) throws InvalidRequestException {

        String[] lines = sub.trim().split("\n");
        if (lines.length < 2 || !(lines[0].matches("^[0-9]+$"))) throw new InvalidSubtitleException(sub);
        this.number = Integer.parseInt(lines[0]);
        this.timeRange = new TimeRange(lines[1]);
        this.text = "";
        for(int i = 2; i<lines.length;i++) this.text += lines[i] + "\n";
        this.text = this.text.trim();
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
