package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;

import java.util.Vector;

public class Subtitle implements Synchronizable{

    private int number;
    private TimeRange timeRange;
    private String text;

    public Subtitle(String sub) throws InvalidSubtitleException {
        String[] lines = sub.trim().split("\n");
        if (lines.length < 2 || !(lines[0].matches("^[0-9]+$"))) throw new InvalidSubtitleException(sub);
        this.number = Integer.parseInt(lines[0]);
        this.timeRange = new TimeRange(lines[1]);
        this.text = "";
        for(int i = 2; i<lines.length;i++) this.text += lines[i] + "\n";
        this.text = this.text.trim();
    }

    public Subtitle(Vector<String> v) throws InvalidSubtitleException{
        if(v.size()!= 3 || !(v.get(0).matches("^[0-9]+$"))) throw new InvalidSubtitleException(String.join("\n",v));
        this.number = Integer.parseInt(v.get(0));
        this.timeRange = new TimeRange(v.get(1));
        this.text = v.get(2);
        if(number<1) throw new InvalidSubtitleException(this.toString());
    }

    public void setNumber(int number){
        this.number=number;
    }

    public int getNumber(){
        return number;
    }

    public Synchronizable synchronize(int milliseconds) {
        timeRange.synchronize(milliseconds);
        return this;
    }

    @Override
    public String toString() {
        return number+"\n"+timeRange+"\n"+text;
    }

    public Vector<String> toVector(){
        Vector<String> v = new Vector<>();
        v.add(Integer.toString(number));
        v.add(timeRange.toString());
        v.add(text);
        return v;
    }
}
