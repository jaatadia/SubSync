package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;

import java.util.ArrayList;
import java.util.Vector;

public class SubtitleGroup {
    private ArrayList<Subtitle> subtitles = new ArrayList<>();

    public SubtitleGroup(String file) throws InvalidSubtitleException {
       String[] subs = file.split("\n\n");
        for (int i = 0;i<subs.length;i++){
            Subtitle s = new Subtitle(subs[i]);
            s.setNumber(i+1);
            this.subtitles.add(s);
        }
    }

    public SubtitleGroup(Vector<Vector<String>> subs) throws InvalidSubtitleException {
        for (int i = 0;i<subs.size();i++){
            Subtitle s = new Subtitle(subs.get(i));
            s.setNumber(i+1);
            this.subtitles.add(s);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Subtitle s : subtitles){
            result += s.toString()+"\n\n";
        }
        return result.trim();
    }

    public Vector<Vector<String>> toVector(){
        Vector<Vector<String>> v=new Vector<>();
        for ( Subtitle s : subtitles){
            v.add(s.toVector());
        }
        return v;
    }


    public void synchronize(int milliseconds, int from){
        synchronize(milliseconds,from,subtitles.size());
    }

    public void synchronize(int milliseconds){
        synchronize(milliseconds,1,subtitles.size());
    }

    public void synchronize(int milliseconds, int from, int to){
        from = (from < 1) ? 1:from;
        to = (to > subtitles.size()) ? subtitles.size():to;
        for (int i= from-1;i<to;i++) {
            subtitles.get(i).synchronize(milliseconds);
        }
    }

}
