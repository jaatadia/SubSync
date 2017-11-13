package org.jaatadia.subsync.model;

import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtitleTest {

    @Test
    public void invalidSubtitle() throws Exception {

        String[] values = {
                "1\n00:00:01,723 --> --> 00:00:02,723\nfoo\nbar",
                "a1\n00:00:01,723 --> 00:00:02,723\nfoo\nbar",
                "",
                "1",
                "1\n00:0a:01,723 --> 00:00:02,723",
                "1\n00:00:01,723 --> 00:00:00,723",
        };
        for(String value : values) {
            try {
                new Subtitle(value);
                assert (false);
            } catch (InvalidSubtitleException t) {
                assert (true);
            }
        }

    }


    @Test
    public void synchronize() throws Exception {
        assertEquals("1\n00:00:01,723 --> 00:00:02,723\nfoo\nbar",new Subtitle("1\n00:00:00,723 --> 00:00:01,723\nfoo\nbar").synchronize(1000).toString());
    }

}