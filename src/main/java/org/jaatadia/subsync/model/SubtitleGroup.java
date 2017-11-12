package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class SubtitleGroup {
    private ArrayList<Subtitle> subtitles = new ArrayList<>();

    public SubtitleGroup(String file) throws InvalidSubtitleException {
        String[] subs = file.split("\n\n+");
        for (int i = 0;i<subs.length;i++){
            Subtitle s = new Subtitle(subs[i]);
            s.setNumber(i+1);
            this.subtitles.add(s);
        }
    }

    @Override
    public String toString() {
        return subtitles.stream().map( x -> x.toString() ).reduce( (x, y) -> x+"\n\n"+y ).orElse("").trim();
    }

    public int size(){
        return subtitles.size();
    }

    public Subtitle get(int row){
        return subtitles.get(row);
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
